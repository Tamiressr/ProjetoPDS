package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaCadastrar;
import View.JanelaEditaPerfil;

public class OuvinteEditaPerfil implements ActionListener {
	private String cnpj;
	private JFrame janela;
	
	public OuvinteEditaPerfil(JFrame janela,String cnpj) {
		this.janela = janela;
		this.cnpj=cnpj;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		new JanelaEditaPerfil(cnpj);

	}
}
