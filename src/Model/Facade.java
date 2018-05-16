package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import Controllers.EscolaController;
import View.JanelaCadastrar;

public class Facade {
	private static Facade facade;
	private EscolaConcreto builderEscola;
	private PreMatricula preMatricula;
	private FeedBack feedback;
	private Diretor diretor;

	private Facade() {
		builderEscola = new EscolaConcreto();
		diretor = new Diretor(builderEscola);
		preMatricula = new PreMatricula();
		feedback = new FeedBack();
	}

	public static Facade getFacade() {
		if (facade == null) {
			facade = new Facade();
		}
		return facade;
	}

	public int criarEscola(ArrayList<String> array) {
		Escola escola = diretor.criarEscola(array);
		EscolaController.getEscolaController().salvar(escola);
		
		return EscolaController.getEscolaController().procurarID(escola);
		
	}

	public void excluirConta(int id) {
		EscolaController.getEscolaController().remover(id);
		///
//		asfsfsdf
		
	}

	public Escola procurarEscolaPorCnpj(String cnpj) {
		List<Escola> list = EscolaController.getEscolaController().listar();
		for (Escola e : list) {
			if (e.getCnpj().equals(cnpj)) {
				return e;
			}
		}
		return null;
	}

	public Escola procurarEscolaPorCnpj(int id) {
		List<Escola> list = EscolaController.getEscolaController().listar();
		for (Escola e : list) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public List<String> procurarEscolaPorCNPJ(int id) {
		List<Escola> lista = EscolaController.getEscolaController().listar();
		ArrayList<String> list = new ArrayList<String>();
		
		for (Escola e : lista) {
			if (e.getId() == id) {
				list.add(e.getNome());
//				list.add(e.getTelefone().get(0).toString());
//				list.add(e.getTelefone().get(1).toString());
				list.add(e.getLink());
				list.add(e.getEmail());
				list.add(e.getSenha());
				list.add(e.getCnpj());
//				list.add(e.getEndereco().getRua());
//				list.add(e.getEndereco().getNumero()+"");
//				list.add(e.getEndereco().getCidade());
//				list.add(e.getEndereco().getCep());
//				list.add(e.getEndereco().getBairro());
	
				return list;
			}
		}
		JOptionPane.showMessageDialog(null, "Nada");
		return null;

	}

	public void atualizar(int id, ArrayList<String> array) {
		Escola escola = EscolaController.getEscolaController().procurarEscola(id);
		EscolaController.getEscolaController().atualizar(escola, id,array);
	}

	public List<Escola> listar() {
		return EscolaController.getEscolaController().listar();
	}
	
	public void salvarTurma(int id, ArrayList<String> array) {
		Escola escola = EscolaController.getEscolaController().procurarEscola(id);
		Turma turma=new Turma();
		escola.getTurmas().add(turma);
	}

}
