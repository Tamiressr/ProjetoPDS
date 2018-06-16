package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Turma;
import View.JanelaInformacoes;
import View.JanelaListarVagas;

public class OuvinteMaisInformacoes implements ActionListener{
	private JanelaListarVagas janela;
	
	
	
	public OuvinteMaisInformacoes(JanelaListarVagas janela) {
		this.janela = janela;
	}



	public void actionPerformed(ActionEvent e) {
		if(janela.getTable().getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(null,"Selecione uma linha na tabela e clique para mais informações");
			
		}else
		new JanelaInformacoes(janela.linhaSelecionada());
		
	}

}
