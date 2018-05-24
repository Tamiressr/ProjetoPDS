package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Facade;
import View.JanelaGerenciarTurma;

public class OuvinteExcluirTurma implements ActionListener{
	private int id;
	private JanelaGerenciarTurma janela;


	public OuvinteExcluirTurma(JanelaGerenciarTurma janela,int id) {
		this.janela = janela;
		this.id=id;
	}
	
	public void actionPerformed(ActionEvent e) {
		int confirm=JOptionPane.showConfirmDialog(null, "Deseja excluir sua Turma?");
		if(confirm==0) {
			Facade.getFacade().excluirTurma(janela.linhaSelecionada().getId());
			janela.getFrame().repaint();
		}else {
			
		}
	}

}
