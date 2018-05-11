package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Diagrama.Escola;

public class Controller {
	private static Controller controller;
	EntityManagerFactory emf;
	EntityManager em;
	
	private Controller() {
		emf = Persistence.createEntityManagerFactory("escola");		
		em = emf.createEntityManager();
	}
	public static Controller getController() {
		if(controller==null) {
			controller=new Controller();
		}
		return controller;
	}
	
	
	public void salvar(Escola escola) {
		em.getTransaction().begin();
		em.merge(escola);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public void remover(Escola escola) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete escola from escola where cnpj = "+ escola.getCnpj());
		em.getTransaction().commit();
		emf.close();
	}

}
