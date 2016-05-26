var bookCrossing = angular.module('bookCrossing', [
    'ngRoute',
    'ngResource',
    'ngAnimate',
    'navbarCtrl',
    'sidebarCtrl',
    'bookService',
    'bookCtrls',
    'transferService',
    'ui-notification',
    'ui.select',
    'profileCtrl',
    'userTransfers',
    'foundBook',
    'foundBookCtrl',
    'genreModule'
]);

bookCrossing.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/books', {
                templateUrl: '/resources/js/books/books.html',
                controller: 'booksCtrl'
            })
            .when('/books/:bookId', {
                templateUrl: '/resources/js/books/book.html',
                controller: 'bookDetailCtrl'
            })
            .when('/createBook', {
                templateUrl: '/resources/js/books/newBook.html',
                controller: 'bookCreationCtrl'
            })
            .when('/myBooks', {
                templateUrl: '/resources/js/profile/myBooks.html',
                controller: 'profileCtrl'
            })
            .when('/foundBook', {
                templateUrl: '/resources/js/foundBook/foundBook.html',
                controller: 'FoundBookCtrl'
            })
            .otherwise({
                redirectTo: '/books'
            });

    }]);