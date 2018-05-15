package Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Escola;
import Model.Turno;

public class TurnoController {
	private EntityManagerFactory emf;
	private EntityManager em;
	private static TurnoController turnoController;

	public static TurnoController getEscolaController() {
		if (turnoController == null) {
			turnoController = new TurnoController();
		}
		return turnoController;
	}

	private TurnoController() {
		emf = Persistence.createEntityManagerFactory("esse");
		em = emf.createEntityManager();

	}

	public void salvar(Escola escola) {
		em.getTransaction().begin();
		em.merge(escola);
		em.getTransaction().commit();
		emf.close();

	}

	public void remover(int id) {
		em.getTransaction().begin();
		Escola p = em.find(Escola.class, id);
		if (p != null)
			em.remove(p);
		else
			System.out.println("inexistente");
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Turno> listar() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select turn from Turno turno");

		List<Turno> resultados = consulta.getResultList();
		for (Turno p : resultados) {
			System.out.println(p);
		}
		em.getTransaction().commit();
		emf.close();

		return resultados;
	}

	public void atualizar( int id) {
		em.getTransaction().begin();
		Escola e = em.find(Escola.class, id);
		if (e != null) {
//			e.setNome(escola.getNome());
//			e.setEmail(escola.getEmail());
//			e.setCnpj(escola.getCnpj());
//			e.setLink(escola.getLink());
//			e.setSenha(escola.getSenha());
			e = em.merge(e);
			System.out.println(e.getNome());
		} else {
			System.out.println("escola inexistente");
		}
		em.getTransaction().commit();
		emf.close();
	}

}
