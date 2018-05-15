package Diagrama;

public class Endereco {
	private String rua;
	private short numero;
	private String cidade;
	private String cep;
	private String bairro;
	
	
	
	
	
	
	
	


	public String toString() {
		return "Endereco [Rua=" + rua + ", Numero=" + numero + ", Cidade=" + cidade + ", CEP=" + cep + ", Bairro="
				+ bairro + "]";
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
}
