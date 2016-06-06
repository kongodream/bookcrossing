var genreModule = angular.module('genreModule', []);

genreModule.factory('GenreService', ['$http', '$q', function ($http, $q) {
    var genreService = {};

    genreService.getGenres = function () {
        return $http.get('/api/genres')
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

    genreService.getBooksByGenre = function (genreTitle) {
        return $http.get('/api/genres/' + genreTitle)
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

