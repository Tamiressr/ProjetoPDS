package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaGerenciarTurma;
import View.JanelaPerfil;

public class OuvinteGerenciarTurma implements ActionListener{
	private JFrame janela;
	private int id;
	
	public OuvinteGerenciarTurma(JFrame janela, int id) {
		this.janela=janela;
		this.id=id;
	}
	

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaGerenciarTurma(id);
		
	}
	

}
