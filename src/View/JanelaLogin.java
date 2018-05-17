package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;
import java.awt.Color;

public class JanelaLogin{

	private JFrame frame;
	private PainelLogin painel;

	public PainelLogin getPainel() {
		return painel;
	}

	public void setPainel(PainelLogin painel) {
		this.painel = painel;
	}

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

		painel= new PainelLogin();
		painel.setBounds(50, 80, 450, 296);
		painel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(painel);
		
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

}
