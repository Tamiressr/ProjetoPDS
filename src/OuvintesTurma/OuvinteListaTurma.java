package OuvintesTurma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;

public class OuvinteListaTurma implements ActionListener {
	private JanelaGerenciarTurma janela;
	private int id;

	public OuvinteListaTurma(JanelaGerenciarTurma janela, int id) {
		this.janela = janela;
		this.id = id;

	}

	public void actionPerformed(ActionEvent e) {
		if (janela.isRetiraPainel()) {
			janela.getFrame().remove(janela.getPanel());
		}
		if (janela.isRetirarTabela()) {
			janela.getFrame().remove(janela.getPainelTabela());
		}
		janela.getFrame().repaint();
		janela.listaTurma("Outro");
		janela.getFrame().repaint();
	}

}
