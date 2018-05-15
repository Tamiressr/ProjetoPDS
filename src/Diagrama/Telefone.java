<<<<<<< HEAD:src/Model/Telefone.java
package Model;

import javax.persistence.ManyToOne;
=======
package Diagrama;
>>>>>>> b1c2f618abb6de4baf0b0a4733e0a706c7b191fe:src/Diagrama/Telefone.java

public class Telefone {
	private short ddd;
<<<<<<< HEAD:src/Diagrama/Telefone.java

<<<<<<< HEAD:src/Model/Telefone.java
=======
>>>>>>> parent of 9a8738d... Teste:src/Model/Telefone.java
	private String numero;

	@ManyToOne
	private Escola escola;
=======
	
	
	
	
	
	
	
>>>>>>> b1c2f618abb6de4baf0b0a4733e0a706c7b191fe:src/Diagrama/Telefone.java
	
	
	
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
