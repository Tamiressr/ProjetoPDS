package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Janela.JanelaCadastrar;

public class OuvinteJanelaCadatro implements ActionListener{
	private JFrame janela;
	
	public OuvinteJanelaCadatro(JFrame janela) {
		this.janela= janela;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		new JanelaCadastrar();

	}
}
