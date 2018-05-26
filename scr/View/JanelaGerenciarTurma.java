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

import Ouvintes.OuvinteCadastrarTurma;
import Ouvintes.OuvinteEditaTurma;
import Ouvintes.OuvinteExcluirTurma;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteJanelaPerfil;
import Ouvintes.OuvinteListaEscolas;
import Ouvintes.OuvinteListaTurma;
import Ouvintes.OuvinteSalvaTurma;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
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
	private static int id;
	private JTextField textField_TotalDeVagas;
	private JTextField textField_VagasDisponiveis;
	private JPanel panel;
	private JButton btnCadastrarTurma;
	private JButton btnListaTurma;
	private JTable table;
	private DefaultTableModel modelo;
	private String[] serie= {"  1º","  2º","  3º","  4º","  5º","  6º","  7º","  8º","  9º"};
	private JComboBox comboBox;
	private ButtonGroup grupo;
	private JRadioButton radioButtonManha;
	private JRadioButton radioButtonTarde; 
	private JRadioButton radioButtonNoite;
	private JRadioButton radioButtonIntegral;
	private JScrollPane painelTabela=new JScrollPane();
	private List<Turma> list;
	private int linhaSelecionada;
	private boolean retiraPainel;
	private boolean retiraTabela;
	
	
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
		btnCadastrarTurma.setBounds(275, 22, 140, 40);
		OuvinteCadastrarTurma ouvinteCadastrarTurma=new OuvinteCadastrarTurma(this, id);
		btnCadastrarTurma.addActionListener(ouvinteCadastrarTurma);
		frame.getContentPane().add(btnCadastrarTurma);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluir.setBounds(425, 22, 92, 40);
		OuvinteExcluirTurma ouvinteExcluirTurma=new OuvinteExcluirTurma(this, id);
		btnExcluir.addActionListener(ouvinteExcluirTurma);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnProcurar.setBounds(425, 82, 92, 40);
		frame.getContentPane().add(btnProcurar);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(204, 90, 211, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnIntegral = new JRadioButton("Integral");
		rdbtnIntegral.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnIntegral.setBounds(39, 156, 103, 25);
		frame.getContentPane().add(rdbtnIntegral);

		JRadioButton rdbtnManh = new JRadioButton("Manh\u00E3");
		rdbtnManh.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnManh.setBounds(144, 156, 103, 25);
		frame.getContentPane().add(rdbtnManh);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnTarde.setBounds(249, 156, 89, 25);
		frame.getContentPane().add(rdbtnTarde);
		
		JRadioButton rdbtnNoite = new JRadioButton("Noite");
		rdbtnNoite.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbtnNoite.setBounds(342, 156, 75, 25);
		frame.getContentPane().add(rdbtnNoite);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.setBounds(10, 22, 69, 40);
		OuvinteJanelaPerfil ouvinteJanelaPerfil=new OuvinteJanelaPerfil(frame, id);
		btnVoltar.addActionListener(ouvinteJanelaPerfil);
		frame.getContentPane().add(btnVoltar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(425, 141, 92, 40);
		OuvinteEditaTurma ouvinteEditaTurma=new OuvinteEditaTurma(id, this);
		btnEditar.addActionListener(ouvinteEditaTurma);
		frame.getContentPane().add(btnEditar);
		
		btnListaTurma=new JButton("Lista Turmas");
		btnListaTurma.setFont(new Font("Arial", Font.PLAIN, 14));
		btnListaTurma.setBounds(145, 22, 120, 40);
		OuvinteListaTurma ouvinteListaTurma=new OuvinteListaTurma(this, id);
		btnListaTurma.addActionListener(ouvinteListaTurma);
		frame.getContentPane().add(btnListaTurma);
	
		
	}
	public Turma linhaSelecionada() {
		linhaSelecionada=table.getSelectedRow();
		Turma turma=list.get(linhaSelecionada);
		
		return turma;
	}
	public void removerLinha() {
		modelo.removeRow(linhaSelecionada);
		frame.repaint();
	}
	
	public void addPainel() {
		panel = new JPanel();
		panel.setBackground(new Color(255,127,39));
		panel.setBounds(39, 203, 478, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		retiraPainel=true;
		
		JLabel label = new JLabel("S\u00E9rie");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(22, 23, 48, 19);
		panel.add(label);
		
		comboBox= new JComboBox(serie);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(66, 22, 65, 20);
		panel.add(comboBox);
		
		grupo=new ButtonGroup();
		
		radioButtonManha = new JRadioButton("Manh\u00E3");
		radioButtonManha.setBounds(22, 52, 109, 23);
		grupo.add(radioButtonManha);
		panel.add(radioButtonManha);
		
		radioButtonTarde= new JRadioButton("Tarde");
		radioButtonTarde.setBounds(22, 82, 109, 23);
		grupo.add(radioButtonTarde);
		panel.add(radioButtonTarde);
		
		radioButtonNoite= new JRadioButton("Noite");
		radioButtonNoite.setBounds(22, 112, 109, 23);
		grupo.add(radioButtonNoite);
		panel.add(radioButtonNoite);
		
		radioButtonIntegral = new JRadioButton("Integral");
		radioButtonIntegral.setBounds(22, 142, 109, 23);
		grupo.add(radioButtonIntegral);
		panel.add(radioButtonIntegral);
		
		
		textField_TotalDeVagas = new JTextField();
		textField_TotalDeVagas.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_TotalDeVagas.setColumns(10);
		textField_TotalDeVagas.setBounds(185, 108, 118, 23);
		panel.add(textField_TotalDeVagas);
		
		JLabel label_1 = new JLabel("Quantidade Disponivel de Vagas na Turma");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_1.setBounds(175, 82, 280, 14);
		panel.add(label_1);
		
		textField_VagasDisponiveis = new JTextField();
		textField_VagasDisponiveis.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_VagasDisponiveis.setColumns(10);
		textField_VagasDisponiveis.setBounds(185, 49, 118, 23);
		panel.add(textField_VagasDisponiveis);
		
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
	
	public ArrayList<String> retornaValoresTurma(){
		int disponivel=Integer.parseInt(textField_VagasDisponiveis.getText());
		int vagas=Integer.parseInt(textField_TotalDeVagas.getText());
		
		if(vagas<=disponivel) {
			ArrayList<String> array=new ArrayList<>();
			array.add(textField_VagasDisponiveis.getText());
			array.add(textField_TotalDeVagas.getText());
			array.add(serie[comboBox.getSelectedIndex()]);
			array.add(qualButton());

			return array;
		}else {
			JOptionPane.showMessageDialog(null,"Número de Vagas Disponivel deve ser menor que o Total De Vagas");
			return null;
		}	
	}
	public void adicionarValores(Turma turma) {
		
		
	}
	
	private String qualButton() {
		if(radioButtonManha.isSelected()) {
			return "Manha";
		}else if(radioButtonTarde.isSelected()) {
			return "Tarde";
		}else if(radioButtonNoite.isSelected()) {
			return "Noite";
		}else if(radioButtonIntegral.isSelected()) {
			return "Integral";
		}
		return "";
	}
	
	public void listaTurma() {
	
		table = new JTable();
		table.setBounds(39, 250,478, 194);
		retiraPainel=false;
		retiraTabela=true;
		
		frame.getContentPane().setLayout(null);
		modelo = new DefaultTableModel();

		modelo.addColumn("Escolas");

//		List<Escola> list=Facade.getFacade().listar();
		Escola o=Facade.getFacade().procurarEscolaPorID(id);
		list=o.getTurmas();
				
		for (Turma e : list) {
			Object[] array = new Object[1];
			array[0] = e.toString();
			modelo.addRow(array);
		}

		table = new JTable(modelo);

		painelTabela = new JScrollPane(table);
		painelTabela.setBounds(39, 203, 478, 194);
		frame.getContentPane().add(painelTabela);
		
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
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
	
}

