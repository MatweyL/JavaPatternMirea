package com.example.task16;

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
public class WorkerDAO implements Driver<Worker>{
    EntityManager em;
    private final SessionFactory sessionFactory;
    private Session session;

   @Autowired
   WorkerDAO(EntityManager em, SessionFactory sessionFactory) {
       this.em = em;
       this.sessionFactory = sessionFactory;
   }


    @Override
    public List<Worker> readAll() {
        session = sessionFactory.openSession();
        List<Worker> workers = session.createQuery("select i from Worker i", Worker.class).getResultList();
        session.close();
        return workers;
    }

    @Override
    public Worker read(long id) {
        session = sessionFactory.openSession();
        Worker worker = session.createQuery("from Worker where id = :id", Worker.class).setParameter("id", id).getSingleResult();
        session.close();
        return worker;
    }

   List<Worker> findWorkersByFirstName(String firstName) {
       CriteriaBuilder cb = em.getCriteriaBuilder();
       CriteriaQuery<Worker> cq = cb.createQuery(Worker.class);

       Root<Worker> workers = cq.from(Worker.class);
       Predicate addressPredicate = cb.equal(workers.get("firstName"), firstName);
       cq.where(addressPredicate);
       TypedQuery<Worker> query = em.createQuery(cq);
       return query.getResultList();
   }
}
