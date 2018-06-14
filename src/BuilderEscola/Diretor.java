package BuilderEscola;


import java.util.ArrayList;

import Controllers.EscolaController;
import Facade.Facade;
import Model.Documentacao;
import Model.Escola;
import Model.Turma;

public class Diretor {
	private BuilderEscola builderEscola;
	private int id;

	public Diretor(BuilderEscola escola) {
		this.builderEscola = escola;
	}
	
	public Escola criarEscola(ArrayList<String> array) {
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
		
		Escola escola=criarEscola(nome, telefoneFixo, telefoneCelular, senha, email, link, cnpj, nivel, rua, bairro, numero, cep, cidade);
		
		EscolaController.getEscolaController().salvar(escola);
		
		return escola;
	}
	

	public Escola criarEscola(String nome, String telefoneFixo, String telefoneCelular, String senha, String email,
			String link, String cnpj, String nivel, String rua, String bairro, String numero, String cep,
			String cidade) {
		
		builderEscola.nomeBuilder(nome);
		builderEscola.telefoneBuilder(telefoneFixo);
		builderEscola.telefoneBuilder(telefoneCelular);
		builderEscola.senhaBuilder(senha);
		builderEscola.emailBuilder(email);
		builderEscola.linkBuilder(link);
		builderEscola.cnpjBuilder(cnpj);
		builderEscola.nivelBuilder(nivel);
		
		builderEscola.enderecoBuilder(rua, numero, bairro, cep, cidade);
		
		return this.builderEscola.getEscola();
	}
	
	public void salvarTurma(int id, ArrayList<String> array) {
		Escola escola = EscolaController.getEscolaController().procurarEscola(id);

		Turma turma = new Turma();
		turma.setNumeroDeVagasDiponiveis(Integer.parseInt(array.get(0)));
		turma.setNumeroDeVagas(Integer.parseInt(array.get(1)));
		turma.setNome(array.get(2));
		turma.setTurno(array.get(3));

		escola.getTurmas().add(turma);
		turma.setEscola(escola);

	}
	public void cadastrarDocumento(int id, String nome) {
		Escola escola = Facade.getFacade().procurarEscolaPorID(id);
		Documentacao documento = new Documentacao(nome);
		documento.setEscola(escola);
		escola.getDocumentacao().add(documento);
	}

}
