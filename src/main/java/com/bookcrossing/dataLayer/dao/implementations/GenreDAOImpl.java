package com.bookcrossing.dataLayer.dao.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.GenreDAO;
import com.bookcrossing.dataLayer.entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Genre> getAllGenres() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Genre").list();
    }
}

