package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Model.Email;
import View.JanelaFeedback;

public class OuvinteEnviarEmail implements ActionListener{
JanelaFeedback janela;

public OuvinteEnviarEmail(JanelaFeedback j) {
	this.janela=j;
}
	public void actionPerformed(ActionEvent arg0) {

	Email.enviarEmail(janela.getTextotextArea().getText());
	
	}


}
