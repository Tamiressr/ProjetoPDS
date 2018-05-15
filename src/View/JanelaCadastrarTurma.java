package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Ouvintes.OuvinteGerenciarTurma;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteListaEscolas;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;

import org.jdesktop.swingx.JXRadioGroup;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaCadastrarTurma {

	private JFrame frame;
	private String[] serie= {"   1º","   2º","   3º","   4º","   5º","   6º","   7º","   8º","   9º"};
	private JTextField txtQuantidadetotaldevagas;
	private JTextField txtQuantidadedisponivel;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarTurma window = new JanelaCadastrarTurma(1);
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
	public JanelaCadastrarTurma(int id) {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(38, 65, 473, 165);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSrie = new JLabel("S\u00E9rie");
		lblSrie.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSrie.setBounds(18, 12, 48, 19);
		panel.add(lblSrie);
		
		JComboBox comboBox = new JComboBox(serie);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(62, 11, 65, 20);
		panel.add(comboBox);
		
		ButtonGroup menu=new ButtonGroup();
		
		
		JRadioButton rdbtnManh = new JRadioButton("Manh\u00E3");
		rdbtnManh.setBounds(18, 41, 109, 23);
		panel.add(rdbtnManh);
		menu.add(rdbtnManh);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setBounds(18, 71, 109, 23);
		panel.add(rdbtnTarde);
		menu.add(rdbtnTarde);
		
		JRadioButton rdbtnNoite = new JRadioButton("Noite");
		rdbtnNoite.setBounds(18, 101, 109, 23);
		panel.add(rdbtnNoite);
		menu.add(rdbtnNoite);
		
		JRadioButton rdbtnIntegral = new JRadioButton("Integral");
		rdbtnIntegral.setBounds(18, 131, 109, 23);
		panel.add(rdbtnIntegral);
		menu.add(rdbtnIntegral);
		
		JLabel lblQuantidadeTotalDe = new JLabel("Quantidade Total de Vagas na Turma");
		lblQuantidadeTotalDe.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuantidadeTotalDe.setBounds(171, 12, 280, 14);
		panel.add(lblQuantidadeTotalDe);
		
		txtQuantidadetotaldevagas = new JTextField();
		txtQuantidadetotaldevagas.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQuantidadetotaldevagas.setBounds(181, 38, 118, 20);
		panel.add(txtQuantidadetotaldevagas);
		txtQuantidadetotaldevagas.setColumns(10);
		
		JLabel lblQuantidadeDisponivelDe = new JLabel("Quantidade Disponivel de Vagas na Turma");
		lblQuantidadeDisponivelDe.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuantidadeDisponivelDe.setBounds(171, 71, 280, 14);
		panel.add(lblQuantidadeDisponivelDe);
		
		txtQuantidadedisponivel = new JTextField();
		txtQuantidadedisponivel.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQuantidadedisponivel.setBounds(181, 97, 118, 20);
		panel.add(txtQuantidadedisponivel);
		txtQuantidadedisponivel.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(362, 131, 89, 23);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(38, 264, 473, 209);
		frame.getContentPane().add(panel_1);
		
		JButton btnVolta = new JButton("Volta");
		btnVolta.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVolta.setBounds(361, 14, 150, 40);
//		OuvinteGerenciarTurma ouvinteGerenciarTurma=new OuvinteGerenciarTurma(this,id);
		frame.getContentPane().add(btnVolta);
		
		
		
		
	}
}
