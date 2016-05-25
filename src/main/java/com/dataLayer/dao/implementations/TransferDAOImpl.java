package com.dataLayer.dao.implementations;

import com.dataLayer.dao.interfaces.TransferDAO;
import com.dataLayer.entity.Transfer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class TransferDAOImpl implements TransferDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Transfer transfer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(transfer);
    }

    @Override
    public void closeTransfer(Transfer transfer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(transfer);
    }

    @Override
    public Transfer getTransferById(int transferId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from transfer where id = :transferId");
        return (Transfer) query.setLong("transferId", transferId).uniqueResult();
    }

    @Override
    public List<Transfer> getListOfBookByUser(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from transfer where user_id = :userId");
        return (List<Transfer>) query.setLong("userId", userId).list();
    }

    @Override
    public List<Transfer> getListOfBookTransfer(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from transfer where book_id = :bookId");
        return (List<Transfer>) query.setLong("bookId", bookId).list();
    }
}
