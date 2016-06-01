angular.module('userModule')
    .controller('CurrentUserCtrl', ['$location', '$routeParams', 'CurrentUser',
        function ($location, $routeParams, CurrentUser) {
            var self = this;
            CurrentUser.get()
                .then(function (currentUser) {
                    self.currentUser = currentUser;
                    return self.currentUser;
                })
                .then(function (currentUser) {
                    self.currentUserBooks = currentUser.books;
                });
        }]);
