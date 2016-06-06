angular.module('exchangeModule')
    .factory('OffersCart', ['$http', function ($http) {
        var offersCart = {};
        var books = [];

        function containsObject(obj) {
            for (var i = 0; i < books.length; i++) {
                if (angular.equals(books[i], obj)) {
                    return true;
                }
            }
            return false;
        }

        offersCart.addToOffersCart = function (book) {
            if (!containsObject(book)) {
                books.push(book);
                book.added = true;
            }
        };

        offersCart.removeFromOffersCart = function (book) {
            if (containsObject(book)) {
                var index = books.indexOf(book);
                books.splice(index, 1);
                delete book.added;
            }
        };

        offersCart.getOffersCart = function () {
            return books;
        };

        offersCart.cleanOffersCart = function () {
            books = [];
        };

        return offersCart;
    }]);