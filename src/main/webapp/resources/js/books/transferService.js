var module = angular.module('transferService', []);

module.factory('Transfer', ['$resource', function ($resource){
    return $resource('/api/books/:id/transfers', {id: '@id'});
}]);