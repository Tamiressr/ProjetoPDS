package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;
import View.JanelaPerfil;

public class OuvinteCadastrarTurma implements ActionListener{
	private JanelaGerenciarTurma janela;
	private int id;
	
	public OuvinteCadastrarTurma(JanelaGerenciarTurma janela, int id) {
		this.janela=janela;
		this.id=id;
	}
	

	public void actionPerformed(ActionEvent e) {
		janela.addPainel();
		janela.getFrame().repaint();
//		new JanelaCadastrarTurma(id);
	}

}
