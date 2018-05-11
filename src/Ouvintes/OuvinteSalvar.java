package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import Janela.JanelaCadastrar;
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
		Facade.getFacade().criarEscola(array);
		
		JanelaPrincipal janelaPrincipal=new JanelaPrincipal();
		janelaPrincipal.getFrmPrincipal().setVisible(true);
		
	}

}
