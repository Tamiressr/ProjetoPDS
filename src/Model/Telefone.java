package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private short ddd;

	private String numero;
	
	@ManyToOne
	private Escola escola;
	
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
