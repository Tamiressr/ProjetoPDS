package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaGerenciarTurma;

public class OuvinteListaTurma implements ActionListener{
	private JanelaGerenciarTurma janela;
	private int id;
	
	public OuvinteListaTurma(JanelaGerenciarTurma janela, int id) {
		this.janela=janela;
		this.id=id;
		
	}

	public void actionPerformed(ActionEvent e) {
		janela.getFrame().remove(janela.getPanel());
		janela.getFrame().remove(janela.getBtnListaTurma());
		janela.addBotaoCadastrar();
		janela.getFrame().repaint();
		janela.listaTurma();
		janela.getFrame().repaint();
//		janela.getFrame();
	}

}
