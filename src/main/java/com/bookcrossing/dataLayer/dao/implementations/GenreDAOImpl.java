package com.bookcrossing.dataLayer.dao.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.BookDAO;
import com.bookcrossing.dataLayer.dao.interfaces.GenreDAO;
import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GenreDAOImpl implements GenreDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Genre> getAllGenres() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Genre").list();
    }

    @Override
    public List<Book> getBooksByGenre(String title) {
        List<Book> books = bookDAO.getListOfAllBooks();
        return books
                .stream()
                .filter(book -> title.equals(book.getGenre().getTitle()))
                .collect(Collectors.toList());
    }
}

