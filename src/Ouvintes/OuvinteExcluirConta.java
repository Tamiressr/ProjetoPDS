package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Facade;

public class OuvinteExcluirConta implements ActionListener{
	private String cnpj;
	private JFrame janela;

	public OuvinteExcluirConta(JFrame janela, String cnpj) {
		this.janela = janela;
		this.cnpj=cnpj;
	}

	public void actionPerformed(ActionEvent arg0) {
//		janela.dispose();
		int confirm=JOptionPane.showConfirmDialog(null, "Deseja excluir sua conta?");
		if(confirm==0) {
			Facade.getFacade().excluirConta(cnpj);
		}else if(confirm==1) {
			System.out.println("nao");
		}else {
			System.out.println("a");
		}
		
	}

}
