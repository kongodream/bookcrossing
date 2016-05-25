var module = angular.module('navbarCtrl', []);

module.controller("navbarCtrl", function ($http, $scope, $rootScope) {
    $http.get("/getCurrentUser").then(function (data) {
        $rootScope.user = data;
    })
});