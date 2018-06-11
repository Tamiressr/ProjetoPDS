package View;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaFeedback;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;

public class Janela {

	public Janela() {

	}

	public JFrame contruiJanela(JFrame frame) {
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

		return frame;
	}

	public static JMenuBar setMenuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();

		JMenu mnreaDaEscola = new JMenu("Iniciar");
	
		menuBar.add(mnreaDaEscola);

		JMenuItem menufeedback = new JMenuItem(" Feedback");

		menuBar.add(menufeedback);

		
		OuvinteJanelaFeedback jf = new OuvinteJanelaFeedback(frame);
		menufeedback.addActionListener(jf);
	
		JMenuItem mntmLogin = new JMenuItem("Login");
		OuvinteJanelaLogin ouvinteJanelaLogin = new OuvinteJanelaLogin(frame);
		mntmLogin.addActionListener(ouvinteJanelaLogin);
		mnreaDaEscola.add(mntmLogin);

		JMenuItem mntmListaEscolas = new JMenuItem("Listar Escolas");
		OuvinteListaEscolas ouvinteListaEscolas = new OuvinteListaEscolas(frame);
		mntmListaEscolas.addActionListener(ouvinteListaEscolas);
		mnreaDaEscola.add(mntmListaEscolas);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Escola");
		OuvinteJanelaCadastro ouvinteJanelaCadatro = new OuvinteJanelaCadastro(frame);
		mntmCadastrar.addActionListener(ouvinteJanelaCadatro);
		mnreaDaEscola.add(mntmCadastrar);

			return menuBar;

	}

}
