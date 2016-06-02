angular.module('bookCtrls')
    .controller('BookCreationCtrl', ['$routeParams', 'GenreService', 'AuthorService', '$location', 'Book', 'Notification',
        function ($routeParams, GenreService, AuthorService, $location, Book, Notification) {
            var self = this;
            self.genres = [];
            self.authors = [];
            self.fetchAllGenres = function () {
                GenreService.getGenres()
                    .then(function (data) {
                        self.genres = data;
                    });
            };
            self.fetchAllAuthors = function () {
                AuthorService.getAllAuthors()
                    .then(function (data) {
                        self.authors = data;
                    });
            };

            self.parseTag = function (enteredTittle) {
                var item = {
                    title: enteredTittle
                };
                return item;
            };

            self.setBookAuthors = function (selectedAuthors) {
                AuthorService.saveBookAuthors(null, selectedAuthors);
            };

            self.newBook = {};
            self.createNewBook = function () {
                Book.save(self.newBook)
                    .$promise
                    .then(function () {
                        $location.path('/books');
                        Notification('Book created!');
                    });
            };

            var bookId = $routeParams.bookId;
            if(bookId) {
                self.book = Book.get({id: bookId});
            }

            self.updateBook = function () {
                var book = new Book(self.book);
                book.$update().then(redirectToNewProject(book.id));
            };

            function redirectToNewProject(id) {
                $location.path('/books/' + id);
            };

            self.fetchAllGenres();
            self.fetchAllAuthors();
        }]);