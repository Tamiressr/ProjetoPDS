package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaListarVagas;

public class OuvinteJanelaListagemVagas implements ActionListener{
private JFrame janela;
	public OuvinteJanelaListagemVagas(JFrame j) {
		janela=j;
}
	public void actionPerformed(ActionEvent arg0) {
		janela.dispose();
		JanelaListarVagas j=new JanelaListarVagas();
		j.getFrame().setVisible(true);
		
	}

}
