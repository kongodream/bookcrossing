angular.module('filters')
    .filter('authorFilter', ['_', function (_) {
        return function (books, selectedAuthors) {
            var selectedBooks = books;
            if (!_.isEmpty(selectedAuthors) && !_.isUndefined(books) && !_.isEmpty(books)) {
                selectedBooks = [];
                _.each(books, function (book) {
                    var hasRequiredAuthors = _.every(selectedAuthors, function (selectedAuthor) {
                        var bookAuthorIds = _.pluck(book.authors, 'id');
                        return _.contains(bookAuthorIds, selectedAuthor.id);
                    });
                    if (hasRequiredAuthors) selectedBooks.push(book);

                });
                return selectedBooks;
            }
            return books;
        }
    }]);


