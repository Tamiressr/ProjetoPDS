package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Facade;
import View.JanelaGerenciarTurma;

public class OuvinteSalvaTurma implements ActionListener{
	private int id;
	private JanelaGerenciarTurma janela;
	
	public OuvinteSalvaTurma(int id, JanelaGerenciarTurma janela) {
		this.id=id;
		this.janela=janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		ArrayList<String> array=new ArrayList<>();
		array=janela.retornaValoresTurma();
		if(array==null) {
			
		}else {
			Facade.getFacade().salvarTurma(id,array);
			janela.getTextField_TotalDeVagas().setText("");
			janela.getTextField_VagasDisponiveis().setText("");
			janela.getComboBox().setSelectedIndex(0);
			janela.getGrupo().clearSelection();
			JOptionPane.showMessageDialog(null, "Salvo Turma");
		}
	}

}
