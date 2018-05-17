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
	private PainelLogin painel;
	
	public OuvinteLogin(PainelLogin painel) {
		this.painel = painel;
	
	}


	public void actionPerformed(ActionEvent arg0) {
		int valor=this.painel.retornarValores();
		if(valor==0) {
			JOptionPane.showMessageDialog(null,"jndjqwj");
		}else {
			JanelaPerfil jp = new JanelaPerfil(valor);			
		}
	}

	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(PainelLogin painel) {
		this.painel = painel;
	}

}
