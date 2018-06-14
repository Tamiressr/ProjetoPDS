package OuvintesEscolas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Facade.Facade;
import Model.Escola;
import View.JanelaCadastrar;
import View.JanelaPerfil;
import View.JanelaListarVagas;

public class OuvinteSalvar implements ActionListener {
	private JanelaCadastrar janela;

	public OuvinteSalvar(JanelaCadastrar janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<String> array = janela.returnValores();

		if (array.get(0).equals("") || array.get(2).equals("") || array.get(5).equals("") || array.get(6).equals("")
				|| array.get(7).equals("") || array.get(8).equals("") || array.get(10).equals("")
				|| array.get(11).equals("") || array.get(12).equals("")) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatorios (Marcados com *) em Branco");
		} else {
			janela.getFrame().dispose();
			int id = Facade.getFacade().criarEscola(array);
			new JanelaPerfil(id);
		}
	}
}
