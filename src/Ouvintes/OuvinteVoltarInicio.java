package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Janela.JanelaCadastrar;
import Janela.JanelaPrincipal;

public class OuvinteVoltarInicio implements ActionListener{
	private JFrame janela;

	public OuvinteVoltarInicio(JFrame janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		new JanelaPrincipal();
		
	}

}
