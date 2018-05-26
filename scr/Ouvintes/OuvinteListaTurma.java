package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;

public class OuvinteListaTurma implements ActionListener {
	private JanelaGerenciarTurma janela;
	private int id;

	public OuvinteListaTurma(JanelaGerenciarTurma janela, int id) {
		this.janela = janela;
		this.id = id;

	}

	public void actionPerformed(ActionEvent e) {
		if (janela.isRetiraPainel() == true) {
			janela.getFrame().remove(janela.getPanel());
		}
		janela.getFrame().repaint();
		janela.listaTurma();
		janela.getFrame().repaint();
	}

}
