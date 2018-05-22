package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OuvinteExcluirTurma implements ActionListener{
	private int id;
	private JFrame janela;


	public OuvinteExcluirTurma(JFrame janela,int id) {
		this.janela = janela;
		this.id=id;
	}
	
	public void actionPerformed(ActionEvent e) {
		int confirm=JOptionPane.showConfirmDialog(null, "Deseja excluir sua Turma?");
		
		
		
	}

}
