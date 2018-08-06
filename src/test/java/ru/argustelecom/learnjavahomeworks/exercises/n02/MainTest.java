package ru.argustelecom.learnjavahomeworks.exercises.n02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import junit.framework.TestCase;
import ru.argustelecom.learnjavahomeworks.exercises.n02.model.ApplicationServer;
import ru.argustelecom.learnjavahomeworks.exercises.n02.model.DeveloperTeam;

/**
 *
 *
 * @author v.semchenko
 */
public class MainTest extends TestCase {

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_VS");

		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				ApplicationServer appServer = new ApplicationServer();

				DeveloperTeam developerTeam = new DeveloperTeam();
				developerTeam.setName("Команда Инфраструктуры");
				em.persist(developerTeam);

				appServer.setAppServerName("app-ktp");
				appServer.setHost("jboss3");
				appServer.setPortOffSet(0);
				appServer.setInstallDirPath("/jboss_prod");
				appServer.setState("Runnig");
				appServer.addUseByTeam(developerTeam);

				em.persist(appServer);

				//em.refresh(appServer);

				em.getTransaction().commit();

				System.out.println(appServer);
			} finally {
				em.close();
				em.getTransaction().rollback();
			}
		}finally{
			emf.close();
		}
	}

}
