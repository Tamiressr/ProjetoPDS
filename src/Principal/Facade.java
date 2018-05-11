package Principal;

import java.util.ArrayList;

import javax.persistence.Persistence;

import Controllers.Controller;
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
	
	public boolean criarEscola(ArrayList<String> array) {
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
		
		Controller.getController().salvar(escola);
		
		return true;
	}
	
	

}
