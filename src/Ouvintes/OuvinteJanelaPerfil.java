package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaPerfil;

public class OuvinteJanelaPerfil implements ActionListener{
	private JFrame janela;
	private String cnpj;

	public OuvinteJanelaPerfil(JFrame janela,String cnpj) {
		this.janela = janela;
		this.cnpj=cnpj;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaPerfil(cnpj);
	}
	
	

}
