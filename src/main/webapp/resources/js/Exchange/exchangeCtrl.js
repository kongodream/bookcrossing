angular.module('exchangeModule', [])
    .controller('ExchangeCtrl', ['$location', '$routeParams', 'CurrentUser', 'Book', 'OffersCart', 'ExchangeService',
        function ($location, $routeParams, CurrentUser, Book, OffersCart, ExchangeService) {
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

            self.sendExchange = function () {

                for (var i = 0; i < self.offersCart.length; i++) {
                    delete self.offersCart[i].added;
                }
                ExchangeService.saveExchange(desiredBookId, self.offersCart).then(function (res) {
                    redirectToDesiredBook(self.desiredBook.id);
                    Notification("You've sent request!");
                });
                self.offersCart = [];
            };

            function redirectToDesiredBook(id) {
                $location.path('/books/' + id);
            };

        }]);

//self.sendExchange = function () {
//    var currentUser = {
//        id: self.currentUser.id,
//        email: self.currentUser.email,
//        name: self.currentUser.name,
//        familyName: self.currentUser.familyName,
//        picture: self.currentUser.picture
//    };
//
//    var exchange = {
//        creator: currentUser,
//        recipient: self.desiredBook.owner,
//        desiredBook: self.desiredBook,
//        offeredBooks: self.getOffersCart(),
//    };
//    for (var i = 0; i < exchange.offeredBooks.length; i++) {
//        delete exchange.offeredBooks[i].added;
//    }
//    ExchangeService.saveExchange(exchange).then(function (res) {
//        redirectToDesiredBook(self.desiredBook.id);
//        Notification("You've sent request!");
//    });
//    self.offersCart = [];
//};