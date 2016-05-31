package com.bookcrossing.dataLayer.dao.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.AuthorDAO;
import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        Session session = sessionFactory.getCurrentSession();
        Query allAuthorsQuery = session.createQuery("from Author");
        return allAuthorsQuery.list();
    }
}
