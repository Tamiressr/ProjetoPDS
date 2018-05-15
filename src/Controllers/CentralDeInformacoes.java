package Controllers;

import java.util.ArrayList;
import java.util.Date;

import Model.Escola;

/**
 * Classe Central cridas para salvar os usuarios e corridas, onde serão
 * contidos, valores e métodos para o mesmo.
 */

public class CentralDeInformacoes {
	private ArrayList<Escola> escolas = new ArrayList<>();
	private static CentralDeInformacoes central;

	/** Construtor da classe no padrão singleton */
	private CentralDeInformacoes() {

	}

	public static CentralDeInformacoes getCentralDeInformacoes() {
		if (central == null) {
			central = new CentralDeInformacoes();
			central = Persistencia.getPersistencia().recuperarCentral();
		}
		return central;
	}

	public void adicionarEscola(Escola escola) {
		escolas.add(escola);
		Persistencia.getPersistencia().salvarCentral(central);
	}

	public Escola recuperarEscola(String login, String senha) {
		for (Escola escola : escolas) {
			if ((escola.getEmail().equals(login)) && (escola.getSenha().equals(senha))) {
				return escola;
			}
		}

		return null;
	}

//	public void excluirEscola(int id) {
//		for (Escola escola : escolas) {
//			if ((escola.getId()) {
//				return escola;
//			}
//		}
//		
//		
//	}
	
	public ArrayList<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(ArrayList<Escola> escolas) {
		this.escolas = escolas;
	}

}