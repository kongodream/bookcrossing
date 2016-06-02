var bookCrossing = angular.module('bookCrossing', [
    'ngRoute',
    'ngResource',
    //'ngAnimate',
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
    'genreModule',
    'authorModule',
    'exchangeModule',
    'userModule'
]);

bookCrossing.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/profile', {
                templateUrl: '/resources/js/User/pages/profile.html',
                controller: 'CurrentUserCtrl',
                controllerAs: 'cu'
            })
            .when('/books/:bookId/exchange/new', {
                templateUrl: '/resources/js/Exchange/pages/exchange.html',
                controller: 'ExchangeCtrl',
                controllerAs: 'exchange'
            })
            .when('/books', {
                templateUrl: '/resources/js/Book/pages/books.html',
                controller: 'BooksCtrl'
            })
            .when('/books/:bookId', {
                templateUrl: '/resources/js/Book/pages/book.html',
                controller: 'BookDetailCtrl'
            })
            .when('/createBook', {
                templateUrl: '/resources/js/Book/pages/new_book.html',
                controller: 'BookCreationCtrl'
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