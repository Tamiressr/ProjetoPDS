package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteEditaPerfil;
import Ouvintes.OuvinteExcluirConta;
import Ouvintes.OuvinteGerenciarTurma;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import Ouvintes.OuvinteListaEscolas;
import Ouvintes.OuvinteSair;

import javax.swing.JButton;

public class JanelaPerfil {

	private JFrame frame;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPerfil window = new JanelaPerfil(id);
					window.frame.setVisible(true);
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
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(436, 22, 85, 40);
		OuvinteSair ouvinteSair=new OuvinteSair(this);
		btnSair.addActionListener(ouvinteSair);
		frame.getContentPane().add(btnSair);

		JButton btnEditarPerfil = new JButton("Editar Informa\u00E7\u00F5es");
		btnEditarPerfil.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditarPerfil.setBounds(266, 22, 160, 40);
		OuvinteEditaPerfil ouvinteEditaPerfil=new OuvinteEditaPerfil(frame, id);
		btnEditarPerfil.addActionListener(ouvinteEditaPerfil);
		frame.getContentPane().add(btnEditarPerfil);

		JButton btnExcluirConta = new JButton("Excluir Conta");
		btnExcluirConta.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirConta.setBackground(Color.red);
		btnExcluirConta.setBounds(411, 449, 123, 40);
		OuvinteExcluirConta ouvinteExcluirConta=new OuvinteExcluirConta(frame,id);
		btnExcluirConta.addActionListener(ouvinteExcluirConta);
		frame.getContentPane().add(btnExcluirConta);
		
		JButton btnGerenciarTurmas = new JButton("Gerenciar Turmas");
		btnGerenciarTurmas.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGerenciarTurmas.setBounds(10, 22, 150, 40);
		OuvinteGerenciarTurma ouvinteGerenciarTurma=new OuvinteGerenciarTurma(frame, id);
		btnGerenciarTurmas.addActionListener(ouvinteGerenciarTurma);
		frame.getContentPane().add(btnGerenciarTurmas);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
