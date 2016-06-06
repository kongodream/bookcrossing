angular.module('genreModule')
    .controller('GenreCtrl', ['$routeParams', 'GenreService',
        function ($routeParams, GenreService) {
            var self = this;
            var genreTitle = $routeParams.genreTitle;


            GenreService.getBooksByGenre(genreTitle)
                .then(function (response) {
                    self.books = response;
                });
        }]);