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
boolean valido=true;
while(valido) {
		if (array.get(0).equals("") || array.get(2).equals("") || array.get(5).equals("") || array.get(6).equals("")
				|| array.get(7).equals("") || array.get(8).equals("") || array.get(10).equals("")
				|| array.get(11).equals("") || array.get(12).equals("")) {
			JOptionPane.showMessageDialog(null, "Campos Obrigatorios (Marcados com *) em Branco");
			valido=false;
			
		}if(array.get(6).length()<8||array.get(6).length()>20) {
		JOptionPane.showMessageDialog(null,"Informe uma senha com no mínimo 8 caracteres e no máximo 20 caracteres");
		valido=false;
			break;
		}
		else {
			
			janela.getFrame().dispose();
			int id = Facade.getFacade().criarEscola(array);
			new JanelaPerfil(id);
		}valido=true;
	}
	}
}
