package OuvintesTurma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;
import View.JanelaPerfil;

public class OuvinteCadastrarTurma implements ActionListener {
	private JanelaGerenciarTurma janela;
	private int id;

	public OuvinteCadastrarTurma(JanelaGerenciarTurma janela, int id) {
		this.janela = janela;
		this.id = id;
	}

	public void actionPerformed(ActionEvent e) {
		if (janela.isRetiraPainel()) {
			janela.getFrame().remove(janela.getPanel());
		}
		if (janela.isRetiraTabela()) {
			janela.getFrame().remove(janela.getPainelTabela());
		}
		janela.addPainel();
		janela.getFrame().repaint();
	}

}
