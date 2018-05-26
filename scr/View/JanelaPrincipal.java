package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
<<<<<<< HEAD
<<<<<<< HEAD

import java.awt.Color;
import java.awt.Cursor;
=======
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34
=======
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34

import java.awt.Color;
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
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import Controllers.EscolaController;
import Model.Escola;

=======
import Controllers.EscolaController;
import Model.Escola;
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34
=======
import Controllers.EscolaController;
import Model.Escola;
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34


public class JanelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// UIManager.setLookAndFeel(new GraphiteLookAndFeel());
					// UIManager.setLookAndFeel(new AeroLookAndFeel());
<<<<<<< HEAD
				UIManager.setLookAndFeel(new BernsteinLookAndFeel());
=======
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34

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
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("Acompanhamento de Vagas");
		frame.setResizable(false);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.getContentPane().setLayout(null);

		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setFont(new Font("Arial", Font.BOLD, 14));
		lblEscola.setBounds(10, 49, 77, 14);
		frame.getContentPane().add(lblEscola);

		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("Arial", Font.BOLD, 14));
		lblTurma.setBounds(10, 74, 60, 14);
		frame.getContentPane().add(lblTurma);

		JComboBox EscolacomboBox = new JComboBox();
		EscolacomboBox.setBounds(63, 47, 283, 20);
		frame.getContentPane().add(EscolacomboBox);

		List<Escola> escolas = EscolaController.getEscolaController().listar();

		for (Escola e : escolas) {
			EscolacomboBox.addItem(e.getNome());
		}
<<<<<<< HEAD
<<<<<<< HEAD
		String[] arrayturmas = { "1� ano", "2� ano", "3� ano", "4� ano", "5� ano", " 6� ano", "7� ano", "8� ano",
				"9� ano" };
=======
		String[] arrayturmas = { "1º ano", "2º ano", "3º ano", "4º ano", "5º ano", " 6º ano", "7º ano", "8º ano",
				"9º ano" };
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34
=======
		String[] arrayturmas = { "1º ano", "2º ano", "3º ano", "4º ano", "5º ano", " 6º ano", "7º ano", "8º ano",
				"9º ano" };
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34
		JComboBox TurmacomboBox = new JComboBox(arrayturmas);

		TurmacomboBox.setBounds(65, 72, 129, 20);
		frame.getContentPane().add(TurmacomboBox);

		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Arial", Font.BOLD, 14));
		lblTurno.setBounds(204, 74, 46, 14);
		frame.getContentPane().add(lblTurno);
<<<<<<< HEAD
<<<<<<< HEAD
		String[]turnos= {"MANH�","TARDE","INTEGRAL","NOITE"};
=======
		String[]turnos= {"MANHÃ","TARDE","INTEGRAL","NOITE"};
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34
=======
		String[]turnos= {"MANHÃ","TARDE","INTEGRAL","NOITE"};
>>>>>>> c6074e61fc6b6dbb001932f8ecf256fa0a3daf34
		JComboBox TurnocomboBox = new JComboBox(turnos);
		TurnocomboBox.setBounds(262, 72, 84, 20);
		frame.getContentPane().add(TurnocomboBox);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btnPesquisar.setBounds(396, 49, 109, 42);
		frame.getContentPane().add(btnPesquisar);
		frame.setVisible(true);


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
