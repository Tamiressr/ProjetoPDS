package Principal;

public class EscolaConcreto extends BuilderEscola{

	@Override
	public BuilderEscola nomeBuilder(String nome) {
		super.escola.setNome(nome);
		return this;
	}

	@Override
	public BuilderEscola telefoneFixoBuilder(String telefoneFixo) {
//		super.escola.setFixo(telefoneFixo);
		return this;
	}

	@Override
	public BuilderEscola telefoneCelularBuilder(String telefoneCelular) {
//		super.escola.setCelular(telefoneCelular);
		return this;
	}

	@Override
	public BuilderEscola nivelBuilder(String nivel) {
		super.escola.setNivelDeGoverno(nivel);
		return this;
	}

	@Override
	public BuilderEscola emailBuilder(String email) {
		super.escola.setEmail(email);
		return this;
	}

	@Override
	public BuilderEscola senhaBuilder(String senha) {
		super.escola.setSenha(senha);
		return this;
	}

	@Override
	public BuilderEscola linkBuilder(String link) {
		super.escola.setLink(link);
		return this;
	}

	@Override
	public BuilderEscola cnpjBuilder(String cnpj) {
		super.escola.setCnpj(cnpj);
		return this;
	}

	@Override
	public BuilderEscola enderecoBuilder(String rua, String numero, String bairro, String CEP, String cidade) {
//		super.escola.getEndereco().setBairro(bairro);
//		super.escola.getEndereco().setCep(CEP);
//		super.escola.getEndereco().setCidade(cidade);
//		if(numero!=null) {
//			short nu=(short) Integer.parseInt(numero);
//			super.escola.getEndereco().setNumero(nu);			
//		}
//		super.escola.getEndereco().setRua(rua);
//		
		return this;
	}
	
	

}
