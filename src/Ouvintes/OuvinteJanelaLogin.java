package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Janela.Janela;
import Janela.JanelaCadastrar;
import Janela.JanelaLogin;
import Janela.JanelaPrincipal;

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
