package com.dataLayer.dao.implementations;

import com.dataLayer.dao.interfaces.GenreDao;
import com.dataLayer.entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Genre> getAllGenres() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Genre").list();
    }
}
