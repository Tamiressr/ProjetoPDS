package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Facade;
import View.JanelaEditaPerfil;
import View.JanelaPerfil;

public class OuvinteAtualizarPerfil implements ActionListener {
	private JanelaEditaPerfil janela;
	private int id;

	public OuvinteAtualizarPerfil(JanelaEditaPerfil janela,int id) {
		this.janela = janela;
		this.id=id;
	}

	public void actionPerformed(ActionEvent arg0) {
		int confirm=JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		if(confirm==0) {
			ArrayList<String> array=new ArrayList<>();
			array=janela.returnValores();
			Facade.getFacade().atualizar(id,array);
			new JanelaPerfil(id);
<<<<<<< HEAD
=======
			JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
>>>>>>> dad53d536946d7b9b120327e00e50147a41d2213
		}else if(confirm==1) {
			
		}else {
			new JanelaPerfil(id);
		}
		
	}

}
