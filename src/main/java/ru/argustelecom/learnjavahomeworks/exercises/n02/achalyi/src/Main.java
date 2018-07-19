import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) throws SQLException {
//		String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
//
//		Connection myConnection = DriverManager.getConnection(url);
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
			EntityManager em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
