package ru.argustelecom.learnjavahomeworks.exercises.n02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import junit.framework.TestCase;
import ru.argustelecom.learnjavahomeworks.exercises.n02.model.ApplicationServer;
import ru.argustelecom.learnjavahomeworks.exercises.n02.model.Customer;
import ru.argustelecom.learnjavahomeworks.exercises.n02.model.DeveloperTeam;
import ru.argustelecom.learnjavahomeworks.exercises.n02.model.Module;

/**
 *
 *
 * @author v.semchenko
 */
public class MainTest extends TestCase {

	private final String TEST_CUSTOMER_NAME = "Заказчик_1";

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_VS");

		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				Module module = new Module("system-if");
				em.persist(module);

				DeveloperTeam developerTeam = new DeveloperTeam("Команда Инфраструктуры","АРГУС(TASK)","Команда Инфраструктуры");
				developerTeam.addModule(module);
				em.persist(developerTeam);

				Customer customer = new Customer(TEST_CUSTOMER_NAME, TEST_CUSTOMER_NAME, TEST_CUSTOMER_NAME);
				customer.addModule(module);
				em.persist(customer);

				ApplicationServer appServer = new ApplicationServer("running", "app-ktp", "jboss3", 0, "/jboss_prod");
				appServer.addTeam(developerTeam);
				appServer.setCustomer(customer);
				//запоминнаем объект и передаем его в управление EM
				em.persist(appServer);
				//flush() актуализируем данные в БД из нашего persistence context.
				em.flush();
				//remove - удалит экземпляр
				//merge - обновит состояние сущности в текущим стостоянии контекста сущности
				//detach - удалит объект из контекста persistence, в результате отсоеденит управляемый объект.
				//refresh - Обновит состояние экземпляра из базы данных, заменив изменения, внесенные в объект, если таковые были.
				em.refresh(module);

				System.out.println("[INFO] Сервер: " + appServer.toString() + "\n\n");
				System.out.println("[INFO] Команда разработчиков: " + developerTeam.toString() + "\n\n");
				System.out.println("[INFO] Заказчик: " + customer.toString() + "\n\n");
				System.out.println("[INFO] Модуль: " + module.toString() + "\n\n");


				em.getTransaction().commit();
			} finally {
				em.close();
			}
		}finally{
			emf.close();
		}
	}

}
