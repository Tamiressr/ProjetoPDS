package OuvintesDocumentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Facade.Facade;
import View.JanelaDocumentacao;

public class OuvinteSalvaPrimeiroDocumento implements ActionListener{
	private JanelaDocumentacao janela;
	
	public OuvinteSalvaPrimeiroDocumento(JanelaDocumentacao janela) {
		this.janela=janela;
	}

	public void actionPerformed(ActionEvent e) {
		ArrayList<String> array=janela.retornaCheckbox();
		for(String a:array) {
			Facade.getFacade().cadastrarDocumento(janela.getId(), a);
		}
		janela.getFrame().repaint();
	}
	
	

}
