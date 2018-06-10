package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Facade;
import View.JanelaGerenciarTurma;

public class OuvinteAtualizarTurma implements ActionListener{
	private JanelaGerenciarTurma janela;
	
	public OuvinteAtualizarTurma(JanelaGerenciarTurma janela) {
		this.janela=janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		int confirm=JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		if(confirm==0) {
			ArrayList<String> array=new ArrayList<>();
			array=janela.retornaValoresTurma();
			array.add(""+janela.getId());
			int id=Facade.getFacade().procurarTurma(array);
			Facade.getFacade().atualizarTurma(id, array);
			JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
		}else{
			
		}
	}

}
