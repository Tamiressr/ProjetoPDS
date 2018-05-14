package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteEditaPerfil;
import Ouvintes.OuvinteExcluirConta;
import Ouvintes.OuvinteJanelaCadatro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import Ouvintes.OuvinteListaEscolas;
import javax.swing.JButton;

public class JanelaPerfil {

	private JFrame frame;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					JanelaPerfil window = new JanelaPerfil();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPerfil(int id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("Acompanhamento de Vagas");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 550, 550);
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnreaDaEscola = new JMenu("Escola");
		menuBar.add(mnreaDaEscola);

		JMenuItem mntmLogin = new JMenuItem("Login");
		OuvinteJanelaLogin ouvinteJanelaLogin = new OuvinteJanelaLogin(frame);
		mntmLogin.addActionListener(ouvinteJanelaLogin);
		mnreaDaEscola.add(mntmLogin);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		OuvinteJanelaCadatro ouvinteJanelaCadatro = new OuvinteJanelaCadatro(frame);
		mntmCadastrar.addActionListener(ouvinteJanelaCadatro);
		mnreaDaEscola.add(mntmCadastrar);

		frame.getContentPane().setLayout(null);

		JMenuItem mntmListaEscolas = new JMenuItem("Lista Escolas");
		OuvinteListaEscolas ouvinteListaEscolas = new OuvinteListaEscolas(frame);
		mntmListaEscolas.addActionListener(ouvinteListaEscolas);
		mnreaDaEscola.add(mntmListaEscolas);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(436, 22, 85, 40);
		frame.getContentPane().add(btnSair);

		JButton btnEditarPerfil = new JButton("Editar Informa\u00E7\u00F5es");
		btnEditarPerfil.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditarPerfil.setBounds(266, 22, 160, 40);
		OuvinteEditaPerfil ouvinteEditaPerfil=new OuvinteEditaPerfil(frame, id);
		btnEditarPerfil.addActionListener(ouvinteEditaPerfil);
		frame.getContentPane().add(btnEditarPerfil);

		JButton btnExcluirConta = new JButton("Excluir Conta");
		btnExcluirConta.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirConta.setBounds(106, 22, 150, 40);
		OuvinteExcluirConta ouvinteExcluirConta=new OuvinteExcluirConta(frame,id);
		btnExcluirConta.addActionListener(ouvinteExcluirConta);
		frame.getContentPane().add(btnExcluirConta);

	}
}
