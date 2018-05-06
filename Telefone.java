package Diagrama;

public class Telefone {
	private short ddd;
	private String numero;

	
	
	
	
	
	
	
	
	
	
	public String toString() {
		return "Telefone [DDD=" + ddd + ",Numero=" + numero + "]";
	}

	public short getDdd() {
		return ddd;
	}

	public void setDdd(short ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
