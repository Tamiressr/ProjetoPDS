package Model;

import javax.persistence.ManyToOne;

public class Telefone {
	private short ddd;
<<<<<<< HEAD:src/Diagrama/Telefone.java

<<<<<<< HEAD:src/Diagrama/Telefone.java
<<<<<<< HEAD:src/Model/Telefone.java
=======
>>>>>>> parent of 9a8738d... Teste:src/Model/Telefone.java
=======
>>>>>>> parent of 5114008... Teste:src/Model/Telefone.java
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
