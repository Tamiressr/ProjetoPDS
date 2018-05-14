package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Facade;

public class OuvinteAtualizarPerfil implements ActionListener {
	private JFrame janela;
	private int id;

	public OuvinteAtualizarPerfil(JFrame janela,int id) {
		this.janela = janela;
		this.id=id;
	}

	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		Facade.getFacade().atualizar(id);
	}

}
