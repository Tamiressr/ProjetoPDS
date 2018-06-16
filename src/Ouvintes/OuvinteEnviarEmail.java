package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Email;
import View.JanelaFeedback;

public class OuvinteEnviarEmail implements ActionListener {
	JanelaFeedback janela;

	public OuvinteEnviarEmail(JanelaFeedback j) {
		this.janela = j;
	}

	@SuppressWarnings("unlikely-arg-type")
	public void actionPerformed(ActionEvent arg0) {
		if(janela.getTextField().getText().equals("")||janela.getTextotextArea().equals("")) {
			JOptionPane.showMessageDialog(null,"Campos vazios, por favor informe seu nome e a mensagem"
					+ " que deseja enviar para a RTA System");
		}
		else {	
			Email.enviarEmail(janela.getTextField().getText(),janela.getTextotextArea().getText());
			JOptionPane.showMessageDialog(null,"Mensagem enviada, Obrigada");
			
	}
	}
}