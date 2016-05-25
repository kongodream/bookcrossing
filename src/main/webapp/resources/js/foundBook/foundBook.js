var module = angular.module('foundBook', []);

module.factory('FoundBook', ['$resource',
    function ($resource) {
        return $resource('/api/books/:id/transfer', {id: '@id'}, {
            'save' : {method: 'POST'}
        });
    }]);