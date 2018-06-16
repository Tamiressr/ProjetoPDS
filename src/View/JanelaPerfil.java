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
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import OuvintesDocumentos.OuvinteDocumentos;
import OuvintesEscolas.OuvinteEditaPerfil;
import OuvintesEscolas.OuvinteExcluirConta;
import OuvintesEscolas.OuvinteListaEscolas;
import OuvintesEscolas.OuvinteSair;
import OuvintesTurma.OuvinteGerenciarTurma;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

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
		this.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("SISTEMA DE ACOMPANHAMENTO DE VAGAS");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 550, 550);
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuItem menuSair = new JMenuItem("Sair");
		OuvinteSair ouvinteSair = new OuvinteSair(this);
		menuSair.addActionListener(ouvinteSair);

		JMenuBar menu = Janela.setMenuBar(frame);
		menu.add(menuSair);
		frame.setJMenuBar(menu);

		JButton btnEditarPerfil = new JButton("Editar Cadastro");
		btnEditarPerfil.setBounds(10, 270, 147, 47);
		btnEditarPerfil.setFont(new Font("Arial", Font.PLAIN, 14));
		OuvinteEditaPerfil ouvinteEditaPerfil = new OuvinteEditaPerfil(frame, id);
		btnEditarPerfil.addActionListener(ouvinteEditaPerfil);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnEditarPerfil);

		JButton btnExcluirConta = new JButton("Excluir Conta");
		btnExcluirConta.setBounds(10, 462, 147, 24);
		btnExcluirConta.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirConta.setBackground(new Color(240, 96, 99));
		OuvinteExcluirConta ouvinteExcluirConta = new OuvinteExcluirConta(frame, id);
		btnExcluirConta.addActionListener(ouvinteExcluirConta);
		frame.getContentPane().add(btnExcluirConta);

		JButton btnGerenciarSeries = new JButton("Gerenciar Turmas");
		btnGerenciarSeries.setBounds(10, 321, 147, 47);
		btnGerenciarSeries.setFont(new Font("Arial", Font.PLAIN, 14));
		OuvinteGerenciarTurma ouvinteGerenciarTurma = new OuvinteGerenciarTurma(frame, id);
		btnGerenciarSeries.addActionListener(ouvinteGerenciarTurma);
		frame.getContentPane().add(btnGerenciarSeries);

		JLabel nomeEscola = new JLabel("Nome:");
		nomeEscola.setBounds(20, 73, 46, 24);
		nomeEscola.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(nomeEscola);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(20, 101, 46, 14);
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblCnpj);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(20, 126, 46, 14);
		lblRua.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblRua);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(20, 151, 67, 14);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblNumero);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(297, 151, 62, 14);
		lblCidade.setBackground(Color.BLACK);
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblCidade);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(297, 101, 46, 14);
		lblCep.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblCep);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(297, 121, 46, 24);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblLogin);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(20, 176, 54, 14);
		lblBairro.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblBairro);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(167, 213, 383, 353);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(JanelaPerfil.class.getResource("/a.jpg")));
		frame.getContentPane().add(lblNewLabel);

		Escola e = EscolaController.getEscolaController().procurarEscola(id);

		JLabel lblMnome = new JLabel(e.getNome());
		lblMnome.setBounds(76, 78, 267, 14);
		frame.getContentPane().add(lblMnome);

		JLabel lblMcnpj = new JLabel(e.getCnpj());
		lblMcnpj.setBounds(76, 102, 211, 14);
		frame.getContentPane().add(lblMcnpj);

		JLabel lblMrua = new JLabel(e.getRua());
		lblMrua.setBounds(76, 127, 211, 13);
		frame.getContentPane().add(lblMrua);

		JLabel lblMnumero = new JLabel("" + e.getNumeroCasa());
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
		lblLink.setBounds(20, 203, 46, 14);
		lblLink.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblLink);

		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(297, 176, 76, 14);
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
		frame.getContentPane().add(lblTelefone);

		JLabel lblMlink = new JLabel(e.getLink());
		lblMlink.setBounds(60, 202, 227, 14);
		frame.getContentPane().add(lblMlink);

		JButton btnDocumentao = new JButton("Documenta\u00E7\u00E3o");
		btnDocumentao.setBounds(10, 379, 147, 47);
		btnDocumentao.setFont(new Font("Arial", Font.PLAIN, 14));
		frame.getContentPane().add(btnDocumentao);

		JLabel lblJanelaPerfil = new JLabel("Meu Perfil");
		lblJanelaPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblJanelaPerfil.setBounds(219, 28, 124, 39);
		lblJanelaPerfil.setFont(new Font("Arial", Font.BOLD, 21));
		frame.getContentPane().add(lblJanelaPerfil);

		 OuvinteDocumentos ouvinteDocumentos=new OuvinteDocumentos(this, id);
		 btnDocumentao.addActionListener(ouvinteDocumentos);
		frame.getContentPane().add(btnDocumentao);

		if (e.getTelefone() != null) {
			JLabel lblMtelefonef = new JLabel("" + e.getTelefone().get(1));
			lblMtelefonef.setBounds(375, 177, 133, 14);
			frame.getContentPane().add(lblMtelefonef);

			JLabel lblMtelefonec = new JLabel("" + e.getTelefone().get(0));
			lblMtelefonec.setBounds(375, 204, 146, 14);
			frame.getContentPane().add(lblMtelefonec);
		}
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