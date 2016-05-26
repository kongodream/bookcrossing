var module = angular.module('bookCtrls', []);

module.controller('booksCtrl', ['$scope', 'Book',
    function ($scope, Book) {
        $scope.books = Book.query();
    }]);

module.controller('bookDetailCtrl', ['$scope', '$routeParams', 'Book', 'GenreService', 'Transfer', 'FoundBook', '$rootScope', '$location',
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

module.controller('bookCreationCtrl', ['$scope', 'GenreService', '$location', 'Book', 'Notification',
    function ($scope, GenreService ,$location, Book, Notification) {
        $scope.genres = GenreService.getGenres();
        $scope.book = {};
        $scope.createBook = function () {
            Book.save($scope.book)
                .$promise
                .then(function () {
                    $location.path('/books');
                    Notification('Book created!');
                });
        }
    }]);