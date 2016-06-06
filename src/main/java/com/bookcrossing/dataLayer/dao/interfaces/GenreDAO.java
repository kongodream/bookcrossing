package com.bookcrossing.dataLayer.dao.interfaces;

import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getAllGenres();

    List<Book> getBooksByGenre(String title);
}
