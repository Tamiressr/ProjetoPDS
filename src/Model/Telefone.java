package Model;

import javax.persistence.ManyToOne;

public class Telefone {
	private short ddd;
	private String numero;

	@ManyToOne
	private Escola escola;
	
	
	
	public String toString() {
		return ddd+numero;
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
