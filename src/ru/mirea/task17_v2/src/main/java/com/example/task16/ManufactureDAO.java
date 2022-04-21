package com.example.task16;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ManufactureDAO implements Driver<Manufacture>{
    EntityManager em;
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public ManufactureDAO(SessionFactory sessionFactory, EntityManager em) {
        this.em = em;
        this.sessionFactory = sessionFactory;
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
    public Manufacture read(long id) {
        session = sessionFactory.openSession();
        Manufacture manufacture = session.createQuery("from Manufacture where id = :id", Manufacture.class).setParameter("id", id).getSingleResult();
        Hibernate.initialize(manufacture.getWorkers());
        session.close();
        return manufacture;
    }

    public List<Manufacture> findManufacturesByAddress(String address) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Manufacture> cq = cb.createQuery(Manufacture.class);

        Root<Manufacture> manufacture = cq.from(Manufacture.class);
        Predicate addressPredicate = cb.equal(manufacture.get("address"), address);
        cq.where(addressPredicate);
        TypedQuery<Manufacture> query = em.createQuery(cq);
        return query.getResultList();
    }
}
