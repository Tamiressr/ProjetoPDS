package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;
import Ouvintes.OuvinteVoltarInicio;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Escola;
import Model.Facade;
import javax.swing.JButton;

public class JanelaListaEscolas {

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
					JanelaListaEscolas window = new JanelaListaEscolas();
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
	public JanelaListaEscolas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame=new JFrame();
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("Acompanhamento de Vagas");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 550, 550);
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.setVisible(true);
		
		frame.getContentPane().setLayout(null);
		modelo = new DefaultTableModel();

		modelo.addColumn("NOME");
		modelo.addColumn("CNPJ");
		modelo.addColumn("LINK");
		modelo.addColumn("EMAIL");
		modelo.addColumn("NIVEL GOVERNAMENTAL");
		
		List<Escola> list=Facade.getFacade().listar();
		
		
		Object[] array = new Object[6];
		for (Escola e : list) {
			array[0] = e.getNome();
			array[1] =e.getCnpj();
			array[2]=e.getLink();
			array[3]=e.getEmail();
			array[4]=e.getNivelDeGoverno();
			modelo.addRow(array);
		}

		table = new JTable(modelo);

		JScrollPane painelTabela = new JScrollPane(table);
		painelTabela.setBounds(50, 150, 450, 250);
		frame.getContentPane().add(painelTabela);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(408, 11, 92, 40);
		OuvinteVoltarInicio ouvinteVoltarInicio=new OuvinteVoltarInicio(frame);
		btnVoltar.addActionListener(ouvinteVoltarInicio);
		frame.getContentPane().add(btnVoltar);
		
		
		
		
		
	}
}
