package com.example.task16.driver;

import com.example.task16.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class WorkerDriver implements Driver<Worker>{

    private final SessionFactory sessionFactory;
    private Session session;

    public WorkerDriver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Worker worker) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(worker);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Worker> readAll() {
        session = sessionFactory.openSession();
        List<Worker> manufactures = session.createQuery("select i from Worker i", Worker.class).getResultList();
        session.close();
        return manufactures;
    }

    @Override
    public Worker read(Long id) {
        session = sessionFactory.openSession();
        Worker manufacture = session.createQuery("from Manufacture where id = :id", Worker.class).setParameter("id", id).getSingleResult();
        session.close();
        return manufacture;
    }

    @Override
    public boolean update(Worker worker, Long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Worker set firstName=:f, middleName=:m, lastName=:l where id = :id")
                .setParameter("id", id)
                .setParameter("f", worker.getFirstName())
                .setParameter("m", worker.getMiddleName())
                .setParameter("l", worker.getLastName());
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
        Query q = session.createQuery("delete from Worker where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}