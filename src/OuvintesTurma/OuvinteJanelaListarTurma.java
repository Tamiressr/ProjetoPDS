package OuvintesTurma;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaListarVagas;

public class OuvinteJanelaListarTurma implements ActionListener {
	private JFrame janela;

	public OuvinteJanelaListarTurma(JFrame j) {
		this.janela = j;
	}

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		JanelaListarVagas j = new JanelaListarVagas("primeiro",null);
		j.getFrame().setVisible(true);
	}

}
