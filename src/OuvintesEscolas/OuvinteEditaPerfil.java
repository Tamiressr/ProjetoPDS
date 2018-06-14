package OuvintesEscolas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaCadastrar;
import View.JanelaEditaPerfil;

public class OuvinteEditaPerfil implements ActionListener {
	private int id;
	private JFrame janela;
	
	public OuvinteEditaPerfil(JFrame janela,int id) {
		this.janela = janela;
		this.id=id;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		new JanelaEditaPerfil(id);

	}
}
