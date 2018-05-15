package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TelefoneController {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public TelefoneController() {
		emf = Persistence.createEntityManagerFactory("escola");
		em = emf.createEntityManager();
		
	}
}
