package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaFeedback;
import View.JanelaListarVagas;

public class OuvinteJanelaFeedback implements ActionListener {

	private JFrame janela;

	public OuvinteJanelaFeedback(JFrame j) {
		janela = j;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		JanelaFeedback jF = new JanelaFeedback();
		jF.getFrame().setVisible(true);
	}

}