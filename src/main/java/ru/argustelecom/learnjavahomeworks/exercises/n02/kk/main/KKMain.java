package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.main;

import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.ApplicationServerInstance;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.ApplicationServerInstance.ApplicationServerStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author k.koropovskiy
 */
public class KKMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("item-manager-pu");
		EntityManager em = emf.createEntityManager();
		ApplicationServerInstance asi = new ApplicationServerInstance(
				ApplicationServerStatus.RUNNING, "test1",
				"127.0.0.1", 1);
		em.persist(asi);
		System.out.printf("ID=%d",asi.getId());
	}
}
