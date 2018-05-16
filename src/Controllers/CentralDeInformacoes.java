package Controllers;

import java.util.ArrayList;

import Model.Escola;

/**
 * Classe Central cridas para salvar os usuarios e corridas, onde serão
 * contidos, valores e métodos para o mesmo.
 */

public class CentralDeInformacoes{
	private ArrayList<Escola> array = new ArrayList<>();
	private int contador = 0;
	private int cont = 0;
	private static CentralDeInformacoes central = null;

	/** Construtor da classe no padrão singleton */
	private CentralDeInformacoes() {

	}

	public static CentralDeInformacoes getCentralDeInformacoes() {
		if (central == null) {
			central = new CentralDeInformacoes();
			Persistencia.getPersistencia().recuperarCentral();
		}
		return central;
	}

	public void adicionarEscola(Escola escola) {
		array.add(escola);
		Persistencia.getPersistencia().salvarCentral(central);
	}

	public Escola recuperarEscola(String login, String senha) {
		for (Escola p : array) {
			if ((p.getEmail().equalsIgnoreCase(login)) && (p.getSenha().equalsIgnoreCase(senha))) {
				return p;
			}
		}

		return null;
	}
	public void remover(Escola escola) {
		array.remove(escola);
	}

	public int getId() {
		return contador++;
	}

	public int getIdRestaurante() {
		return cont++;
	}

	public ArrayList<Escola> getArray() {
		return array;
	}

	public void setArray(ArrayList<Escola> array) {
		this.array = array;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

}