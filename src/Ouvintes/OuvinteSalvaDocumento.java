package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Facade;
import View.JanelaDocumentacao;

public class OuvinteSalvaDocumento implements ActionListener {
	private JanelaDocumentacao janela;

	public OuvinteSalvaDocumento(JanelaDocumentacao janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		if (janela.getTxtDocumento().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campos Vazios");
		} else {
			Facade.getFacade().cadastrarDocumento(janela.getId(), janela.getTxtDocumento().getText());
			janela.getTxtDocumento().setText("");
			janela.getFrame().repaint();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		}
	}

}
