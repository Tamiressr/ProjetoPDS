package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Facade.Facade;
import Model.Documentacao;
import Model.Escola;
import Model.Turma;
import Ouvintes.OuvinteJanelaPerfil;
import OuvintesDocumentos.OuvinteExcluirDocumento;
import OuvintesDocumentos.OuvinteSalvaDocumento;
import OuvintesDocumentos.OuvinteSalvaPrimeiroDocumento;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class JanelaDocumentacao {

	private JFrame frame;
	private JTextField txtDocumento;
	private JTable table;
	private DefaultTableModel modelo;
	private int id;
	private List<Documentacao> list;
	private int linhaSelecionada;
	
	private JCheckBox chckbxCpf;
	private JCheckBox chckbxRg;
	private JCheckBox chckbxHistorico;
	private JCheckBox chckbxDeclaracao;
	private JCheckBox chckbxCertidao;
	private JCheckBox chckbxSus;
	private JCheckBox chckbxComprovanteDeRe;
	private JCheckBox chckbxFotox;
	private JCheckBox chckbxBolsaFamilia;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDocumentacao window = new JanelaDocumentacao(0);
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
	public JanelaDocumentacao(int id) {
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
		frame.setTitle("Acompanhamento de Vagas");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 550, 550);
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(405, 27, 89, 40);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new OuvinteJanelaPerfil(frame, id));

		listaDocumentacao();
		addPainel();
		frame.setVisible(true);
	}

	public void addPainel() {
		Escola escola = Facade.getFacade().procurarEscolaPorID(id);
		JPanel panel = new JPanel();
		panel.setBounds(46, 78, 448, 106);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		if (escola.getDocumentacao().size() == 0) {
			chckbxCpf = new JCheckBox("CPF");
			chckbxCpf.setBounds(6, 7, 89, 23);
			panel.add(chckbxCpf);

			chckbxRg = new JCheckBox("RG");
			chckbxRg.setBounds(6, 33, 89, 23);
			panel.add(chckbxRg);

			chckbxHistorico = new JCheckBox("Historico");
			chckbxHistorico.setBounds(6, 59, 89, 23);
			panel.add(chckbxHistorico);

			chckbxDeclaracao = new JCheckBox("Declara\u00E7\u00E3o");
			chckbxDeclaracao.setBounds(97, 7, 97, 23);
			panel.add(chckbxDeclaracao);

			chckbxCertidao = new JCheckBox("Certid\u00E3o de Nascimento");
			chckbxCertidao.setBounds(97, 33, 153, 23);
			panel.add(chckbxCertidao);

			chckbxSus = new JCheckBox("Cart\u00E3o do SUS");
			chckbxSus.setBounds(97, 59, 97, 23);
			panel.add(chckbxSus);

			JButton btnSalvar_1 = new JButton("Salvar");
			btnSalvar_1.setBounds(349, 59, 89, 23);
			panel.add(btnSalvar_1);
			OuvinteSalvaPrimeiroDocumento ouvinteSalvaPrimeiroDocumento=new OuvinteSalvaPrimeiroDocumento(this);
			btnSalvar_1.addActionListener(ouvinteSalvaPrimeiroDocumento);

			chckbxComprovanteDeRe = new JCheckBox("Comprovante de Resid\u00EAncia");
			chckbxComprovanteDeRe.setBounds(252, 7, 178, 23);
			panel.add(chckbxComprovanteDeRe);

			chckbxFotox = new JCheckBox("Foto 3x4");
			chckbxFotox.setBounds(252, 59, 97, 23);
			panel.add(chckbxFotox);

			chckbxBolsaFamilia = new JCheckBox("Cart\u00E3o do Bolsa Fam\u00EDlia");
			chckbxBolsaFamilia.setBounds(252, 33, 178, 23);
			panel.add(chckbxBolsaFamilia);

		} else {
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
			btnSalvar.setBounds(349, 54, 89, 40);
			panel.add(btnSalvar);
			
			OuvinteSalvaDocumento ouvinteSalvaDocumento=new OuvinteSalvaDocumento(this);
			btnSalvar.addActionListener(ouvinteSalvaDocumento);

			JLabel lblInformacoes = new JLabel("Cadastre um documento por vez");
			lblInformacoes.setBounds(22, 30, 301, 14);
			panel.add(lblInformacoes);

			txtDocumento = new JTextField();
			txtDocumento.setHorizontalAlignment(SwingConstants.LEFT);
			txtDocumento.setBounds(22, 55, 301, 40);
			panel.add(txtDocumento);
			txtDocumento.setColumns(10);
			
			JLabel lblCadastrarDocumentao = new JLabel("Cadastrar Documento");
			lblCadastrarDocumentao.setHorizontalAlignment(SwingConstants.CENTER);
			lblCadastrarDocumentao.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCadastrarDocumentao.setBounds(122, 5, 201, 14);
			panel.add(lblCadastrarDocumentao);

			
			JLabel lblDocumentosCadastrados = new JLabel("Documentos Cadastrados");
			lblDocumentosCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
			lblDocumentosCadastrados.setFont(new Font("Arial", Font.PLAIN, 14));
			lblDocumentosCadastrados.setBounds(159, 210, 210, 17);
			frame.getContentPane().add(lblDocumentosCadastrados);
			
			JButton btnExcluirDocumento = new JButton("Excluir Documento");
			btnExcluirDocumento.setFont(new Font("Arial", Font.PLAIN, 14));
			btnExcluirDocumento.setBounds(345, 446, 149, 40);
			frame.getContentPane().add(btnExcluirDocumento);
			
			OuvinteExcluirDocumento ouvinteExcluirDocumento=new OuvinteExcluirDocumento(this);
			btnExcluirDocumento.addActionListener(ouvinteExcluirDocumento);
		}

	}

	public void listaDocumentacao() {
		table = new JTable();
		table.setBounds(39, 200, 478, 194);

		frame.getContentPane().setLayout(null);
		modelo = new DefaultTableModel();

		modelo.addColumn("Documento");

		Escola o = Facade.getFacade().procurarEscolaPorID(id);
		list = o.getDocumentacao();

		for (Documentacao e : list) {
			Object[] array = new Object[1];
			array[0] = e.getNome();
			modelo.addRow(array);
		}

		table = new JTable(modelo);

		JScrollPane painelTabela = new JScrollPane(table);
		painelTabela.setBounds(46, 227, 448, 196);
		frame.getContentPane().add(painelTabela);

		JLabel lblDocumentao = new JLabel("Documenta\u00E7\u00E3o");
		lblDocumentao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocumentao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDocumentao.setBounds(133, 11, 217, 40);
		frame.getContentPane().add(lblDocumentao);

	}
	public void removerLinha() {
		modelo.removeRow(linhaSelecionada);
		frame.repaint();
		
	}
	
	public Documentacao linhaSelecionada() {
		linhaSelecionada=table.getSelectedRow();
		return list.get(linhaSelecionada);
		
	}
	
	public ArrayList<String> retornaCheckbox(){
		ArrayList<String> array=new ArrayList<>();
		if(chckbxCpf.isSelected()) {
			array.add("CPF");
		}if(chckbxRg.isSelected()) {
			array.add("RG");
		}if(chckbxHistorico.isSelected()) {
			array.add("Historico");
		}if(chckbxDeclaracao.isSelected()) {
			array.add("Declaração");
		}if(chckbxCertidao.isSelected()) {
			array.add("Certidão de Nascimento");
		}if(chckbxSus.isSelected()) {
			array.add("Cartão do SUS");
		}if(chckbxComprovanteDeRe.isSelected()) {
			array.add("Comprovante de Residência");
		}if(chckbxFotox.isSelected()) {
			array.add("Foto 3x4");
		}if(chckbxBolsaFamilia.isSelected()) {
			array.add("Cartão do Bolsa Família");
		}
		return array;	
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(JTextField txtDocumento) {
		this.txtDocumento = txtDocumento;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JCheckBox getChckbxCpf() {
		return chckbxCpf;
	}

	public void setChckbxCpf(JCheckBox chckbxCpf) {
		this.chckbxCpf = chckbxCpf;
	}

	public JCheckBox getChckbxRg() {
		return chckbxRg;
	}

	public void setChckbxRg(JCheckBox chckbxRg) {
		this.chckbxRg = chckbxRg;
	}

	public JCheckBox getChckbxHistorico() {
		return chckbxHistorico;
	}

	public void setChckbxHistorico(JCheckBox chckbxHistorico) {
		this.chckbxHistorico = chckbxHistorico;
	}

	public JCheckBox getChckbxDeclaracao() {
		return chckbxDeclaracao;
	}

	public void setChckbxDeclaracao(JCheckBox chckbxDeclaracao) {
		this.chckbxDeclaracao = chckbxDeclaracao;
	}

	public JCheckBox getChckbxCertidao() {
		return chckbxCertidao;
	}

	public void setChckbxCertidao(JCheckBox chckbxCertidao) {
		this.chckbxCertidao = chckbxCertidao;
	}

	public JCheckBox getChckbxSus() {
		return chckbxSus;
	}

	public void setChckbxSus(JCheckBox chckbxSus) {
		this.chckbxSus = chckbxSus;
	}

	public JCheckBox getChckbxComprovanteDeRe() {
		return chckbxComprovanteDeRe;
	}

	public void setChckbxComprovanteDeRe(JCheckBox chckbxComprovanteDeRe) {
		this.chckbxComprovanteDeRe = chckbxComprovanteDeRe;
	}

	public JCheckBox getChckbxFotox() {
		return chckbxFotox;
	}

	public void setChckbxFotox(JCheckBox chckbxFotox) {
		this.chckbxFotox = chckbxFotox;
	}

	public JCheckBox getChckbxBolsaFamilia() {
		return chckbxBolsaFamilia;
	}

	public void setChckbxBolsaFamilia(JCheckBox chckbxBolsaFamilia) {
		this.chckbxBolsaFamilia = chckbxBolsaFamilia;
	}

	public List<Documentacao> getList() {
		return list;
	}

	public void setList(List<Documentacao> list) {
		this.list = list;
	}

	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}
	
	
}

