package Controllers;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Endereco;
import Model.Turma;

public class EnderecoController {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EnderecoController() {
		emf = Persistence.createEntityManagerFactory("escola");
		em = emf.createEntityManager();
		
	}
}
