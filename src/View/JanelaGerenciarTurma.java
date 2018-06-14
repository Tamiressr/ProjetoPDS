package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import OuvintesEscolas.OuvinteListaEscolas;
import OuvintesTurma.OuvinteAtualizarTurma;
import OuvintesTurma.OuvinteCadastrarTurma;
import OuvintesTurma.OuvinteEditaTurma;
import OuvintesTurma.OuvinteExcluirTurma;
import OuvintesTurma.OuvinteListaTurma;
import OuvintesTurma.OuvinteSalvaTurma;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controllers.TurmaController;
import Facade.Facade;
import Model.Escola;
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
	private static int id;
	private JTextField textField_TotalDeVagas;
	private JTextField textField_VagasDisponiveis;
	private JPanel panelCadastrar;
	private JButton btnCadastrarTurma;
	private JButton btnListaTurma;
	private JTable table;
	private DefaultTableModel modelo;
	private String[] serie = { "1° ano", "2° ano", "3° ano", "4° ano", "5° ano", "6° ano", "7° ano", "8° ano",
			"9° ano" };
	private JComboBox comboBox;
	private ButtonGroup grupo;
	private JRadioButton radioButtonManha;
	private JRadioButton radioButtonTarde;
	private JRadioButton radioButtonNoite;
	private JRadioButton radioButtonIntegral;
	private JScrollPane painelTabela = new JScrollPane();
	private List<Turma> list;
	private int linhaSelecionada;
	private boolean retiraPainel;
	private boolean retiraTabela;
	private JButton buttonSalvar;
	private JTextField txtVagasDisponivel;
	private JPanel painelEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaGerenciarTurma window = new JanelaGerenciarTurma(id);
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
		frame.setVisible(true);

		listaTurma("primeiro");

		btnCadastrarTurma = new JButton("Cadastrar Turma");
		btnCadastrarTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrarTurma.setBounds(377, 25, 140, 40);
		OuvinteCadastrarTurma ouvinteCadastrarTurma = new OuvinteCadastrarTurma(this, id);
		btnCadastrarTurma.addActionListener(ouvinteCadastrarTurma);
		frame.getContentPane().add(btnCadastrarTurma);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(326, 428, 92, 40);
		OuvinteExcluirTurma ouvinteExcluirTurma = new OuvinteExcluirTurma(this, id);
		btnExcluir.addActionListener(ouvinteExcluirTurma);
		frame.getContentPane().add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 22, 69, 40);
		OuvinteJanelaPerfil ouvinteJanelaPerfil = new OuvinteJanelaPerfil(frame, id);
		btnVoltar.addActionListener(ouvinteJanelaPerfil);
		frame.getContentPane().add(btnVoltar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(428, 428, 92, 40);
		OuvinteEditaTurma ouvinteEditaTurma = new OuvinteEditaTurma(id, this);
		btnEditar.addActionListener(ouvinteEditaTurma);
		frame.getContentPane().add(btnEditar);

		btnListaTurma = new JButton("Lista Turmas");
		btnListaTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListaTurma.setBounds(247, 25, 120, 40);
		OuvinteListaTurma ouvinteListaTurma = new OuvinteListaTurma(this, id);
		btnListaTurma.addActionListener(ouvinteListaTurma);
		frame.getContentPane().add(btnListaTurma);

	}

	public Turma linhaSelecionada() {
		linhaSelecionada = table.getSelectedRow();
		Turma turma = list.get(linhaSelecionada);

		return turma;

	}

	public void removerLinha() {
		modelo.removeRow(linhaSelecionada);
		frame.repaint();
	}

	public void addPainelCadastrar() {
		panelCadastrar = new JPanel();
		panelCadastrar.setBackground(new Color(255, 153, 51));
		panelCadastrar.setBounds(39, 150, 478, 210);
		frame.getContentPane().add(panelCadastrar);
		panelCadastrar.setLayout(null);

		retiraPainel = true;

		JLabel label = new JLabel("S\u00E9rie");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(22, 23, 48, 19);
		panelCadastrar.add(label);

		comboBox = new JComboBox(serie);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(66, 22, 65, 20);
		panelCadastrar.add(comboBox);

		grupo = new ButtonGroup();

		radioButtonManha = new JRadioButton("Manh\u00E3");
		radioButtonManha.setBounds(22, 62, 109, 23);
		grupo.add(radioButtonManha);
		panelCadastrar.add(radioButtonManha);

		radioButtonTarde = new JRadioButton("Tarde");
		radioButtonTarde.setBounds(22, 92, 109, 23);
		grupo.add(radioButtonTarde);
		panelCadastrar.add(radioButtonTarde);

		radioButtonNoite = new JRadioButton("Noite");
		radioButtonNoite.setBounds(22, 122, 109, 23);
		grupo.add(radioButtonNoite);
		panelCadastrar.add(radioButtonNoite);

		radioButtonIntegral = new JRadioButton("Integral");
		radioButtonIntegral.setBounds(22, 152, 109, 23);
		grupo.add(radioButtonIntegral);
		panelCadastrar.add(radioButtonIntegral);

		textField_TotalDeVagas = new JTextField();
		textField_TotalDeVagas.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_TotalDeVagas.setColumns(10);
		textField_TotalDeVagas.setBounds(185, 49, 118, 23);
		panelCadastrar.add(textField_TotalDeVagas);

		JLabel label_1 = new JLabel("Quantidade Disponivel de Vagas na Turma");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(175, 96, 280, 14);
		panelCadastrar.add(label_1);

		textField_VagasDisponiveis = new JTextField();
		textField_VagasDisponiveis.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_VagasDisponiveis.setColumns(10);
		textField_VagasDisponiveis.setBounds(185, 122, 118, 23);
		panelCadastrar.add(textField_VagasDisponiveis);

		JLabel label_2 = new JLabel("Quantidade Total de Vagas na Turma");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		label_2.setBounds(175, 23, 280, 14);
		panelCadastrar.add(label_2);

		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		buttonSalvar.setBounds(366, 162, 89, 23);
		OuvinteSalvaTurma ouvinteSalvaTurma = new OuvinteSalvaTurma(id, this);
		buttonSalvar.addActionListener(ouvinteSalvaTurma);
		panelCadastrar.add(buttonSalvar);

	}

	public ArrayList<String> retornaValoresTurma() {
		if (textField_TotalDeVagas.equals("") || textField_VagasDisponiveis.equals("") || qualButton().equals("")
				|| comboBox.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Campos Vazios");
			return null;
		} else {
			int disponivel = Integer.parseInt(textField_VagasDisponiveis.getText());
			int vagas = Integer.parseInt(textField_TotalDeVagas.getText());

			if (vagas >= disponivel) {
				ArrayList<String> array = new ArrayList<>();
				array.add(textField_VagasDisponiveis.getText());
				array.add(textField_TotalDeVagas.getText());
				array.add(serie[comboBox.getSelectedIndex()]);
				array.add(qualButton());

				return array;
			} else {
				JOptionPane.showMessageDialog(null, "Número de Vagas Disponivel deve ser menor que o Total De Vagas");
				return null;
			}
		}
	}

	public int retornaVagasDisponiveis() {
		int disponivel = 0;
		if (txtVagasDisponivel.equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Obrigatório em Branco");
		} else {
			disponivel = Integer.parseInt(txtVagasDisponivel.getText());
		}
		return disponivel;
	}

	private int serieSelecionada(String nome) {
		String a = nome.charAt(2) + "";
		int b = Integer.parseInt(a);
		return b - 1;
	}

	private JRadioButton selecionaBotao(String turno) {
		if (turno.equals("Manhã")) {
			return radioButtonManha;
		} else if (turno.equals("Tarde")) {
			return radioButtonTarde;
		} else if (turno.equals("Noite")) {
			return radioButtonNoite;
		} else if (turno.equals("Integral")) {
			return radioButtonIntegral;
		}
		return null;
	}

	private String qualButton() {
		if (radioButtonManha.isSelected()) {
			return "Manha";
		} else if (radioButtonTarde.isSelected()) {
			return "Tarde";
		} else if (radioButtonNoite.isSelected()) {
			return "Noite";
		} else if (radioButtonIntegral.isSelected()) {
			return "Integral";
		}
		return "";
	}

	public void listaTurma(String nome) {
		Escola o = Facade.getFacade().procurarEscolaPorID(id);
		table = new JTable();
		table.setBounds(39, 200, 478, 194);
		retiraPainel = false;
		retiraTabela = true;
		
		frame.getContentPane().setLayout(null);
		modelo = new DefaultTableModel();
		
		modelo.addColumn("Série");
		modelo.addColumn("Turno");
		modelo.addColumn("Total de Vagas");
		modelo.addColumn("Vagas Disponiveis");
		
		if (nome.equals("primeiro")) {
			list = o.getTurmas();

		} else {
			list=null;
			list = TurmaController.getTurmaController().listar();
			
			for (Turma t : list) {
				if (t.getEscola().getId() != o.getId()) {
					list.remove(t);
				}
			}
		}
		Object[] array = new Object[4];
		for (Turma e : list) {
			array[0] = e.getNome();
			array[1] = e.getTurno();
			array[2] = e.getNumeroDeVagas();
			array[3] = e.getNumeroDeVagasDiponiveis();
			modelo.addRow(array);
		}

		table = new JTable(modelo);

		painelTabela = new JScrollPane(table);
		painelTabela.setBounds(38, 88, 478, 326);
		frame.getContentPane().add(painelTabela);

	}

	public void addPainelEdita(Turma turma) {
		painelEditar = new JPanel();
		painelEditar.setBackground(new Color(255, 153, 51));
		painelEditar.setSize(478, 149);
		painelEditar.setLocation(39, 150);
		frame.getContentPane().add(painelEditar);
		painelEditar.setLayout(null);

		retiraPainel = true;
		retiraTabela = false;

		JLabel lblNome = new JLabel("Nome: " + turma.getNome());
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(25, 23, 180, 16);
		painelEditar.add(lblNome);

		JLabel lblTotaldevagas = new JLabel("Total de Vagas: " + turma.getNumeroDeVagas());
		lblTotaldevagas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotaldevagas.setBounds(25, 105, 180, 16);
		painelEditar.add(lblTotaldevagas);

		JLabel lblTurno = new JLabel("Turno: " + turma.getTurno());
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTurno.setBounds(25, 64, 130, 16);
		painelEditar.add(lblTurno);

		JLabel lblNumeroDeVagas = new JLabel("Numero de Vagas Dispon\u00EDvel");
		lblNumeroDeVagas.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumeroDeVagas.setBounds(194, 23, 196, 16);
		painelEditar.add(lblNumeroDeVagas);

		txtVagasDisponivel = new JTextField();
		txtVagasDisponivel.setText(turma.getNumeroDeVagasDiponiveis() + "");
		txtVagasDisponivel.setFont(new Font("Arial", Font.PLAIN, 14));
		txtVagasDisponivel.setBounds(204, 50, 135, 20);
		painelEditar.add(txtVagasDisponivel);
		txtVagasDisponivel.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSalvar.setBounds(365, 92, 103, 34);
		painelEditar.add(btnSalvar);

		OuvinteAtualizarTurma ouvinteAtualizarTurma = new OuvinteAtualizarTurma(this, turma);
		btnSalvar.addActionListener(ouvinteAtualizarTurma);
	}

	public JButton getBtnCadastrarTurma() {
		return btnCadastrarTurma;
	}

	public void setBtnCadastrarTurma(JButton btnCadastrarTurma) {
		this.btnCadastrarTurma = btnCadastrarTurma;
	}

	public boolean isRetiraTabela() {
		return retiraTabela;
	}

	public void setRetiraTabela(boolean retiraTabela) {
		this.retiraTabela = retiraTabela;
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

	public JPanel getPanel() {
		return panelCadastrar;
	}

	public void setPanel(JPanel panel) {
		this.panelCadastrar = panel;
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

	public JScrollPane getPainelTabela() {
		return painelTabela;
	}

	public void setPainelTabela(JScrollPane painelTabela) {
		this.painelTabela = painelTabela;
	}

	public boolean isRetiraPainel() {
		return retiraPainel;
	}

	public void setRetiraPainel(boolean retiraPainel) {
		this.retiraPainel = retiraPainel;
	}

	public boolean isRetirarTabela() {
		return retiraTabela;
	}

	public void setRetirarTabela(boolean retirarTabela) {
		this.retiraTabela = retirarTabela;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public void setButtonSalvar(JButton buttonSalvar) {
		this.buttonSalvar = buttonSalvar;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		JanelaGerenciarTurma.id = id;
	}

	public JTextField getTextField_TotalDeVagas() {
		return textField_TotalDeVagas;
	}

	public void setTextField_TotalDeVagas(JTextField textField_TotalDeVagas) {
		this.textField_TotalDeVagas = textField_TotalDeVagas;
	}

	public JTextField getTextField_VagasDisponiveis() {
		return textField_VagasDisponiveis;
	}

	public void setTextField_VagasDisponiveis(JTextField textField_VagasDisponiveis) {
		this.textField_VagasDisponiveis = textField_VagasDisponiveis;
	}

	public String[] getSerie() {
		return serie;
	}

	public void setSerie(String[] serie) {
		this.serie = serie;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}

	public JRadioButton getRadioButtonManha() {
		return radioButtonManha;
	}

	public void setRadioButtonManha(JRadioButton radioButtonManha) {
		this.radioButtonManha = radioButtonManha;
	}

	public JRadioButton getRadioButtonTarde() {
		return radioButtonTarde;
	}

	public void setRadioButtonTarde(JRadioButton radioButtonTarde) {
		this.radioButtonTarde = radioButtonTarde;
	}

	public JRadioButton getRadioButtonNoite() {
		return radioButtonNoite;
	}

	public void setRadioButtonNoite(JRadioButton radioButtonNoite) {
		this.radioButtonNoite = radioButtonNoite;
	}

	public JRadioButton getRadioButtonIntegral() {
		return radioButtonIntegral;
	}

	public void setRadioButtonIntegral(JRadioButton radioButtonIntegral) {
		this.radioButtonIntegral = radioButtonIntegral;
	}

	public List<Turma> getList() {
		return list;
	}

	public void setList(List<Turma> list) {
		this.list = list;
	}

	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

	public JTextField getTxtVagasDisponivel() {
		return txtVagasDisponivel;
	}

	public void setTxtVagasDisponivel(JTextField txtVagasDisponivel) {
		this.txtVagasDisponivel = txtVagasDisponivel;
	}

	public JPanel getPainel() {
		return painelEditar;
	}

	public void setPainel(JPanel painel) {
		this.painelEditar = painel;
	}

}
