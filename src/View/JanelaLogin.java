package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controllers.EscolaController;
import Model.Escola;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;

import java.awt.Color;

public class JanelaLogin{

	private JFrame frame;
	private JPanel painel;
	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
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

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public void setBtnEntrar(JButton btnEntrar) {
		this.btnEntrar = btnEntrar;
	}
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	JButton btnEntrar = new JButton("ENTRAR");

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin window = new JanelaLogin();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public JanelaLogin() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame=new JFrame();
		frame.getContentPane().setBackground(new Color(102, 51, 0));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("Acompanhamento de Vagas");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 550, 550);
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.setVisible(true);

		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnreaDaEscola = new JMenu("Escola");
		menuBar.add(mnreaDaEscola);

		JMenuItem mntmLogin = new JMenuItem("Login");
		OuvinteJanelaLogin ouvinteJanelaLogin=new OuvinteJanelaLogin(frame);
		mntmLogin.addActionListener(ouvinteJanelaLogin);
		mnreaDaEscola.add(mntmLogin);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		OuvinteJanelaCadastro ouvinteJanelaCadatro= new OuvinteJanelaCadastro(frame);
		mntmCadastrar.addActionListener(ouvinteJanelaCadatro);
		mnreaDaEscola.add(mntmCadastrar);
		frame.getContentPane().setLayout(null);
		
		JMenuItem mntmListaEscolas = new JMenuItem("Lista Escolas");
	
		OuvinteListaEscolas ouvinteListaEscolas=new OuvinteListaEscolas(frame);
		mntmListaEscolas.addActionListener(ouvinteListaEscolas);
		mnreaDaEscola.add(mntmListaEscolas);

		OuvinteLogin ouvinteDeLogin = new OuvinteLogin(this);
		btnEntrar.addActionListener(ouvinteDeLogin);
		
		frame.getContentPane().add(this.adcionarPainel());
		
		frame.getContentPane().setLayout(null);		

		frame.getContentPane().setLayout(null);		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel adcionarPainel() {
		painel= new JPanel();
		painel.setBounds(50, 80, 450, 296);
		painel.setBackground(new Color(255, 255, 255));
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(126, 113, 205, 20);
		painel.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setBounds(60, 104, 81, 31);
		painel.add(lblLogin);

		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setForeground(new Color(255, 255, 255));
		labelSenha.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		labelSenha.setBounds(59, 164, 60, 20);
		painel.add(labelSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(126, 164, 205, 20);
		painel.add(passwordFieldSenha);

		JLabel lblBemVindo = new JLabel("BEM- VINDO!");
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblBemVindo.setForeground(new Color(255, 255, 255));
		lblBemVindo.setBounds(128, 11, 273, 62);
		painel.add(lblBemVindo);

		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEntrar.setBounds(211, 218, 120, 31);
		painel.add(btnEntrar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JanelaLogin.class.getResource("/bart-lavagna.gif")));
		lblNewLabel.setBounds(-54, -143, 814, 535);
		
		painel.setLayout(null);
	painel.add(lblNewLabel);
		painel.setVisible(true);
		return painel;
	}
	
	public int retornarValores() {
		
		ArrayList<Escola> e = (ArrayList<Escola>) EscolaController.getEscolaController().listar();

		String login = this.textFieldLogin.getText();
		String senha = this.passwordFieldSenha.getText();
		for (Escola esc : e) {
			if (login.equals(esc.getEmail()) && senha.equals(esc.getSenha())) {
				return esc.getId();
			}
		}
		return 0;
	
}
	public class OuvinteLogin implements ActionListener {
		
		private JanelaLogin janela;
		
		public OuvinteLogin(JanelaLogin janela) {
			
			this.janela=janela;
		
		}


		public void actionPerformed(ActionEvent arg0) {
			int valor=this.janela.retornarValores();
			
			if(janela.passwordFieldSenha.getText().equals("")||janela.textFieldLogin.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Campos vazios");
			}
			else if(valor==0) {
				JOptionPane.showMessageDialog(null,"Escola não encontrada");
			}else {
				janela.getFrame().dispose();
				JanelaPerfil jp= new JanelaPerfil(valor);
				jp.getFrame().setVisible(true);
			
			}
		}


		public JanelaLogin getJanela() {
			return janela;
		}


		public void setJanela(JanelaLogin janela) {
			this.janela = janela;
		}


	}

}