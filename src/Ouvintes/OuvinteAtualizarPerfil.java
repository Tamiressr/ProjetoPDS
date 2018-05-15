package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Facade;
import View.JanelaEditaPerfil;

public class OuvinteAtualizarPerfil implements ActionListener {
	private JanelaEditaPerfil janela;
	private int id;

	public OuvinteAtualizarPerfil(JanelaEditaPerfil janela,int id) {
		this.janela = janela;
		this.id=id;
	}

	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		
		ArrayList<String> array=new ArrayList<>();
		array=janela.returnValores();
		Facade.getFacade().atualizar(id,array);
	}

}
