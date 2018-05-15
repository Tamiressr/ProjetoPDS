package Principal;

import Diagrama.Escola;

public class Diretor {
	private BuilderEscola builderEscola;

	public Diretor(BuilderEscola escola) {
		this.builderEscola = escola;
	}

	public Escola criarEscola(String nome, String telefoneFixo, String telefoneCelular, String senha, String email,
			String link, String cnpj, String nivel, String rua, String bairro, String numero, String cep,
			String cidade) {
		builderEscola.nomeBuilder(nome);
		builderEscola.telefoneFixoBuilder(telefoneFixo);
		builderEscola.telefoneCelularBuilder(telefoneCelular);
		builderEscola.senhaBuilder(senha);
		builderEscola.emailBuilder(email);
		builderEscola.linkBuilder(link);
		builderEscola.cnpjBuilder(cnpj);
		builderEscola.nivelBuilder(nivel);
		
		builderEscola.enderecoBuilder(rua, numero, bairro, cep, cidade);
		
		return this.builderEscola.getEscola();
	}
}
