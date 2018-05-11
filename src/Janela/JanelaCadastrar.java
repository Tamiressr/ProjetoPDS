package Janela;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import Ouvintes.OuvinteJanelaCadatro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteSalvar;
import Ouvintes.OuvinteVoltarInicio;

public class JanelaCadastrar{
	private JFrame frame;
	private JTextField textFielNome;
	private JTextField txtLinkdosite;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField txtRua;
	private JFormattedTextField txtNumero;
	private JTextField txtCidade;
	private JPasswordField txtCep;
	private JTextField txtBairro;
	private JFormattedTextField frmtdtxtfldTelefonefixo;
	private JFormattedTextField formattedTextFieldTelefoneCelular;
	private JComboBox comboBoxNivies;
	private String[] niveis={ "Municipal", "Estadual", "Federal" };
	private JTextField txtCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrar window = new JanelaCadastrar();
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
	public JanelaCadastrar() {
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
		OuvinteJanelaCadatro ouvinteJanelaCadatro= new OuvinteJanelaCadatro(frame);
		mntmCadastrar.addActionListener(ouvinteJanelaCadatro);
		mnreaDaEscola.add(mntmCadastrar);
		frame.getContentPane().setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JLabel lblCadastrar = new JLabel("Cadastro de Escola");
		lblCadastrar.setBounds(10, 32, 514, 37);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		frame.getContentPane().add(lblCadastrar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(10, 113, 103, 20);
		frame.getContentPane().add(lblNome);

		textFielNome = new JTextField();
		textFielNome.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFielNome.setFont(new Font("Arial", Font.PLAIN, 14));
		textFielNome.setBounds(94, 110, 173, 25);
		frame.getContentPane().add(textFielNome);
		textFielNome.setColumns(10);

		JLabel lblNvelDeEnsino = new JLabel("N\u00EDvel de Governo");
		lblNvelDeEnsino.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNvelDeEnsino.setBounds(10, 153, 117, 20);
		frame.getContentPane().add(lblNvelDeEnsino);

		comboBoxNivies= new JComboBox(niveis);
		comboBoxNivies.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBoxNivies.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxNivies.setBounds(121, 150, 146, 25);
		frame.getContentPane().add(comboBoxNivies);

		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefoneCelular.setBounds(277, 113, 109, 20);
		frame.getContentPane().add(lblTelefoneCelular);


		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(##) # ####-####");
			formattedTextFieldTelefoneCelular = new JFormattedTextField(mascaraTelefone);
			formattedTextFieldTelefoneCelular.setAlignmentX(Component.LEFT_ALIGNMENT);
			formattedTextFieldTelefoneCelular.setFont(new Font("Arial", Font.PLAIN, 14));
			formattedTextFieldTelefoneCelular.setBounds(396, 110, 117, 25);
			frame.getContentPane().add(formattedTextFieldTelefoneCelular);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblTelefoneFixo = new JLabel("Telefone Fixo");
		lblTelefoneFixo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefoneFixo.setBounds(294, 153, 92, 20);
		frame.getContentPane().add(lblTelefoneFixo);

		
		try {
			MaskFormatter mascaraTelefoneFixo = new MaskFormatter("(##) ####-####");
			frmtdtxtfldTelefonefixo = new JFormattedTextField(mascaraTelefoneFixo);
			frmtdtxtfldTelefonefixo.setAlignmentX(Component.LEFT_ALIGNMENT);
			frmtdtxtfldTelefonefixo.setFont(new Font("Arial", Font.PLAIN, 14));
			frmtdtxtfldTelefonefixo.setBounds(377, 150, 136, 25);
			frame.getContentPane().add(frmtdtxtfldTelefonefixo);

			frmtdtxtfldTelefonefixo.setText("TelefoneFixo");
			frmtdtxtfldTelefonefixo.setBounds(396, 150, 117, 25);
			frame.getContentPane().add(frmtdtxtfldTelefonefixo);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(20, 410, 150, 40);
		OuvinteVoltarInicio ouvinteVoltarInicio=new OuvinteVoltarInicio(this);
		btnVoltar.addActionListener(ouvinteVoltarInicio);
		frame.getContentPane().add(btnVoltar);

		JLabel lblLinkDoSite = new JLabel("Link do Site");
		lblLinkDoSite.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLinkDoSite.setBounds(10, 193, 103, 20);
		frame.getContentPane().add(lblLinkDoSite);

		txtLinkdosite = new JTextField();
		txtLinkdosite.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtLinkdosite.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLinkdosite.setBounds(94, 190, 173, 25);
		frame.getContentPane().add(txtLinkdosite);
		txtLinkdosite.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(294, 193, 92, 20);
		frame.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setBounds(367, 190, 146, 25);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(10, 233, 92, 20);
		frame.getContentPane().add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSenha.setBounds(94, 230, 173, 25);
		frame.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRua.setBounds(10, 273, 46, 20);
		frame.getContentPane().add(lblRua);

		txtRua = new JTextField();
		txtRua.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtRua.setFont(new Font("Arial", Font.PLAIN, 14));
		txtRua.setBounds(94, 270, 173, 25);
		frame.getContentPane().add(txtRua);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumero.setBounds(294, 273, 92, 20);
		frame.getContentPane().add(lblNumero);

		txtNumero = new JFormattedTextField();
		txtNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNumero.setBounds(367, 270, 146, 25);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCidade.setBounds(10, 313, 46, 20);
		frame.getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCidade.setBounds(94, 310, 173, 25);
		frame.getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCep.setBounds(294, 313, 46, 20);
		frame.getContentPane().add(lblCep);

		txtCep = new JPasswordField();
		txtCep.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtCep.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCep.setBounds(367, 310, 146, 25);
		frame.getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBairro.setBounds(10, 353, 46, 20);
		frame.getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		txtBairro.setBounds(94, 350, 173, 25);
		frame.getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(360, 410, 150, 40);
		OuvinteSalvar ouvinteSalvar=new OuvinteSalvar(this);
		btnSalvar.addActionListener(ouvinteSalvar);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLimpar.setBounds(190, 410, 150, 40);
		frame.getContentPane().add(btnLimpar);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCnpj.setBounds(294, 233, 46, 20);
		frame.getContentPane().add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCnpj.setBounds(367, 230, 146, 25);
		frame.getContentPane().add(txtCnpj);
		txtCnpj.setColumns(10);
		
		frame.setVisible(true);

	}
	

	public ArrayList<String> returnValores(){
		ArrayList<String> array=new ArrayList<>();
		array.add(textFielNome.getText());
		array.add(formattedTextFieldTelefoneCelular.getText());
		String nivel=niveis[comboBoxNivies.getSelectedIndex()];
		array.add(nivel);
		array.add(frmtdtxtfldTelefonefixo.getText());
		array.add(txtLinkdosite.getText());
		array.add(txtEmail.getText());
		array.add(txtSenha.getText());
		array.add(txtCnpj.getText());
		
		array.add(txtRua.getText());
		array.add(txtNumero.getText());
		array.add(txtCidade.getText());
		array.add(txtCep.getText());
		array.add(txtBairro.getText());
		
		return array;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}