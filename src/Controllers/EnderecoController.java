package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Endereco;
public class EnderecoController {
	
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EnderecoController() {
	}
	public void criar() {
		
		emf =Persistence.createEntityManagerFactory("esse");	
		em = emf.createEntityManager();
	}
	
	public void salvar(Endereco end ) {
		em.getTransaction().begin();
		em.merge(end);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}
	

}
