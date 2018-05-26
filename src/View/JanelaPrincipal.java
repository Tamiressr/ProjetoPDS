package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Cursor;


import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
//import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

//import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
=======
>>>>>>> parent of 5b4ff95... Merge branch 'master' of https://github.com/Tamiressr/ProjetoPDS
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;


<<<<<<< HEAD
=======
>>>>>>> cbdc1eab8dc5de6aeb94dd5842d24d710bbf64cd
=======
>>>>>>> cbdc1eab8dc5de6aeb94dd5842d24d710bbf64cd
=======
>>>>>>> 5061d9e471ab85b86c6add4206d9014f7330a12f
>>>>>>> parent of 5b4ff95... Merge branch 'master' of https://github.com/Tamiressr/ProjetoPDS

public class JanelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
					// UIManager.setLookAndFeel(new GraphiteLookAndFeel());
					// UIManager.setLookAndFeel(new AeroLookAndFeel());
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
=======
=======
//					UIManager.setLookAndFeel(new GraphiteLookAndFeel());
//					UIManager.setLookAndFeel(new AeroLookAndFeel());
//					UIManager.setLookAndFeel(new BernsteinLookAndFeel());


					// UIManager.setLookAndFeel(new GraphiteLookAndFeel());
					// UIManager.setLookAndFeel(new AeroLookAndFeel());
					// UIManager.setLookAndFeel(new GraphiteLookAndFeel());
					// UIManager.setLookAndFeel(new AeroLookAndFeel());
//					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 5b4ff95... Merge branch 'master' of https://github.com/Tamiressr/ProjetoPDS

					// UIManager.setLookAndFeel(new GraphiteLookAndFeel());
					// UIManager.setLookAndFeel(new AeroLookAndFeel());

//					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
>>>>>>> cbdc1eab8dc5de6aeb94dd5842d24d710bbf64cd
=======

					// UIManager.setLookAndFeel(new GraphiteLookAndFeel());
					// UIManager.setLookAndFeel(new AeroLookAndFeel());
<<<<<<< HEAD

//					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
>>>>>>> cbdc1eab8dc5de6aeb94dd5842d24d710bbf64cd
=======
>>>>>>> 7f5d2d5979776d77f11147240e7675f1e1b25556
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
>>>>>>> 5061d9e471ab85b86c6add4206d9014f7330a12f
>>>>>>> parent of 5b4ff95... Merge branch 'master' of https://github.com/Tamiressr/ProjetoPDS

					JanelaPrincipal window = new JanelaPrincipal();
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
	public JanelaPrincipal() {
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
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
