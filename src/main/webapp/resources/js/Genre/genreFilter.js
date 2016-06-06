angular.module('filters', [])
    .filter('genreFilter', ['_', function (_) {
        return function (books, selectedGenre) {
            var selectedBooks = books;
            if (!_.isEmpty(selectedGenre) && !_.isUndefined(books) && !_.isEmpty(selectedBooks) && !_.isEmpty(books)) {
                selectedBooks = [];
                _.each(books, function (book) {
                    if (_.isEqual(book.genre.id, selectedGenre.id)) selectedBooks.push(book);

                });
                return selectedBooks;
            }
            return books;
        }
    }]);


