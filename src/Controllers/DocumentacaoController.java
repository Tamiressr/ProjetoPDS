package Controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import Model.Documentacao;
import Model.Turma;

public class DocumentacaoController {

	private EntityManagerFactory emf;
	private EntityManager em;
	private static DocumentacaoController documento;

	public static DocumentacaoController getDocumentacaoController() {
		if (documento == null) {
			documento = new DocumentacaoController();
		}
		return documento;
	}

	public DocumentacaoController() {
		emf = Persistence.createEntityManagerFactory("escola");
		em = emf.createEntityManager();

	}
	public void remover(int id) {
		em.getTransaction().begin();
		Documentacao t = em.find(Documentacao.class, id);
		if (t != null)
			em.remove(t);
		else
			JOptionPane.showMessageDialog(null, "Turma Inexistente");
		em.getTransaction().commit();
	}
	
}