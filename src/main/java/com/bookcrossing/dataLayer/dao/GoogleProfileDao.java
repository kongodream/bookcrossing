package com.bookcrossing.dataLayer.dao;

import com.bookcrossing.dataLayer.entity.external.GoogleProfile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoogleProfileDao {

    @Autowired
    private SessionFactory sessionFactory ;

    public void save(GoogleProfile googleProfile) {
        Session session = sessionFactory.getCurrentSession();
        session.save(googleProfile);
    }

    public GoogleProfile getGoogleProfileByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from GoogleProfile where email = :email");
        query.setString("email",email);
        return (GoogleProfile) query.uniqueResult();
    }
}