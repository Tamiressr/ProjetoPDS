package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Principal.Facade;

public class OuvinteAtualizarPerfil implements ActionListener {
	private JFrame janela;
	private String cnpj;

	public OuvinteAtualizarPerfil(JFrame janela,String cnpj) {
		this.janela = janela;
		this.cnpj=cnpj;
	}

	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		Facade.getFacade().atualizar(cnpj);
	}

}
