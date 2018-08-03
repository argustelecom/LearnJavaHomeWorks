package ru.levelp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.spi.ValidationProvider;

public class Main {
    public static void main(String[] args) throws Exception {
//        Class.forName("org.h2.Driver", true, Main.class.getClassLoader());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Teacher t = new Teacher();
        t.setName("t");
        t.setDegree(Degree.PhD);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        for (ConstraintViolation<?> v : factory.getValidator().validate(t))  {
            System.out.println(v.getMessage());
        }

        em.persist(t);

        em.getTransaction().commit();



        em.close();

        emf.close();
    }
}
