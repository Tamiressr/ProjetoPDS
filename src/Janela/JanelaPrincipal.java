package Janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.LayoutStyle.ComponentPlacement;

import Ouvintes.OuvinteLogin;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class JanelaPrincipal {

	private JFrame frmPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setType(Type.UTILITY);
		frmPrincipal.setTitle("Acompanhamento de Vagas");
		frmPrincipal.setBounds(100, 100, 550, 520);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.setLocation(400, 100);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		JMenu mnreaDaEscola = new JMenu("Escola");
		menuBar.add(mnreaDaEscola);

		JMenuItem mntmLogin = new JMenuItem("Login");
		mnreaDaEscola.add(mntmLogin);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		OuvinteLogin ouvinteLogin = new OuvinteLogin(frmPrincipal);
		mntmCadastrar.addActionListener(ouvinteLogin);
		mnreaDaEscola.add(mntmCadastrar);
		frmPrincipal.getContentPane().setLayout(null);
	}

	public JFrame getFrmPrincipal() {
		return frmPrincipal;
	}

	public void setFrmPrincipal(JFrame frmPrincipal) {
		this.frmPrincipal = frmPrincipal;
	}
	
	
}
