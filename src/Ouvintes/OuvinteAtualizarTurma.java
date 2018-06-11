package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Facade;
import Model.Turma;
import View.JanelaGerenciarTurma;

public class OuvinteAtualizarTurma implements ActionListener {
	private JanelaGerenciarTurma janela;
	private Turma turma;

	public OuvinteAtualizarTurma(JanelaGerenciarTurma janela, Turma turma) {
		this.janela = janela;
		this.turma = turma;
	}

	public void actionPerformed(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		Turma turmaSelecionada = janela.linhaSelecionada();
		int vagas = janela.retornaVagasDisponiveis();
		if (turmaSelecionada.getNumeroDeVagas() < vagas) {
			JOptionPane.showMessageDialog(null,
					"Numero de Vagas Disponiveis deve ser menor que:" + turmaSelecionada.getNumeroDeVagas());
		} else if (confirm == 0) {
			Facade.getFacade().atualizarTurma(turma.getId(), vagas);
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} else {

		}
	}

}
