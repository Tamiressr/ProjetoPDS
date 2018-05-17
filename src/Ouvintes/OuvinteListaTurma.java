package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;

public class OuvinteListaTurma implements ActionListener{
	private JanelaGerenciarTurma janela;
	private int id;
	
	public OuvinteListaTurma(JanelaGerenciarTurma janela, int id) {
		this.janela=janela;
		this.id=id;
		
	}

	public void actionPerformed(ActionEvent e) {
		janela.listaTurma();
		janela.getFrame().repaint();
//		janela.getFrame();
	}

}
