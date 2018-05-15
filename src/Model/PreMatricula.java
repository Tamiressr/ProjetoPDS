package Model;

public class PreMatricula {
	private String nomedoInteressado;
	private String cpf;
	
	
	
	


	public String toString() {
		return "PreMatricula [Nome do Interessado=" + nomedoInteressado + ", CPF=" + cpf + "]";
	}

	public String getNomedoInteressado() {
		return nomedoInteressado;
	}

	public void setNomedoInteressado(String nomedoInteressado) {
		this.nomedoInteressado = nomedoInteressado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
