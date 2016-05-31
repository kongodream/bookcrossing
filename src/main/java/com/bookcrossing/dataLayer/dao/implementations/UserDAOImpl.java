package com.bookcrossing.dataLayer.dao.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.UserDAO;
import com.bookcrossing.dataLayer.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(User person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Override
    public User getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id = :id");
        return (User) query.setLong("id", id).uniqueResult();
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email = :email");
        return (User) query.setString("email", email).uniqueResult();
    }

    @Override
    public User findUsersByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email = :email");
        return (User) query.setString("email", email).uniqueResult();
    }

    @Override
    public List<User> getListOfAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        return (List<User>) query.list();
    }
}
