package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteCadastrarTurma;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import Ouvintes.OuvinteListaEscolas;
import Ouvintes.OuvinteListaTurma;
import Ouvintes.OuvinteSalvaTurma;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Escola;
import Model.Facade;
import Model.Turma;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class JanelaGerenciarTurma {

	private JFrame frame;
	private JTextField textField;
	private int id;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel;
	private JButton btnCadastrarTurma;
	private JButton btnListaTurma;
	private JTable table;
	private DefaultTableModel modelo;
	private String[] serie= {"  1º","  2º","  3º","  4º","  5º","  6º","  7º","  8º","  9º"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaGerenciarTurma window = new JanelaGerenciarTurma(1);
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
	public JanelaGerenciarTurma(int id) {
		this.id=id;
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
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.setVisible(true);
		
		
		btnCadastrarTurma = new JButton("Cadastrar Turma");
		btnCadastrarTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrarTurma.setBounds(190, 22, 150, 40);
		OuvinteCadastrarTurma ouvinteCadastrarTurma=new OuvinteCadastrarTurma(this, id);
		btnCadastrarTurma.addActionListener(ouvinteCadastrarTurma);
		frame.getContentPane().add(btnCadastrarTurma);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(367, 22, 150, 40);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProcurar.setBounds(367, 82, 150, 40);
		frame.getContentPane().add(btnProcurar);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(129, 90, 211, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnIntegral = new JRadioButton("Integral");
		rdbtnIntegral.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnIntegral.setBounds(39, 156, 75, 25);
		frame.getContentPane().add(rdbtnIntegral);

		JRadioButton rdbtnManh = new JRadioButton("Manh\u00E3");
		rdbtnManh.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnManh.setBounds(144, 156, 75, 25);
		frame.getContentPane().add(rdbtnManh);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnTarde.setBounds(249, 156, 75, 25);
		frame.getContentPane().add(rdbtnTarde);
		
		JRadioButton rdbtnNoite = new JRadioButton("Noite");
		rdbtnNoite.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnNoite.setBounds(354, 156, 75, 25);
		frame.getContentPane().add(rdbtnNoite);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 22, 75, 40);
		OuvinteJanelaPerfil ouvinteJanelaPerfil=new OuvinteJanelaPerfil(frame, id);
		btnVoltar.addActionListener(ouvinteJanelaPerfil);
		frame.getContentPane().add(btnVoltar);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(39, 203, 478, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(428, 141, 89, 40);
		frame.getContentPane().add(btnEditar);
		
	}
	
	public void addPainel() {
		JLabel label = new JLabel("S\u00E9rie");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(22, 23, 48, 19);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox(serie);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(66, 22, 65, 20);
		panel.add(comboBox);
		
		ButtonGroup grupo=new ButtonGroup();
		
		
		JRadioButton radioButton = new JRadioButton("Manh\u00E3");
		radioButton.setBounds(22, 52, 109, 23);
		grupo.add(radioButton);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Tarde");
		radioButton_1.setBounds(22, 82, 109, 23);
		grupo.add(radioButton_1);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Noite");
		radioButton_2.setBounds(22, 112, 109, 23);
		grupo.add(radioButton_2);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Integral");
		radioButton_3.setBounds(22, 142, 109, 23);
		grupo.add(radioButton_3);
		panel.add(radioButton_3);
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(185, 108, 118, 23);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("Quantidade Disponivel de Vagas na Turma");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(175, 82, 280, 14);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(185, 49, 118, 23);
		panel.add(textField_2);
		
		JLabel label_2 = new JLabel("Quantidade Total de Vagas na Turma");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(175, 23, 280, 14);
		panel.add(label_2);
		
		JButton button = new JButton("Salvar");
		button.setFont(new Font("Arial", Font.PLAIN, 14));
		button.setBounds(366, 142, 89, 23);
		OuvinteSalvaTurma ouvinteSalvaTurma=new OuvinteSalvaTurma(id, this);
		button.addActionListener(ouvinteSalvaTurma);
		panel.add(button);
	}
	
	public void listaTurma() {
		table = new JTable();
		table.setBounds(10, 11, 458, 172);
		panel.add(table);
		
		frame.getContentPane().setLayout(null);
		modelo = new DefaultTableModel();

		modelo.addColumn("Escolas");

//		List<Escola> list=Facade.getFacade().listar();
		Escola o=Facade.getFacade().procurarEscolaPorCnpj(id);
		List<Turma> list=o.getTurmas();
				
		for (Turma e : list) {
			Object[] array = new Object[1];
			array[0] = e.toString();
			modelo.addRow(array);
		}

		table = new JTable(modelo);

		JScrollPane painelTabela = new JScrollPane(table);
		painelTabela.setBounds(50, 150, 450, 250);
		frame.getContentPane().add(painelTabela);
		
		
	}
	
	public void addBotaoLista() {
		btnListaTurma=new JButton("Lista Turmas");
		btnListaTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListaTurma.setBounds(190, 22, 150, 40);
		OuvinteListaTurma ouvinteListaTurma=new OuvinteListaTurma(this, id);
		btnListaTurma.addActionListener(ouvinteListaTurma);
		frame.getContentPane().add(btnListaTurma);
		
	}
	

	public JButton getBtnCadastrarTurma() {
		return btnCadastrarTurma;
	}

	public void setBtnCadastrarTurma(JButton btnCadastrarTurma) {
		this.btnCadastrarTurma = btnCadastrarTurma;
	}
	
	public JButton getBtnListaTurma() {
		return btnListaTurma;
	}

	public void setBtnListaTurma(JButton btnListaTurma) {
		this.btnListaTurma = btnListaTurma;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}

