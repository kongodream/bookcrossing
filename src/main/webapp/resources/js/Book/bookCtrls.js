var module = angular.module('bookCtrls', []);

module.controller('BooksCtrl', ['$scope', 'Book',
    function ($scope, Book) {
        $scope.books = Book.query();
    }]);

module.controller('BookDetailCtrl', ['$scope', '$routeParams', 'Book', 'GenreService', 'Transfer', 'FoundBook', '$rootScope', '$location',
    function ($scope, $routeParams, Book, GenreService, Transfer, FoundBook, $rootScope, $location) {
        var bookId = $routeParams.bookId;

        $scope.book = Book.get({id: bookId});

        $scope.transfers = Transfer.query({id: bookId});

        $scope.genres = GenreService.getGenres();

        $scope.acceptBook = function () {
            $rootScope.whantToAdd = false;
            FoundBook.save({id: bookId});
            Notification("Congratulations!");
            $location.path('/books/');
        }
    }]);

module.controller('BookCreationCtrl', ['$scope', 'GenreService', 'AuthorService', '$location', 'Book', 'Notification',
    function ($scope, GenreService, AuthorService, $location, Book, Notification) {
        $scope.genres = [];
        $scope.authors = [];
        $scope.fetchAllGenres = function () {
            GenreService.getGenres()
                .then(function (data) {
                    $scope.genres = data;
                });
        };
        $scope.fetchAllAuthors = function () {
            AuthorService.getAllAuthors()
                .then(function (data) {
                    $scope.authors = data;
                });
        };

        $scope.parseTag = function (enteredTittle) {
            var item = {
                title: enteredTittle
            };
            return item;
        };

        $scope.setBookAuthors = function (selectedAuthors) {
            AuthorService.saveBookAuthors(null, selectedAuthors);
        };

        $scope.book = {};
        $scope.createBook = function () {
            Book.save($scope.book)
                .$promise
                .then(function () {
                    $location.path('/books');
                    Notification('Book created!');
                });
        }
        $scope.fetchAllGenres();
        $scope.fetchAllAuthors();
    }]);