package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;
import View.JanelaPerfil;

public class OuvinteGerenciarTurma implements ActionListener{
	private JanelaPerfil janela;
	private int id;
	
	public OuvinteGerenciarTurma(JanelaPerfil janela, int id) {
		this.janela=janela;
		this.id=id;
	}
	

	public void actionPerformed(ActionEvent e) {
		janela.getFrame().dispose();
		new JanelaGerenciarTurma(id);
		
	}
	

}
