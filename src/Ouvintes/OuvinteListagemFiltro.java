package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaListagemFiltro;

public class OuvinteListagemFiltro implements ActionListener {
	private JFrame janela;

	public OuvinteListagemFiltro(JFrame j) {
		this.janela = j;
	}

	public void actionPerformed(ActionEvent e) {

		janela.dispose();
		new JanelaListagemFiltro();
	}

}
