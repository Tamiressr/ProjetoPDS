package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Telefone;

public class TelefoneController {
	private static TelefoneController controller;
	EntityManagerFactory emf;
	EntityManager em;
	
	private TelefoneController() {
		emf = Persistence.createEntityManagerFactory("esse");		
		em = emf.createEntityManager();
	}
	public static TelefoneController getController() {
		if(controller==null) {
			controller=new TelefoneController();
		}
		return controller;
	}
	public void salvar(Telefone telefone) {
		em.getTransaction().begin();
		em.merge(telefone);
		em.getTransaction().commit();
		emf.close();

	}
	
}
