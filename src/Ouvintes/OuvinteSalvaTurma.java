package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.Facade;
import View.JanelaGerenciarTurma;

public class OuvinteSalvaTurma implements ActionListener{
	private int id;
	private JanelaGerenciarTurma janela;
	
	public OuvinteSalvaTurma(int id, JanelaGerenciarTurma janela) {
		this.id=id;
		this.janela=janela;
	}
	

	public void actionPerformed(ActionEvent e) {
//		Facade.getFacade().salvarTurma(id, janela.retornaValores());
		
	}

}
