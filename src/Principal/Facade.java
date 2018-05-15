package Principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Persistence;

import Controllers.EscolaController;
import Diagrama.Escola;
import Diagrama.FeedBack;
import Diagrama.PreMatricula;
import Janela.JanelaCadastrar;


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
	
	public String criarEscola(ArrayList<String> array) {
		JanelaCadastrar janela=new JanelaCadastrar();
		
		String nome=array.get(0);
		String telefoneCelular=array.get(1);
		String nivel=array.get(2);
		String telefoneFixo=array.get(3);
		String link=array.get(4);
		String email=array.get(5);
		String senha=array.get(6);
		String cnpj=array.get(7);
	
		String rua=array.get(8);
		String numero=array.get(9);
		String cidade=array.get(10);
		String cep=array.get(11);
		String bairro=array.get(12);
		
		Escola escola=diretor.criarEscola(nome, telefoneFixo, telefoneCelular, senha, email, link, cnpj, nivel, rua, bairro, numero, cep, cidade);
		
		EscolaController.getEscolaController().salvar(escola);
		
		return escola.getCnpj();
	}
	
	public void excluirConta(String cnpj) {
		List<Escola> list=EscolaController.getEscolaController().listar();
		for(Escola e:list) {
			if(e.getCnpj().equals(cnpj)) {
				EscolaController.getEscolaController().remover(e.getId());
			}
		}
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
	public List<String> procurarEscolaPorCNPJ(String cnpj){
		List<Escola> list=EscolaController.getEscolaController().listar();
		ArrayList<String> lista = new ArrayList<>();
		for(Escola e:list) {
			if(e.getCnpj().equals(cnpj)) {
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
	
	public void atualizar(String cnpj) {
		Escola escola=procurarEscolaPorCnpj(cnpj);
		EscolaController.getEscolaController().atualizar(escola, escola.getId());
	}
	
	public List<Escola> listar(){
		return EscolaController.getEscolaController().listar();
	}
	

}
