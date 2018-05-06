package Diagrama;

public class Serie {
	private String nome;
	private Turno turno;
	private int numeroDeVagas;
	private int numeroDeVagasDiponíveis;
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Serie [Nome=" + nome + ", Turno=" + turno + ", Numero De Vagas=" + numeroDeVagas
				+ ", Numero De Vagas Diponíveis=" + numeroDeVagasDiponíveis + "]";
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

	public int getNumeroDeVagasDiponíveis() {
		return numeroDeVagasDiponíveis;
	}

	public void setNumeroDeVagasDiponíveis(int numeroDeVagasDiponíveis) {
		this.numeroDeVagasDiponíveis = numeroDeVagasDiponíveis;
	}
}
