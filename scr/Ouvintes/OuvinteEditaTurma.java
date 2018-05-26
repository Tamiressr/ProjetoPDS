package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Facade;
import View.JanelaGerenciarTurma;

public class OuvinteEditaTurma implements ActionListener {
	private int id;
	private JanelaGerenciarTurma janela;

	public OuvinteEditaTurma(int id, JanelaGerenciarTurma janela) {
		this.id = id;
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
//		if (janela.isRetiraPainel() == true) {
			janela.getFrame().remove(janela.getPanel());
			janela.getFrame().remove(janela.getPainelTabela());
			janela.getFrame().repaint();
			janela.addPainel();
			janela.adicionarValores();
			janela.getFrame().repaint();
//		}
		
	}

}
