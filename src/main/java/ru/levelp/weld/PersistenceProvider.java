package ru.levelp.weld;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class PersistenceProvider {
    @PersistenceContext(unitName = "example")
    private EntityManager em;

//    @Produces
//    @MyDatabase
//    @ApplicationScoped
//    public EntityManagerFactory createFactory() {
//        return Persistence.createEntityManagerFactory(
//                        "example");
//    }

    @Produces
    @MyDatabase
    @Dependent
    public EntityManager createEntityManager() {
        return em;
    }

//    public void dispose(@Disposes @MyDatabase EntityManagerFactory factory) {
//        factory.close();
//    }

//    public void dispose(@Disposes @MyDatabase EntityManager em) {
//        em.close();
//    }
}
