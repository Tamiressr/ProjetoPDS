package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;

import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import Controllers.EscolaController;
import Controllers.TurmaController;
import Model.Escola;
import Model.Facade;
import Model.Turma;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class JanelaListarVagas {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());

					JanelaListarVagas window = new JanelaListarVagas();
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
	public JanelaListarVagas() {
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

		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		
		JScrollPane painelTabela = new JScrollPane(table);
		painelTabela.setBounds(10, 131, 524, 279);
		frame.getContentPane().add(painelTabela);
		
		JLabel lblListagemDeVagas = new JLabel("Listagem de Vagas");
		lblListagemDeVagas.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblListagemDeVagas.setBounds(139, 38, 335, 55);
		frame.getContentPane().add(lblListagemDeVagas);
		addTabela();

	}


	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	
	public void addTabela() {
		frame.repaint();
	 List<Turma> list = TurmaController.getTurmaController().listar();

		modelo.addColumn("Escola");
		modelo.addColumn("Turma");
		modelo.addColumn("Turno");
		modelo.addColumn("N° Total de Vagas");
		modelo.addColumn("Vagas Disponíveis");
		JTable tabela= new JTable(modelo);
	
	
		Object[] array = new Object[5];
	 for (Turma e : list) {
	array[0]=e.getEscola().getNome();
	 array[1] = e.getNome();
	 array[2]=e.getTurno();
	 array[3]=e.getNumeroDeVagas();
	 array[4]=e.getNumeroDeVagasDiponiveis();
	 modelo.addRow(array);
	 }
	
	}

}

