package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteCadastrarTurma;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import Ouvintes.OuvinteListaEscolas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class JanelaGerenciarTurma {

	private JFrame frame;
	private JTextField textField;
	private int id;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel;

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
		
		
		JButton btnCadastrarTurma = new JButton("Cadastrar Turma");
		btnCadastrarTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrarTurma.setBounds(190, 11, 150, 40);
		OuvinteCadastrarTurma ouvinteCadastrarTurma=new OuvinteCadastrarTurma(this, id);
		btnCadastrarTurma.addActionListener(ouvinteCadastrarTurma);
		frame.getContentPane().add(btnCadastrarTurma);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(367, 11, 150, 40);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProcurar.setBounds(367, 62, 150, 40);
		frame.getContentPane().add(btnProcurar);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(129, 70, 211, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnIntegral = new JRadioButton("Integral");
		rdbtnIntegral.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnIntegral.setBounds(39, 128, 75, 25);
		frame.getContentPane().add(rdbtnIntegral);

		JRadioButton rdbtnManh = new JRadioButton("Manh\u00E3");
		rdbtnManh.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnManh.setBounds(144, 128, 75, 25);
		frame.getContentPane().add(rdbtnManh);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnTarde.setBounds(249, 128, 75, 25);
		frame.getContentPane().add(rdbtnTarde);
		
		JRadioButton rdbtnNoite = new JRadioButton("Noite");
		rdbtnNoite.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnNoite.setBounds(354, 128, 75, 25);
		frame.getContentPane().add(rdbtnNoite);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 11, 75, 40);
		OuvinteJanelaPerfil ouvinteJanelaPerfil=new OuvinteJanelaPerfil(frame, id);
		btnVoltar.addActionListener(ouvinteJanelaPerfil);
		frame.getContentPane().add(btnVoltar);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(39, 173, 478, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(428, 113, 89, 40);
		frame.getContentPane().add(btnEditar);
		
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
	
	public void addPainel() {
		JLabel label = new JLabel("S\u00E9rie");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(22, 23, 48, 19);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(66, 22, 65, 20);
		panel.add(comboBox);
		
		JRadioButton radioButton = new JRadioButton("Manh\u00E3");
		radioButton.setBounds(22, 52, 109, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Tarde");
		radioButton_1.setBounds(22, 82, 109, 23);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Noite");
		radioButton_2.setBounds(22, 112, 109, 23);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Integral");
		radioButton_3.setBounds(22, 142, 109, 23);
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
		panel.add(button);
	}
	
	public void listaSeries() {
		
	}
}

