package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nome;
	@ManyToOne
//	@JoinColumn(name="turma_id")
	private Turno turno;
	@Column
	private int numeroDeVagas;
	@Column
	private int numeroDeVagasDiponiveis;
	@ManyToOne
	//@JoinColumn(name="escola_id")
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
