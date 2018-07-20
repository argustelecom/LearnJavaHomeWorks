package ru.argustelecom.learnjavahomeworks.exercises.n02.kk.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KApplicationServerInstance;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KCustomer;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KProduct;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KTeam;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KTeammate;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KUsageType;
import ru.argustelecom.learnjavahomeworks.exercises.n02.kk.dao.KVersion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KKMainTest {

	EntityManagerFactory emf;
	EntityManager em;

	@After
	public void tearDown() throws Exception {
		em.getTransaction().rollback();
		em.close();
		emf.close();
	}

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("PersistenceUnitKK");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	@Test
	public void main() {
		KVersion version = new KVersion("3.20.20");
		KUsageType usageTypeTest = new KUsageType("test", "Для тестирования");
		KUsageType usageTypeDev = new KUsageType("dev", "Для разработки");
		KTeam teamNRI = new KTeam("NRI", "ТУ/NRI");
		KTeam teamTS = new KTeam("NRI", "ТУ/NRI");
		KTeammate t1 = new KTeammate("Иванов И.И", "i.ivanov@argustelecom.ru", "i.ivanov", teamNRI);
		KTeammate t2 = new KTeammate("Петрова И.И", "i.petrova@argustelecom.ru", "i.petrova", teamNRI);
		t2.addToTeam(teamTS);
		KTeammate t3 = new KTeammate("Иванов И.И", "i.ivanov@argustelecom.ru", "i.ivanov", teamTS);
		KCustomer customer = new KCustomer("БигБосс", "ЗАО БольшеБоссов", "bigboss");
		KProduct productNRI = new KProduct("Network Resource Inventory", "TASK", "ТУ/NRI");
		KProduct productTS = new KProduct("TechService", "TASK", "ТУ/NRI");
		customer.addProduct(productNRI);
		customer.addProduct(productTS);
		teamNRI.addProduct(productNRI);
		teamTS.addProduct(productTS);
		KApplicationServerInstance asiTest = new KApplicationServerInstance(
				KApplicationServerInstance.ApplicationServerStatus.RUNNING, "testServer", "192.168.100.40", 0);
		KApplicationServerInstance asiDev = new KApplicationServerInstance(
				KApplicationServerInstance.ApplicationServerStatus.RUNNING, "devServer", "192.168.100.40", 1);
		asiTest.setCustomer(customer);
		asiTest.setVersion(version);
		asiTest.setUsageType(usageTypeTest);
		asiDev.addTeam(teamNRI);
		asiDev.addTeam(teamTS);
		asiDev.setCustomer(customer);
		asiDev.setVersion(version);
		asiDev.setUsageType(usageTypeDev);

		em.persist(version);
		em.persist(usageTypeTest);
		em.persist(usageTypeDev);
		em.persist(teamNRI);
		em.persist(teamTS);
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(customer);
		em.persist(asiDev);
		em.persist(asiTest);
		em.flush();
		em.refresh(productNRI);
		em.refresh(productTS);
		System.out.println(asiDev.toString());
		System.out.println(asiTest.toString());
	}
}