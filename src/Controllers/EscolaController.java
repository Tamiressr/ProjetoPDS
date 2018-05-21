package Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Model.Escola;

public class EscolaController {
	private EntityManagerFactory emf;
	private EntityManager em;
	private static EscolaController escolaController;
	private static List<Escola> list;

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
		list = listar();
		for (Escola p : list) {
			if (p.getEmail().equals(escola.getEmail()) && p.getSenha().equals(escola.getSenha())
					&& p.getCnpj().equals(escola.getCnpj())) {
				return p.getId();
			}
		}
		return 0;
	}

	public Escola procurarEscola(int id) {
		list = listar();

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

	public List<Escola> listar(){
		return this.listar();
	}
	
	@SuppressWarnings("unchecked")
	public List<Escola> atualizar() {
		em.getTransaction().begin();
		Query consulta = em.createQuery("select escola from Escola escola ");

		List<Escola> resultados = consulta.getResultList();

		em.getTransaction().commit();
		emf.close();
		return resultados;
	}

	public void atualizar(Escola escola,int id, ArrayList<String> array) {
//		0 array.add(textFielNome.getText());
//		1 array.add(formattedTextFieldTelefoneCelular.getText());
//		String nivel=niveis[comboBoxNivies.getSelectedIndex()];
//		2 array.add(nivel);
//		3 array.add(frmtdtxtfldTelefonefixo.getText());
//		4 array.add(txtLinkdosite.getText());
//		5 array.add(txtEmail.getText());
//		6 array.add(txtSenha.getText());
//		7 array.add(txtCnpj.getText());
//		
//		8 array.add(txtRua.getText());
//		9 array.add(txtNumero.getText());
//		10 array.add(txtCidade.getText());
//		11 array.add(txtCep.getText());
//		12 array.add(txtBairro.getText());
		
		em.getTransaction().begin();
		Escola novaEscola = em.find(Escola.class, id);

		if (novaEscola != null) {
			novaEscola.setNome(array.get(0));
			novaEscola.setNivelDeGoverno(array.get(1));
			// novaEscola.setTelefone(array.get(2));
			// novaEscola.setTelefone(array.get(3));
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
			
			atualizar();
		} else {
			System.out.println("escola inexistente");
		}

	}
}
