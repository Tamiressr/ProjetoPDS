package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaCadastrar;
import View.JanelaPrinc;
import View.JanelaListarVagas;

public class OuvinteVoltarInicio implements ActionListener{
	private JFrame janela;

	public OuvinteVoltarInicio(JFrame janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		JanelaPrinc p=new JanelaPrinc();
		p.getFrame().setVisible(true);
		
	}

}
