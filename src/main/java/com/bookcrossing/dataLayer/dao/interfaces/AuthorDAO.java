package com.bookcrossing.dataLayer.dao.interfaces;

import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.Book;

import java.util.List;

public interface AuthorDAO {
    void save(Author author);

    List<Author> getAllAuthors();
}
