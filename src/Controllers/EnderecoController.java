package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Endereco;
import Model.Turma;

public class EnderecoController {
	private EntityManagerFactory emf;
	private EntityManager em;
	private static EnderecoController enderecoController;

	public static EnderecoController getEnderecoController() {
		if (enderecoController == null) {
			enderecoController = new EnderecoController();
		}
		return enderecoController;
	}

	private EnderecoController() {
		emf = Persistence.createEntityManagerFactory("endereco");
		em = emf.createEntityManager();
	}
	
	public void salvar(Endereco endereco) {
		em.getTransaction().begin();
		em.merge(endereco);
		em.getTransaction().commit();
		emf.close();
	}
	

}
