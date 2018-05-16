package Model;

public class EscolaConcreto extends BuilderEscola{

	@Override
	public BuilderEscola nomeBuilder(String nome) {
		super.escola.setNome(nome);
		return this;
	}

	@Override
	public BuilderEscola telefoneFixoBuilder(String telefoneFixo) {
		Telefone telefone=new Telefone();
		int a=telefoneFixo.charAt(0)+telefoneFixo.charAt(1);
		telefone.setDdd((short) a);
		String b = null;
		for(int i=2;i<telefoneFixo.length();i++) {
			b=""+telefoneFixo.charAt(i);
		}
		telefone.setNumero(b);
		super.escola.getTelefone().add(telefone);
		return this;
	}

	@Override
	public BuilderEscola telefoneCelularBuilder(String telefoneCelular) {
		Telefone telefone=new Telefone();
		int a=telefoneCelular.charAt(0)+telefoneCelular.charAt(1);
		telefone.setDdd((short) a);
		String b = null;
		for(int i=2;i<telefoneCelular.length();i++) {
			b=""+telefoneCelular.charAt(i);
		}
		telefone.setNumero(b);
		super.escola.getTelefone().add(telefone);
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
		super.escola.getEndereco().setBairro(bairro);
		super.escola.getEndereco().setCep(CEP);
		super.escola.getEndereco().setCidade(cidade);
		if(numero!=null || !numero.equals("")) {
			short nu=(short) Integer.parseInt(numero);
			super.escola.getEndereco().setNumero(nu);			
		}
		super.escola.getEndereco().setRua(rua);
		return this;
	}
	
	

}
