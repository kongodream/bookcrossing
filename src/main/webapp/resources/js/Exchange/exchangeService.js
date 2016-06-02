angular.module('exchangeModule')
    .factory('ExchangeService', ['$http', '$q', function ($http, $q) {
        var exchangeService = {};

        exchangeService.saveExchange = function (desiredBookId, exchange) {
            return $http.post('/api/books/' + desiredBookId + '/exchanges', exchange)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
                );
        };

        return exchangeService;
    }]);
