package com.dataLayer.dao.implementations;

import com.dataLayer.dao.interfaces.UserDAO;
import com.dataLayer.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    public User getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id = :id");
        return (User) query.setLong("id", id).uniqueResult();
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email = :email");
        return (User) query.setString("email", email).uniqueResult();
    }

    public User findUsersByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email = :email");
        return (User) query.setString("email", email).uniqueResult();
    }

    public List<User> getListOfAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        return (List<User>) query.list();
    }
}