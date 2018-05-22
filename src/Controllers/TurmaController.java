package Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		if(turma==null) {
			turma=new TurmaController();
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
		if (t!=null)
			em.remove(t);
		else
			System.out.println("inexistente");
		em.getTransaction().commit();
	}
	
	public void atualizar(Turma turma,int id){
		em.getTransaction().begin();
		Turma t=em.find(Turma.class, id);
		if(t!=null){
			t.setNome(turma.getNome());
			t.setTurno(turma.getTurno());
			t.setNumeroDeVagas(turma.getNumeroDeVagas());
			t.setNumeroDeVagasDiponiveis(turma.getNumeroDeVagasDiponiveis());
			t=em.merge(t);
		}else{
			System.out.println("escola inexistente");
		}
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> listar(){
		em.getTransaction().begin();
		Query consulta= em.createQuery("select turma from Turma turma ");
		
		List<Turma> resultados = consulta.getResultList();
		for (Turma p : resultados) {
			System.out.println(p);
		}
		em.getTransaction().commit();
		emf.close();
		
		return resultados;
	}	
	
	public int procurarID(Turma turma) {
		List<Turma> list = listar();
		for (Turma p : list) {
			if (p.getEscola().getId()== turma.getEscola().getId() && p.getNome().equals(turma.getNome())) {
				return p.getId();
			}
		}
		return 0;
	}
}
