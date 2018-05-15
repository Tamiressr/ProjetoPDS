<<<<<<< HEAD:src/Model/Telefone.java
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
=======
package Diagrama;
>>>>>>> b1c2f618abb6de4baf0b0a4733e0a706c7b191fe:src/Diagrama/Telefone.java

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private short ddd;

<<<<<<< HEAD:src/Model/Telefone.java
	private String numero;
	
	@ManyToOne
	private Escola escola;
=======
	
	
	
	
	
	
	
>>>>>>> b1c2f618abb6de4baf0b0a4733e0a706c7b191fe:src/Diagrama/Telefone.java
	
	public Escola getEscola() {
		return escola;
	}
	
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
