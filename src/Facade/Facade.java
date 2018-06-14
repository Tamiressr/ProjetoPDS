package Facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import BuilderEscola.Diretor;
import BuilderEscola.EscolaConcreto;
import Controllers.DocumentacaoController;
import Controllers.EscolaController;
import Controllers.TurmaController;
import Model.Documentacao;
import Model.Escola;
import Model.FeedBack;
import Model.PreMatricula;
import Model.Turma;
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

		return EscolaController.getEscolaController().procurarID(escola);
	}

	public void excluirConta(int id) {
		EscolaController.getEscolaController().remover(id);

	}

	public Escola procurarEscolaPorID(int id) {
		return EscolaController.getEscolaController().procurarEscola(id);
	}

	public List<String> retornaValoresEscolaPorID(int id) {
		return EscolaController.getEscolaController().retornaValoresEscolaPorID(id);

	}

	public void atualizar(int id, ArrayList<String> array) {
		EscolaController.getEscolaController().atualizar(id, array);
	}

	public void atualizarTurma(int id, int vagas) {
		TurmaController.getTurmaController().atualizar(id, vagas);
	}

	public List<Escola> listar() {
		return EscolaController.getEscolaController().listar();
	}

	public void salvarTurma(int id, ArrayList<String> array) {
		diretor.salvarTurma(id, array);

	}

	public void excluirTurma(int id) {
		TurmaController.getTurmaController().remover(id);
	}

	public void excluirDocumento(int id) {
		DocumentacaoController.getDocumentacaoController().remover(id);
	}

	public int procurarTurma(ArrayList<String> array) {
		return TurmaController.getTurmaController().procurarID(array);
	}

	public List<String> retornarValoresTurmaPorID(int id) {
		return TurmaController.getTurmaController().retornarValoresTurmaPorID(id);
	}

	public void cadastrarDocumento(int id, String nome) {
		diretor.cadastrarDocumento(id, nome);
	}

}
