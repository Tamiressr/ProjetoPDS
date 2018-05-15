//package Controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//import Model.Escola;
//
//public class EscolaController {
//	private EntityManagerFactory emf;
//	private EntityManager em;
//	private static EscolaController escolaController;
//
//	public static EscolaController getEscolaController() {
//		if (escolaController == null) {
//			escolaController = new EscolaController();
//		}
//		return escolaController;
//	}
//
//	private EscolaController() {
//		emf = Persistence.createEntityManagerFactory("escola");
//		em = emf.createEntityManager();
//
//	}
//
//	public void salvar(Escola escola) {
//		em.getTransaction().begin();
//		em.merge(escola);
//		em.getTransaction().commit();
//
//		emf.close();
//
//	}
//
//	public int procurarID(Escola escola) {
//		List<Escola> list = listar();
//
//		for (Escola p : list) {
//			if (p.getEmail().equals(escola.getEmail())) {
//				return p.getId();
//			}
//		}
//		return 0;
//	}
//	
//	public Escola procurarEscola(int id) {
//		List<Escola> list = listar();
//
//		for (Escola p : list) {
//			if (p.getId()==id) {
//				return p;
//			}
//		}
//		return null;
//	}
//
//	public void remover(int id) {
//		em.getTransaction().begin();
//		Escola p = em.find(Escola.class, id);
//		if (p != null)
//			em.remove(p);
//		else
//			System.out.println("inexistente");
//		em.getTransaction().commit();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Escola> listar() {
//		em.getTransaction().begin();
//		Query consulta = em.createQuery("select escola from Escola escola ");
//
//		List<Escola> resultados = consulta.getResultList();
//		// for (Escola p : resultados) {
//		// System.out.println(p);
//		// }
//		em.getTransaction().commit();
//		emf.close();
//
//		return resultados;
//	}
//
//	public void atualizar(Escola escola,int id, ArrayList<String> array) {
//		em.getTransaction().begin();
//		Escola e = em.find(Escola.class, id);
////		0 array.add(textFielNome.getText());
////		1 array.add(formattedTextFieldTelefoneCelular.getText());
////		String nivel=niveis[comboBoxNivies.getSelectedIndex()];
////		2 array.add(nivel);
////		3 array.add(frmtdtxtfldTelefonefixo.getText());
////		4 array.add(txtLinkdosite.getText());
////		5 array.add(txtEmail.getText());
////		6 array.add(txtSenha.getText());
////		7 array.add(txtCnpj.getText());
////		
////		8 array.add(txtRua.getText());
////		9 array.add(txtNumero.getText());
////		10 array.add(txtCidade.getText());
////		11 array.add(txtCep.getText());
////		12 array.add(txtBairro.getText());
//
//		if (e != null) {
//			e.setNome(array.get(0));
//			e.setLink(array.get(4));
//			e.setEmail(array.get(5));
//			e.setSenha(array.get(6));
//			e = em.merge(e);
//			em.getTransaction().commit();
//			emf.close();
//		} else {
//			System.out.println("escola inexistente");
//		}
//		
//	}
//}
