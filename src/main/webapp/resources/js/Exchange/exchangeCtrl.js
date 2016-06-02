angular.module('exchangeModule', [])
    .controller('ExchangeCtrl', ['$location', '$routeParams', 'CurrentUser', 'Book', 'OffersCart',
        function ($location, $routeParams, CurrentUser, Book, OffersCart) {
            var self = this;
            var desiredBookId = $routeParams.bookId;
            self.offersCart = [];
            self.desiredBook = Book.get({id: desiredBookId});
            CurrentUser.get()
                .then(function (currentUser) {
                    self.currentUser = currentUser;
                    return self.currentUser;
                })
                .then(function (currentUser) {
                    self.currentUserBooks = currentUser.books;
                });

            self.addToOffersCart = OffersCart.addToOffersCart;

            self.deleteFromOffersCart = OffersCart.removeFromOffersCart;

            self.getOffersCart = OffersCart.getOffersCart;

        }]);
