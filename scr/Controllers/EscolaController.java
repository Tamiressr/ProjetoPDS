package Controllers;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Model.Escola;
import Model.Telefone;

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

	public int procurarID(Escola escola) {
		List<Escola> list = listar();
		for (Escola p : list) {
			if (p.getEmail().equals(escola.getEmail()) && p.getSenha().equals(escola.getSenha())
					&& p.getCnpj().equals(escola.getCnpj())) {
				return p.getId();
			}
		}
		return 0;
	}

	public Escola procurarEscola(int id) {
		List<Escola> list= listar();

		for (Escola p : list) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public void remover(int id) {
		em.getTransaction().begin();
		Escola escola = em.find(Escola.class, id);
		if (escola != null)
			em.remove(escola);
		else
			JOptionPane.showMessageDialog(null, "Conta Não Encontrada");
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Escola> listar() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select escola from Escola escola ");

		List<Escola> list = consulta.getResultList();

		em.getTransaction().commit();
		emf.close();
		return list;
	}

	public void atualizar(int id, ArrayList<String> array) {
		
		em.getTransaction().begin();
		Escola novaEscola = em.find(Escola.class, id);

		if (novaEscola != null) {			
			novaEscola.setNome(array.get(0));
			novaEscola.addTelefone(atualizarTelefone(novaEscola.getTelefone().get(0),array.get(1)));
			novaEscola.addTelefone(atualizarTelefone(novaEscola.getTelefone().get(0),array.get(2)));
			novaEscola.setNivelDeGoverno(array.get(3));
			novaEscola.setLink(array.get(4));
			novaEscola.setEmail(array.get(5));
			novaEscola.setSenha(array.get(6));
			novaEscola.setCnpj(array.get(7));

			novaEscola.setRua(array.get(8));
			novaEscola.setNumeroCasa(Integer.parseInt(array.get(9)));
			novaEscola.setCidade(array.get(10));
			novaEscola.setCep(array.get(11));
			novaEscola.setBairro(array.get(12));

			novaEscola = em.merge(novaEscola);
			em.getTransaction().commit();
			emf.close();
			
		} else {
			System.out.println("escola inexistente");
		}
	}
	public Telefone atualizarTelefone(Telefone telefone,String telefoneNovo) {
		if(!telefoneNovo.equals("") && !telefoneNovo.equals(" ")) {
			String a=telefoneNovo.charAt(1)+""+telefoneNovo.charAt(2);
			int x=Integer.parseInt(a);
			String b = "";
			for(int i=4;i<telefoneNovo.length();i++) {
				if(telefoneNovo.charAt(i)!='-') {
					b=b+telefoneNovo.charAt(i);				
				}
			}
			telefone.setDdd((short)x);
			telefone.setNumero(b);
		}
		return telefone;
	}
}
