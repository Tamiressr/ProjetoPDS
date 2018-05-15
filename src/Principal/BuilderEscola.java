package Principal;

import Diagrama.Escola;

public abstract class BuilderEscola {
	
	protected Escola escola=new Escola();
	
	public abstract BuilderEscola nomeBuilder(String nome);
	
	public abstract BuilderEscola telefoneFixoBuilder(String telefoneFixo);
	
	public abstract BuilderEscola telefoneCelularBuilder(String telefoneCelular);
	
	public abstract BuilderEscola nivelBuilder(String nivel);
	
	public abstract BuilderEscola emailBuilder(String email);
	
	public abstract BuilderEscola senhaBuilder(String senha);
	
	public abstract BuilderEscola linkBuilder(String link);
	
	public abstract BuilderEscola cnpjBuilder(String cnpj);
	
	public abstract BuilderEscola enderecoBuilder(String rua,String numero,String bairro,String CEP,String cidade);
	
	public Escola getEscola() {
		return escola;
	}
		
}
