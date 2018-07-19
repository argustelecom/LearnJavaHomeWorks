import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) throws SQLException {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
