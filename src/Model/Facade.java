package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Persistence;

import Controllers.EscolaController;
import View.JanelaCadastrar;


public class Facade {
	private static Facade facade;
	private EscolaConcreto builderEscola;
	private PreMatricula preMatricula;
	private FeedBack feedback;
	private Diretor diretor;
	
	private Facade() {
		builderEscola=new EscolaConcreto();
		diretor=new Diretor(builderEscola);
		preMatricula=new PreMatricula();
		feedback=new FeedBack();
	}
	
	public static Facade getFacade() {
		if(facade==null) {
			facade=new Facade();
		}
		return facade;
	}
	
	public int criarEscola(ArrayList<String> array) {
		Escola escola=diretor.criarEscola(array);
		EscolaController.getEscolaController().salvar(escola);
		
		return escola.getId();
	}
	
	public void excluirConta(int id) {
		List<Escola> list=EscolaController.getEscolaController().listar();
		for(Escola e:list) {
			if(e.getId()==id) {
				EscolaController.getEscolaController().remover(e.getId());
			}
		}
	}
	
	public Escola procurarEscolaPorCnpj(String cnpj) {
		List<Escola> list=EscolaController.getEscolaController().listar();
		for(Escola e:list) {
			if(e.getCnpj().equals(cnpj)) {
				return e;
			}
		}
		return null;
	}
	
	public Escola procurarEscolaPorCnpj(int id) {
		List<Escola> list=EscolaController.getEscolaController().listar();
		for(Escola e:list) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}
	public List<String> procurarEscolaPorCNPJ(int id){
		List<Escola> list=EscolaController.getEscolaController().listar();
		ArrayList<String> lista = new ArrayList<>();
		for(Escola e:list) {
			if(e.getId()==id) {
				lista.add(e.getNome());
				lista.add(e.getLink());
				lista.add(e.getEmail());
				lista.add(e.getSenha());
				
				lista.add(e.getCnpj());
				return lista;
				
//				textFielNome.setText(escola.getNome());
//				txtLinkdosite.setText(escola.getLink());
//				txtEmail.setText(escola.getEmail());
//				txtSenha.setText(escola.getSenha());
////				txtRua.setText(escola.getEndereco().getRua());
////				txtNumero.setText(""+escola.getEndereco().getNumero());
////				txtCidade.setText(escola.getEndereco().getCidade());
////				txtCep.setText(escola.getEndereco().getCep());
////				txtBairro.setText(escola.getEndereco().getBairro());
////				frmtdtxtfldTelefonefixo.setText(escola.getFixo().toString());
////				formattedTextFieldTelefoneCelular.setText(escola.getCelular().toString());
//				txtCnpj.setText("");
			}
		}
		return null;
		
	}
	
	public void atualizar(int id) {
		Escola escola=procurarEscolaPorCnpj(id);
		EscolaController.getEscolaController().atualizar(escola, escola.getId());
	}
	
	public List<Escola> listar(){
		return EscolaController.getEscolaController().listar();
	}
	

}
