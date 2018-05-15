package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaCadastrar;

public class OuvinteLogin implements ActionListener{
	private JFrame janela;
	
	public OuvinteLogin(JFrame janela) {
		this.janela= janela;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		new JanelaCadastrar();

	}
}
