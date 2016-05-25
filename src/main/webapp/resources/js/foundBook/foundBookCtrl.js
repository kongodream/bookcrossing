var module = angular.module('foundBookCtrl', []);

module.controller('FoundBookCtrl', ['$scope', '$location', '$rootScope',
    function ($scope, $location, $rootScope) {

        $scope.addBook = function() {
            $rootScope.whantToAdd = true;
            $location.path('/books/' + $scope.bookId);
        }
    }]);