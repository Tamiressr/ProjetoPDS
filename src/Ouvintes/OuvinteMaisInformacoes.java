package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Turma;
import View.JanelaInformacoes;
import View.JanelaListarVagas;

public class OuvinteMaisInformacoes implements ActionListener{
	private JanelaListarVagas janela;
	
	
	
	public OuvinteMaisInformacoes(JanelaListarVagas janela) {
		this.janela = janela;
	}



	public void actionPerformed(ActionEvent e) {
		int id=janela.linhaSelecionada().getId();
		new JanelaInformacoes(id);
		
	}

}
