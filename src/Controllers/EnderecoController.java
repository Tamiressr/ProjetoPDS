package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EnderecoController {
	private EntityManagerFactory emf;
	private EntityManager em;
	private static EnderecoController enderecoController;

	public static EnderecoController getEscolaController() {
		if (enderecoController == null) {
			enderecoController = new EnderecoController();
		}
		return enderecoController;
	}

	private EnderecoController() {
		emf = Persistence.createEntityManagerFactory("endereco");
		em = emf.createEntityManager();

	}

}
