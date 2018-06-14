package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaInformacoes;

public class OuvinteVoltaBusca implements ActionListener{
	private JanelaInformacoes janela;
	
	public OuvinteVoltaBusca(JanelaInformacoes janela) {
		super();
		this.janela = janela;
	}



	public void actionPerformed(ActionEvent arg0) {
		janela.getFrame().dispose();;
		
	}

}
