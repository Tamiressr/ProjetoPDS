package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import Janela.JanelaCadastrar;
import Janela.JanelaPerfil;
import Janela.JanelaPrincipal;
import Principal.Facade;

public class OuvinteSalvar implements ActionListener {
	private JanelaCadastrar janela;

	public OuvinteSalvar(JanelaCadastrar janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		janela.getFrame().dispose();
		
		ArrayList<String> array=janela.returnValores();
		String cnpj=Facade.getFacade().criarEscola(array);
				
		new JanelaPerfil(cnpj);
		
	}

}
