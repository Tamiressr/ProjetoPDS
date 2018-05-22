package Model;

public class EscolaConcreto extends BuilderEscola {

	@Override
	public BuilderEscola nomeBuilder(String nome) {
		super.escola.setNome(nome);
		return this;
	}

	@Override
	public BuilderEscola telefoneBuilder(String telefoneFixo) {
		if (!telefoneFixo.equals("") && !telefoneFixo.equals(" ")) {
			Telefone telefone = new Telefone();
			String a = telefoneFixo.charAt(1) + "" + telefoneFixo.charAt(2);
			int x = Integer.parseInt(a);
			telefone.setDdd((short) x);
			String b = "";
			for (int i = 4; i < telefoneFixo.length(); i++) {
				if (telefoneFixo.charAt(i) != '-') {
					b = b + telefoneFixo.charAt(i);
				}
			}
			telefone.setNumero(b);
			telefone.setEscola(escola);
			super.escola.addTelefone(telefone);
		}
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
		super.escola.setBairro(bairro);
		super.escola.setCep(CEP);
		super.escola.setCidade(cidade);
		if (numero != null || !numero.equals("")) {
			short nu = (short) Integer.parseInt(numero);
			super.escola.setNumeroCasa(nu);
		}
		super.escola.setRua(rua);
		return this;
	}

}
