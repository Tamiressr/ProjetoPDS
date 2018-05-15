package Controllers;

import Model.Endereco;
import Model.Escola;
import Model.Telefone;

public class Teste {
public static void main(String[] args) {

	//EnderecoController end= new EnderecoController();
	//end.criar();
	Escola escola= new Escola();
	Endereco es= new Endereco();
	escola.setEndereco(es);
	//Telefone t= new Telefone();

	EscolaController e=new EscolaController();
	e.salvar(escola);//System.out.println(end==null);
	//Endereco e= new Endereco();
	//System.out.println(e==null);
	//end.salvar(e);
}
}
