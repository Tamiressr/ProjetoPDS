package Diagrama;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	private Turno turno;

	private int numeroDeVagas;

	private int numeroDeVagasDiponiveis;

	@ManyToOne
	private Escola escola;

	public Turma() {

	}

	public String toString() {
		return "Turma [Nome=" + nome + ", turno=" + turno + ", numero de vagas=" + numeroDeVagas
				+ ", numero de vagas disponiveis=" + numeroDeVagasDiponiveis + ",]";
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

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
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
