angular.module('exchangeModule', [])
    .controller('ExchangeCtrl', ['$location', '$routeParams', 'CurrentUser', 'Book',
        function ($location, $routeParams, CurrentUser, Book) {
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

            self.addToOffersCart = function (book) {
                self.offersCart.push(book);
            }

        }]);
