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
