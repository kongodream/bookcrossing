var module = angular.module('profileCtrl', []);

module.controller('profileCtrl', ['$scope', '$location', 'UserTransfers', 'Notification',
    function ($scope, $location, UserTransfers, Notification) {
        $scope.transfers = UserTransfers.query();

        $scope.pushTransfer = function (transfer) {
            UserTransfers.save({id: transfer.id}, transfer)
                .$promise
                .then(function () {
                    $location.path('/');
                    Notification('Your book is free!');
                });
        }
    }]);