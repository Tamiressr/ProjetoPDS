package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controllers.EscolaController;
import Model.Escola;
import View.JanelaLogin;
import View.JanelaPerfil;
import View.PainelLogin;

public class OuvinteLogin implements ActionListener {
	private PainelLogin janela;
	
	public OuvinteLogin(PainelLogin janela) {
		this.janela = janela;
	
	}


	public void actionPerformed(ActionEvent arg0) {
		
		int valor=this.janela.retornarValores();
		if(valor==0) {
			JOptionPane.showMessageDialog(null,"jndjqwj");
		}else {
			JanelaPerfil jp = new JanelaPerfil(valor);			
		}
	}

	public JPanel getPainel() {
		return janela;
	}

	public void setPainel(PainelLogin painel) {
		this.janela = painel;
	}

}
