package OuvintesDocumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Documentacao;
import View.JanelaDocumentacao;
import View.JanelaPerfil;

public class OuvinteDocumentos implements ActionListener {
	private JanelaPerfil janela;
	private int id;

	public OuvinteDocumentos(JanelaPerfil janela, int id) {
		this.janela = janela;
		this.id = id;
	}

	public void actionPerformed(ActionEvent arg0) {
		janela.getFrame().dispose();
		new JanelaDocumentacao(id);
	}

}
