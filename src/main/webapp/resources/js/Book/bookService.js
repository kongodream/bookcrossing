var module = angular.module('bookService', []);

module.factory('Book', ['$resource', function ($resource){
    return $resource('/api/books/:id',  {id: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);