package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.main;

import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KApplicationServerInstance;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KApplicationServerInstance.ApplicationServerStatus;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KTeam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author k.koropovskiy
 */
public class KKMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnitKK");
		try {

			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				KApplicationServerInstance asi = new KApplicationServerInstance(
						ApplicationServerStatus.RUNNING, "test1",
						"127.0.0.1", 1);
				em.persist(asi);

				KTeam team = new KTeam();
				team.setName("hibernate");
				em.persist(team);

				System.out.printf("ID=%d", asi.getId());
				System.out.printf("ID=%s", team.getId());
				em.getTransaction().commit();
			} finally {
				em.close();
			}
		} finally {
			emf.close();

		}

	}
}
