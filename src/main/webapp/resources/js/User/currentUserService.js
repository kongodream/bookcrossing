angular.module('userModule', [])
    .factory('CurrentUser', function ($http) {
        var currentUser = {};
        currentUser.get = function () {
            return $http.get('/users/getCurrentUser')
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching current user');
                        return $q.reject(errResponse);
                    }
                );
        };
        return currentUser;
    });