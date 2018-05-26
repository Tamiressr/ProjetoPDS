package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaCadastrar;

public class OuvinteJanelaCadastro implements ActionListener{
	private JFrame janela;
	
	public OuvinteJanelaCadastro(JFrame janela) {
		this.janela= janela;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		new JanelaCadastrar();

	}
}
