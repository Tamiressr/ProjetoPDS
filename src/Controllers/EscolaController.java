package Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Escola;

public class EscolaController {
	private EntityManagerFactory emf;
	private EntityManager em;
	private static EscolaController escolaController;

	public static EscolaController getEscolaController() {
		if (escolaController == null) {
			escolaController = new EscolaController();
		}
		return escolaController;
	}

	private EscolaController() {
		emf = Persistence.createEntityManagerFactory("escola");
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
	public List<Escola> listar() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select escola from Escola escola ");

		List<Escola> resultados = consulta.getResultList();
		for (Escola p : resultados) {
			System.out.println(p);
		}
		em.getTransaction().commit();
		emf.close();

		return resultados;
	}

	public void atualizar(Escola escola, int id) {
		em.getTransaction().begin();
		Escola e = em.find(Escola.class, id);
		if (e != null) {
			e.setNome(escola.getNome());
			e.setEmail(escola.getEmail());
			e.setCnpj(escola.getCnpj());
			e.setLink(escola.getLink());
			e.setSenha(escola.getSenha());
			e = em.merge(e);
			System.out.println(e.getNome());
		} else {
			System.out.println("escola inexistente");
		}
		em.getTransaction().commit();
		emf.close();
	}
}
