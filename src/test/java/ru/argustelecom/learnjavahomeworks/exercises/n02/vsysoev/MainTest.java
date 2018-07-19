package ru.argustelecom.learnjavahomeworks.exercises.n02.vsysoev;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainTest {

    @Test
    public void test() {
        EntityManager em = Persistence.createEntityManagerFactory("vsysoevPU").createEntityManager();
    }
}