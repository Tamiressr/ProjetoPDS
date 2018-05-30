package Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Model.Escola;
import Model.Turma;

public class TurmaController {
	private EntityManagerFactory emf;
	private EntityManager em;
	private static TurmaController turma;

	private TurmaController() {
		emf = Persistence.createEntityManagerFactory("escola");
		em = emf.createEntityManager();
	}

	public static TurmaController getTurmaController() {
		if (turma == null) {
			turma = new TurmaController();
		}
		return turma;
	}

	public void salvar(Turma turma) {
		em.getTransaction().begin();
		em.merge(turma);
		em.getTransaction().commit();
		emf.close();
	}

	public void remover(int id) {
		em.getTransaction().begin();
		Turma t = em.find(Turma.class, id);
		if (t != null)
			em.remove(t);
		else
			JOptionPane.showMessageDialog(null, "Turma Inexistente");
		em.getTransaction().commit();
	}

	public void atualizar(int id, ArrayList<String> array) {
		em.getTransaction().begin();
		Turma t = em.find(Turma.class, id);
		if (t != null) {
			t.setNumeroDeVagasDiponiveis(Integer.parseInt(array.get(0)));
			t.setNumeroDeVagas(Integer.parseInt(array.get(1)));
			t.setNome(array.get(2));
			t.setTurno(array.get(3));
			
			t = em.merge(t);
			em.getTransaction().commit();
			emf.close();
		} else {
			JOptionPane.showMessageDialog(null,"turma inexistente");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Turma> listar() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select turma from Turma turma ");

		List<Turma> resultados = consulta.getResultList();
		for (Turma p : resultados) {
			System.out.println(p);
		}
		em.getTransaction().commit();
		emf.close();

		return resultados;
	}

	public int procurarID(ArrayList<String> array) {
		List<Turma> list = listar();
		for (Turma p : list) {
			if (array.get(0).equals(p.getNumeroDeVagasDiponiveis()) && array.get(1).equals(p.getNumeroDeVagas())
					&& array.get(2).equals(p.getNome()) && array.get(3).equals(p.getTurno())
					&& array.get(4).equals(p.getEscola().getId())) {
				return p.getId();
			}
		}
		return 0;
	}

}
