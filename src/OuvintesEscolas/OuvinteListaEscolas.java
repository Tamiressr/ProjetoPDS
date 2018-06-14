package OuvintesEscolas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaListaEscolas;

public class OuvinteListaEscolas implements ActionListener {
	private JFrame janela;

	public OuvinteListaEscolas(JFrame janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		new JanelaListaEscolas();
	}

}
