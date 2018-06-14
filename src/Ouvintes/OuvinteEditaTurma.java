package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Facade.Facade;
import Model.Turma;
import View.JanelaGerenciarTurma;

public class OuvinteEditaTurma implements ActionListener {
	private int id;
	private JanelaGerenciarTurma janela;

	public OuvinteEditaTurma(int id, JanelaGerenciarTurma janela) {
		this.id = id;
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		Turma turmaSelecionada = janela.linhaSelecionada();
		if (janela.isRetiraPainel()) {
			janela.getFrame().remove(janela.getPanel());
		}
		if(janela.isRetirarTabela()) {
			janela.getFrame().remove(janela.getPainelTabela());			
		}
		janela.getFrame().repaint();
		janela.addPainelEdita(turmaSelecionada);
		janela.getFrame().repaint();
	}

}
