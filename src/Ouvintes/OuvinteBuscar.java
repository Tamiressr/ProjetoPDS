package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import View.JanelaListarVagas;

public class OuvinteBuscar implements ActionListener{
	private JanelaListarVagas janela;
	
	public OuvinteBuscar(JanelaListarVagas janela) {
		this.janela = janela;
	}



	public void actionPerformed(ActionEvent e) {
		janela.valor();
		 ArrayList<String> txt=janela.getTxt();
		janela.getFrame().dispose();
		new JanelaListarVagas("",txt);
	}

}
