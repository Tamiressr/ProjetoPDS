package View;

import java.awt.Panel;
import javax.swing.JTextField;

import Controllers.EscolaController;
import Model.Escola;
import Ouvintes.OuvinteLogin;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PainelLogin extends JPanel {
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	JButton btnEntrar = new JButton("ENTRAR");

	public static void main(String[] args) {
		new PainelLogin();
	}

	public PainelLogin() {
	
		setLayout(null);
		setBounds(50, 80, 450, 450);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(126, 113, 205, 20);
		add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(60, 104, 81, 31);
		add(lblLogin);

		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setForeground(new Color(255, 255, 255));
		labelSenha.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelSenha.setBounds(59, 164, 60, 20);
		add(labelSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(126, 164, 205, 20);
		add(passwordFieldSenha);

		JLabel lblBemVindo = new JLabel("BEM- VINDO!");
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblBemVindo.setForeground(new Color(255, 255, 255));
		lblBemVindo.setBounds(128, 11, 273, 62);
		add(lblBemVindo);

		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEntrar.setBounds(211, 218, 120, 31);
		add(btnEntrar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PainelLogin.class.getResource("/bart-lavagna.gif")));
		lblNewLabel.setBounds(-54, -143, 814, 535);
		OuvinteLogin ouvinteDeLogin = new OuvinteLogin(this);
		btnEntrar.addActionListener(ouvinteDeLogin);

		add(lblNewLabel);
		this.setVisible(true);

	}

	public int retornarValores() {
		ArrayList<Escola> e = (ArrayList<Escola>) EscolaController.getEscolaController().listar();
		String login = this.textFieldLogin.getText();
		String senha = this.passwordFieldSenha.getText();
		for (Escola esc : e) {
			System.out.println(esc.getEmail()+esc.getSenha());
			if (login.equals(esc.getEmail()) && senha.equals(esc.getSenha())) {
				return esc.getId();
			}
		}
		return 0;
	}

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public void setTextFieldLogin(JTextField textFieldLogin) {
		this.textFieldLogin = textFieldLogin;
	}

	public JPasswordField getPasswordFieldSenha() {
		return passwordFieldSenha;
	}

	public void setPasswordFieldSenha(JPasswordField passwordFieldSenha) {
		this.passwordFieldSenha = passwordFieldSenha;
	}

}
