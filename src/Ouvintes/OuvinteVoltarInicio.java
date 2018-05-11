package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Janela.JanelaCadastrar;
import Janela.JanelaPrincipal;

public class OuvinteVoltarInicio implements ActionListener{
	private JanelaCadastrar janela;

	public OuvinteVoltarInicio(JanelaCadastrar janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		janela.getFrame().dispose();
		new JanelaPrincipal();
		
	}

}
