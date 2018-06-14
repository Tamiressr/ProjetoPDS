package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Facade.Facade;
import View.JanelaEditaPerfil;
import View.JanelaPerfil;

public class OuvinteAtualizarPerfil implements ActionListener {
	private JanelaEditaPerfil janela;
	private int id;

	public OuvinteAtualizarPerfil(JanelaEditaPerfil janela, int id) {
		this.janela = janela;
		this.id = id;
	}

	public void actionPerformed(ActionEvent arg0) {
		int confirm = JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		if (confirm == 0) {
			ArrayList<String> array = new ArrayList<>();
			array = janela.returnValores();
			if (array.get(0).equals("") || array.get(2).equals("") || array.get(5).equals("") || array.get(6).equals("")
					|| array.get(7).equals("") || array.get(8).equals("") || array.get(10).equals("")
					|| array.get(11).equals("") || array.get(12).equals("")) {
				JOptionPane.showMessageDialog(null, "Campos Obrigatorios (Marcados com *) em Branco");
			}
			if (array.get(6).length() < 8) {

				JOptionPane.showMessageDialog(null, "informe uma senha com no mínimo 8 caracteres");

			}

			else {
				janela.getFrame().dispose();
				Facade.getFacade().atualizar(id, array);
				new JanelaPerfil(id);
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
			}
		} else if (confirm == 1) {

		} else {
			new JanelaPerfil(id);
		}

	}

}
