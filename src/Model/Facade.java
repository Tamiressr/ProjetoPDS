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

	public Escola procurarEscolaPorID(int id) {
		List<Escola> list = EscolaController.getEscolaController().listar();
		for (Escola e : list) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public List<String> retornaValoresEscolaPorID(int id) {
		List<Escola> lista = EscolaController.getEscolaController().listar();
		ArrayList<String> list = new ArrayList<String>();
		
		for (Escola e : lista) {
			if (e.getId() == id) {
				list.add(e.getNome());
				list.add(e.getTelefone().get(0).toString());
//				list.add(e.getTelefone().get(1).toString());
//				list.add("");
				list.add("");
				list.add(e.getLink());
				list.add(e.getEmail());
				list.add(e.getSenha());
				list.add(e.getCnpj());
				list.add(e.getRua());
				list.add(e.getNumeroCasa()+"");
				list.add(e.getCidade());
				list.add(e.getCep());
				list.add(e.getBairro());
	
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
		turma.setNumeroDeVagas(Integer.parseInt(array.get(0)));
		turma.setNumeroDeVagasDiponiveis(Integer.parseInt(array.get(1)));
		turma.setNome(array.get(2));
		turma.setTurno(array.get(3));
		
		escola.getTurmas().add(turma);
		turma.setEscola(escola);
	}

}
