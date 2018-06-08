package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DocumentacaoController {

	private EntityManagerFactory emf;
	private EntityManager em;

	public DocumentacaoController() {
			emf = Persistence.createEntityManagerFactory("escola");
			em = emf.createEntityManager();
			
		}
}