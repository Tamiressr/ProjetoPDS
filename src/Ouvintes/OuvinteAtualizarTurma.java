package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.Facade;
import Model.Turma;
import View.JanelaGerenciarTurma;

public class OuvinteAtualizarTurma implements ActionListener{
	private JanelaGerenciarTurma janela;
	private Turma turma;
	
	public OuvinteAtualizarTurma(JanelaGerenciarTurma janela, Turma turma) {
		this.janela=janela;
		this.turma=turma;
	}
	

	public void actionPerformed(ActionEvent e) {
		int confirm=JOptionPane.showConfirmDialog(null, "Tem Certeza?");
		if(confirm==0) {
			ArrayList array=new ArrayList<>();
			int vagas = 0;
			
//			array=janela.retornaVagasDisponiveis(turma);
			array.add(""+janela.getId());
			int id=Facade.getFacade().procurarTurma(array);
			Facade.getFacade().atualizarTurma(id, vagas);
			
			JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
		}else{
			
		}
	}

}
