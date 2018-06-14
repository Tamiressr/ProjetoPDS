package OuvintesTurma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Facade.Facade;
import Model.Turma;
import View.JanelaGerenciarTurma;

public class OuvinteExcluirTurma implements ActionListener {
	private int id;
	private JanelaGerenciarTurma janela;

	public OuvinteExcluirTurma(JanelaGerenciarTurma janela, int id) {
		this.janela = janela;
		this.id = id;
	}

	public void actionPerformed(ActionEvent e) {
		Turma turmaSelecionada = janela.linhaSelecionada();
		if (turmaSelecionada != null) {
			int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir sua Turma?");

			if (confirm == 0) {
				Facade.getFacade().excluirTurma(turmaSelecionada.getId());
				janela.removerLinha();
				janela.getFrame().repaint();
			} else {

			}
		}else {
			JOptionPane.showMessageDialog(null,"Turma não selecionada");
		}
	}

}
