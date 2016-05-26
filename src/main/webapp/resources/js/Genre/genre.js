var genreModule = angular.module('genreModule', []);

genreModule.factory('GenreService', ['$http', function ($http) {
    var genreService = {};

    genreService.getGenres = function () {
        return $http.get('/genres')
            .then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while fetching users');
                    return $q.reject(errResponse);
                }
            );
    };

    return genreService;
}]);

