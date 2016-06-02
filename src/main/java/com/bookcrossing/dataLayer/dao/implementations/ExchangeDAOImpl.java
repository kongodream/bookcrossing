package com.bookcrossing.dataLayer.dao.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.ExchangeDAO;
import com.bookcrossing.dataLayer.entity.Exchange;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeDAOImpl implements ExchangeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Exchange exchange) {
        Session session = sessionFactory.getCurrentSession();
        session.save(exchange);
    }
}
