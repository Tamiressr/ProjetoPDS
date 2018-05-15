package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaPerfil;

public class OuvinteJanelaPerfil implements ActionListener{
	private JFrame janela;
	private int id;

	public OuvinteJanelaPerfil(JFrame janela,int id) {
		this.janela = janela;
		this.id=id;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaPerfil(id);
	}
	
	

}
