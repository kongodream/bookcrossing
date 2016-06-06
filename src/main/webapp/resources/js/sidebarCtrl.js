var module = angular.module('sidebarCtrl', []);

module.controller('sidebarCtrl', ['GenreService',
    function (GenreService) {
        var self = this;
        GenreService.getGenres()
            .then(function (data) {
                self.genres = data;
            });
    }]);