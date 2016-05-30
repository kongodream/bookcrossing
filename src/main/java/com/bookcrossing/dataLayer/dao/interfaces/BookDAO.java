package com.bookcrossing.dataLayer.dao.interfaces;

import com.bookcrossing.dataLayer.entity.Book;

import java.util.List;

public interface BookDAO {
    void save(Book book);

    List<Book> getListOfAllBooks();

    Book getBookById(int id);

    void setOwner(int bookId, int ownerId);

    void setOwner(int bookId);
}
