package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.Janela;
import View.JanelaCadastrar;
import View.JanelaLogin;
import View.JanelaListarVagas;

public class OuvinteJanelaLogin implements ActionListener{
	private JFrame frame;

	public OuvinteJanelaLogin(JFrame frame) {
		this.frame = frame;
	}

	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new JanelaLogin();
		
	
		
	}
	

}
