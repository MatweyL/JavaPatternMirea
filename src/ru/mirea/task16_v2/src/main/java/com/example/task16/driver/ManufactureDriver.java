package com.example.task16.driver;

import com.example.task16.entity.Manufacture;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class ManufactureDriver implements Driver<Manufacture> {

    private final SessionFactory sessionFactory;
    private Session session;

    public ManufactureDriver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Manufacture manufacture) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(manufacture);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Manufacture> readAll() {
        session = sessionFactory.openSession();
        List<Manufacture> manufactures = session.createQuery("select i from Manufacture i", Manufacture.class).getResultList();
        for (Manufacture manufacture : manufactures) Hibernate.initialize(manufacture.getWorkers());
        session.close();
        return manufactures;
    }

    @Override
    public Manufacture read(Long id) {
        session = sessionFactory.openSession();
        Manufacture manufacture = session.createQuery("from Manufacture where id = :id", Manufacture.class).setParameter("id", id).getSingleResult();
        Hibernate.initialize(manufacture.getWorkers());
        session.close();
        return manufacture;
    }

    @Override
    public boolean update(Manufacture manufacture, Long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Manufacture set name=:n, address=:a where id = :id")
                .setParameter("id", id)
                .setParameter("n", manufacture.getName())
                .setParameter("a", manufacture.getAddress());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Manufacture where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}
