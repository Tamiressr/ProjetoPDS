package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String turno;
	private int numeroDeVagas;
	private int numeroDeVagasDiponiveis;

	@ManyToOne
	private Escola escola;

	public Turma() {

	}

	public String toString() {
		return "Turma [Nome=" + nome + ", Turno=" + turno + ", Numero de Vagas=" + numeroDeVagas
				+ ", Vagas Disponiveis=" + numeroDeVagasDiponiveis + ",]";
	}
	
	public String toStringPrincipal() {
		return "[Nome=" + escola.getNome() +" Nome=" + nome + ", Turno=" + turno + ", Numero de Vagas=" + numeroDeVagas
				+ ", Vagas Disponiveis=" + numeroDeVagasDiponiveis + ",]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getNumeroDeVagas() {
		return numeroDeVagas;
	}

	public void setNumeroDeVagas(int numeroDeVagas) {
		this.numeroDeVagas = numeroDeVagas;
	}

	public int getNumeroDeVagasDiponiveis() {
		return numeroDeVagasDiponiveis;
	}

	public void setNumeroDeVagasDiponiveis(int numeroDeVagasDiponiveis) {
		this.numeroDeVagasDiponiveis = numeroDeVagasDiponiveis;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

}
