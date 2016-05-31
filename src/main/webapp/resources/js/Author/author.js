angular.module('authorModule', [])
    .factory('AuthorService', ['$http', '$q', function ($http, $q) {
        var authorService = {};

        authorService.getAllAuthors = function () {
            return $http.get('/api/authors')
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

        authorService.saveBookAuthors = function (bookId, authors) {
            if (bookId) {
                return $http.post("/books/" + bookId + '/authors', authors);
            }
            return $http.post("/books/authors", authors);
        };

        return authorService;
    }]);

