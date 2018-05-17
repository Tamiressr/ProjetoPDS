package View;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;

public class Janela {
	
	public Janela() {
		
	}
	public static JMenuBar setMenuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnreaDaEscola = new JMenu("Iniciar");
		menuBar.add(mnreaDaEscola);

		JMenuItem mntmLogin = new JMenuItem("Login");
		OuvinteJanelaLogin ouvinteJanelaLogin=new OuvinteJanelaLogin(frame);
		mntmLogin.addActionListener(ouvinteJanelaLogin);
		mnreaDaEscola.add(mntmLogin);

		
		JMenuItem mntmListaEscolas = new JMenuItem("Lista Escolas");
		OuvinteListaEscolas ouvinteListaEscolas=new OuvinteListaEscolas(frame);
		mntmListaEscolas.addActionListener(ouvinteListaEscolas);
		mnreaDaEscola.add(mntmListaEscolas);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Escola");
		OuvinteJanelaCadastro ouvinteJanelaCadatro= new OuvinteJanelaCadastro(frame);
		mntmCadastrar.addActionListener(ouvinteJanelaCadatro);
		mnreaDaEscola.add(mntmCadastrar);
		
		
		
		
		return menuBar;
		
	}
	

	

}
