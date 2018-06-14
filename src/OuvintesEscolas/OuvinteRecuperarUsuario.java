package OuvintesEscolas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controllers.EscolaController;
import Model.Email;
import Model.Escola;

public class OuvinteRecuperarUsuario implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
	String email=	JOptionPane.showInputDialog(null, "Informe seu email para recuperação de senha");
	ArrayList<Escola>escolas=(ArrayList<Escola>) EscolaController.getEscolaController().listar();
	for(Escola es:escolas) {
		if(es.getEmail().equals(email)) {
			Email.recuperarEmail(email, "Sua senha correspondente é:"+es.getSenha());
		}else {
			JOptionPane.showMessageDialog(null,"o email informado não foi encontrado ");
		}
	}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
