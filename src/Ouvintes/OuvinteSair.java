package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaPerfil;
import View.JanelaListarVagas;

public class OuvinteSair implements ActionListener{
	private JanelaPerfil janela;
	
	public OuvinteSair(JanelaPerfil janela) {
		this.janela=janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		janela.setId(0);
		janela.getFrame().dispose();
		new JanelaListarVagas();
	}

}
