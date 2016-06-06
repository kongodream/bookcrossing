var module = angular.module('bookCtrls', []);

module.controller('BooksCtrl', ['Book', 'GenreService', 'AuthorService',
    function (Book, GenreService, AuthorService) {
        var self = this;

        self.genres = [];
        self.selectedAuthors = [];
        self.changeAuthors = function (selectedAuthors) {
            self.selectedAuthors = selectedAuthors;
        };

        self.fetchAllAuthors = function () {
            AuthorService.getAllAuthors()
                .then(function (data) {
                    self.authors = data;
                });
        };
        self.fetchAllAuthors();

        self.fetchAllGenres = function () {
            GenreService.getGenres()
                .then(function (data) {
                    self.genres = data;
                });
        };
        self.fetchAllGenres();

        self.selectedGenre = {};
        self.changeGenres = function (selectedGenres) {
            self.selectedGenre = selectedGenres;
        };
        self.books = Book.query();
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
