package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controllers.EscolaController;
import Model.Escola;
import Ouvintes.OuvinteEditaPerfil;
import Ouvintes.OuvinteExcluirConta;
import Ouvintes.OuvinteGerenciarTurma;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import Ouvintes.OuvinteListaEscolas;
import Ouvintes.OuvinteSair;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class JanelaPerfil {

	private JFrame frame;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPerfil window = new JanelaPerfil(id);
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
	
	public JanelaPerfil(int id) {
		this.id=id;
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
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSair.setBounds(436, 22, 85, 40);
		OuvinteSair ouvinteSair=new OuvinteSair(this);
		btnSair.addActionListener(ouvinteSair);
		frame.getContentPane().add(btnSair);

		JButton btnEditarPerfil = new JButton("Editar Informa\u00E7\u00F5es");
		btnEditarPerfil.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditarPerfil.setBounds(266, 22, 160, 40);
		OuvinteEditaPerfil ouvinteEditaPerfil=new OuvinteEditaPerfil(frame, id);
		btnEditarPerfil.addActionListener(ouvinteEditaPerfil);
		frame.getContentPane().add(btnEditarPerfil);

		JButton btnExcluirConta = new JButton("Excluir Conta");
		btnExcluirConta.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirConta.setBackground(new Color(240, 96, 99));
		btnExcluirConta.setBounds(411, 449, 123, 40);
		OuvinteExcluirConta ouvinteExcluirConta=new OuvinteExcluirConta(frame,id);
		btnExcluirConta.addActionListener(ouvinteExcluirConta);
		frame.getContentPane().add(btnExcluirConta);


		JButton btnGerenciarSeries = new JButton("Gerenciar Turmas");
		btnGerenciarSeries.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGerenciarSeries.setBounds(10, 22, 150, 40);
	
		JLabel nomeEscola = new JLabel("Nome:");
		nomeEscola.setFont(new Font("Arial", Font.BOLD, 14));
		nomeEscola.setBounds(20, 73, 46, 24);
		frame.getContentPane().add(nomeEscola);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));
		lblCnpj.setBounds(20, 101, 46, 14);
		frame.getContentPane().add(lblCnpj);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Arial", Font.BOLD, 14));
		lblRua.setBounds(20, 126, 46, 14);
		frame.getContentPane().add(lblRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumero.setBounds(20, 151, 67, 14);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBackground(Color.BLACK);
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));
		lblCidade.setBounds(297, 151, 62, 14);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		lblCep.setBounds(297, 101, 46, 14);
		frame.getContentPane().add(lblCep);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setBounds(297, 121, 46, 24);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));
		lblBairro.setBounds(20, 176, 54, 14);
		frame.getContentPane().add(lblBairro);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setIcon(new ImageIcon(JanelaPerfil.class.getResource("/a.jpg")));
		lblNewLabel.setBounds(0, 244, 569, 353);
		frame.getContentPane().add(lblNewLabel);
		
		
		Escola e=EscolaController.getEscolaController().procurarEscola(id);
		
		JLabel lblMnome = new JLabel(e.getNome());
		lblMnome.setBounds(76, 78, 267, 14);
		frame.getContentPane().add(lblMnome);
		
		JLabel lblMcnpj = new JLabel(e.getCnpj());
		lblMcnpj.setBounds(76, 102, 211, 14);
		frame.getContentPane().add(lblMcnpj);
		
		JLabel lblMrua = new JLabel(e.getRua());
		lblMrua.setBounds(76, 127, 211, 13);
		frame.getContentPane().add(lblMrua);
		
		JLabel lblMnumero = new JLabel(""+e.getNumeroCasa());
		lblMnumero.setBounds(97, 152, 35, 14);
		frame.getContentPane().add(lblMnumero);
		
		JLabel lblMbairro = new JLabel(e.getBairro());
		lblMbairro.setBounds(79, 177, 208, 14);
		frame.getContentPane().add(lblMbairro);
		
		JLabel lblMcep = new JLabel(e.getCep());
		lblMcep.setBounds(353, 102, 181, 14);
		frame.getContentPane().add(lblMcep);
		
		JLabel lblMlogin = new JLabel(e.getEmail());
		lblMlogin.setBounds(353, 127, 181, 14);
		frame.getContentPane().add(lblMlogin);
		
		JLabel lblMcidade = new JLabel(e.getCidade());
		lblMcidade.setBounds(353, 152, 181, 14);
		frame.getContentPane().add(lblMcidade);
		
		JLabel lblLink = new JLabel("Link:");
		lblLink.setFont(new Font("Arial", Font.BOLD, 14));
		lblLink.setBounds(20, 203, 46, 14);
		frame.getContentPane().add(lblLink);
		
		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelefone.setBounds(297, 176, 76, 14);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblMlink = new JLabel(e.getLink());
		lblMlink.setBounds(60, 202, 227, 14);
		frame.getContentPane().add(lblMlink);
		
		JLabel lblMtelefonef = new JLabel(" Fixo "+e.getTelefone().get(1));
		lblMtelefonef.setBounds(375, 177, 133, 14);
		frame.getContentPane().add(lblMtelefonef);
		
		JLabel lblMtelefonec = new JLabel(" Celular "+e.getTelefone().get(0));
		lblMtelefonec.setBounds(375, 204, 146, 14);
		frame.getContentPane().add(lblMtelefonec);
		JButton btnGerenciarTurmas = new JButton("Gerenciar Turmas");
		btnGerenciarTurmas.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGerenciarTurmas.setBounds(10, 22, 150, 40);
		
		OuvinteGerenciarTurma ouvinteGerenciarTurma=new OuvinteGerenciarTurma(frame, id);
		btnGerenciarTurmas.addActionListener(ouvinteGerenciarTurma);
		frame.getContentPane().add(btnGerenciarTurmas);
		

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
