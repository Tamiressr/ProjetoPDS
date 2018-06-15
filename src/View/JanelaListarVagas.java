package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;

import Ouvintes.OuvinteBuscar;
import Ouvintes.OuvinteJanelaCadastro;
import Ouvintes.OuvinteJanelaLogin;
import Ouvintes.OuvinteMaisInformacoes;
import Ouvintes.OuvinteVoltarInicio;
import OuvintesEscolas.OuvinteListaEscolas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import Controllers.EscolaController;
import Controllers.TurmaController;
import Facade.Facade;
import Model.Escola;
import Model.Turma;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JanelaListarVagas {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelo;
	private List<Turma> list;
	private ArrayList<String> txt = new ArrayList<>();
	private JComboBox escolaComboBox = null;
	private JComboBox TurmacomboBox = null;
	private JComboBox TurnocomboBox = null;
	private String[] turnos = { "", "Manhã", "Tarde", "Integral", "Noite" };
	private List<Escola> escolas;
	private String[] arrayturmas = { "", "1° ano", "2° ano", "3° ano", "4° ano", "5° ano", "6° ano", "7° ano", "8° ano",
			"9° ano" };
	private String[] escola;

	public ArrayList<String> getTxt() {
		return txt;
	}

	public void setTxt(ArrayList<String> txt) {
		this.txt = txt;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());

					JanelaListarVagas window = new JanelaListarVagas("primeiro", null);
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
	public JanelaListarVagas(String nome, ArrayList<String> txt) {
		initialize(nome, txt);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nome, ArrayList<String> txt) {
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

		JLabel lblListagemDeVagas = new JLabel("Listagem de Vagas");
		lblListagemDeVagas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListagemDeVagas.setBounds(122, 11, 335, 40);
		lblListagemDeVagas.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		frame.getContentPane().add(lblListagemDeVagas);

		JButton btnMaisInformaes = new JButton("Mais Informa\u00E7\u00F5es");
		btnMaisInformaes.setFont(new Font("Arial", Font.PLAIN, 14));
		btnMaisInformaes.setBounds(396, 446, 138, 40);
		frame.getContentPane().add(btnMaisInformaes);

		OuvinteMaisInformacoes ouvinteMaisInformacoes = new OuvinteMaisInformacoes(this);
		btnMaisInformaes.addActionListener(ouvinteMaisInformacoes);

		addTabela(nome, txt);

		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setFont(new Font("Arial", Font.BOLD, 14));
		lblEscola.setBounds(10, 64, 77, 14);
		frame.getContentPane().add(lblEscola);

		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("Arial", Font.BOLD, 14));
		lblTurma.setBounds(10, 89, 60, 14);
		frame.getContentPane().add(lblTurma);

		escolas = EscolaController.getEscolaController().listar();

		escola=new String[escolas.size()+1];
		escola[0]="";
		int contador=1;
		for (Escola e : escolas) {
			escola[contador]=e.getNome();
			contador++;
		}
		escolaComboBox=new JComboBox<>(escola);
		escolaComboBox.setToolTipText("Selecione o nome da escola desejada");
		escolaComboBox.setBounds(70, 64, 301, 20);
		frame.getContentPane().add(escolaComboBox);
		
		TurmacomboBox = new JComboBox(arrayturmas);
		TurmacomboBox.setBackground(Color.WHITE);

		TurmacomboBox.setBounds(70, 89, 129, 20);
		frame.getContentPane().add(TurmacomboBox);

		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Arial", Font.BOLD, 14));
		lblTurno.setBounds(212, 89, 46, 14);
		frame.getContentPane().add(lblTurno);
		TurnocomboBox = new JComboBox(turnos);
		TurnocomboBox.setBounds(268, 87, 103, 20);
		frame.getContentPane().add(TurnocomboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 12));
		btnBuscar.setBounds(395, 64, 109, 42);
		OuvinteBuscar ouvinteBuscar = new OuvinteBuscar(this);
		btnBuscar.addActionListener(ouvinteBuscar);
		frame.getContentPane().add(btnBuscar);
		frame.setVisible(true);

		frame.getContentPane().add(btnBuscar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new OuvinteVoltarInicio(frame));

		frame.setVisible(true);

	}

	public void valor() {
		txt.add(escola[escolaComboBox.getSelectedIndex()]);
		txt.add(arrayturmas[TurmacomboBox.getSelectedIndex()]);
		txt.add(turnos[TurnocomboBox.getSelectedIndex()]);
	}

	public Turma linhaSelecionada() {
		int linha = table.getSelectedRow();
		Turma turma = list.get(linha);

		return turma;
	}

	public void addTabela(String nome, ArrayList<String> txt) {
		modelo = new DefaultTableModel();

		list = TurmaController.getTurmaController().listar();
		if (nome.equals("primeiro") || txt.get(0).isEmpty() && txt.get(1).isEmpty() && txt.get(2).isEmpty()) {

		} else {
			ArrayList<Turma> turmas = new ArrayList<>();
			for (Turma t : list) {
				if (txt.get(0).equals("") == false && txt.get(1).isEmpty() == false && txt.get(2).isEmpty() == false) {
					if (txt.get(0).equalsIgnoreCase(t.getEscola().getNome())) {
						if (txt.get(1).equalsIgnoreCase(t.getNome())) {
							if (txt.get(2).equalsIgnoreCase(t.getTurno())) {
								turmas.add(t);
							}
						}
					}
				} else if (txt.get(0).equals("") == false) {
					if (txt.get(0).equalsIgnoreCase(t.getEscola().getNome())) {
						turmas.add(t);

					}
				} else if (txt.get(0).equals("") == false && txt.get(1).isEmpty() == false) {
					if (txt.get(0).equalsIgnoreCase(t.getEscola().getNome())) {
						if (txt.get(1).equalsIgnoreCase(t.getNome())) {
							turmas.add(t);
						}
					}
				} else if (txt.get(0).equals("") == false && txt.get(2).isEmpty() == false) {
					if (txt.get(0).equalsIgnoreCase(t.getEscola().getNome())) {
						if (txt.get(2).equalsIgnoreCase(t.getTurno())) {
							turmas.add(t);
						}
					}
				} else if (txt.get(1).isEmpty() == false) {
					if (txt.get(1).equalsIgnoreCase(t.getNome())) {
						turmas.add(t);
					}
				} else if (txt.get(1).isEmpty() == false && txt.get(2).isEmpty() == false) {
					if (txt.get(1).equalsIgnoreCase(t.getNome())) {
						if (txt.get(2).equalsIgnoreCase(t.getTurno())) {
							turmas.add(t);
						}
					}
				} else if (txt.get(2).isEmpty() == false) {
					if (txt.get(2).equalsIgnoreCase(t.getTurno())) {
						turmas.add(t);
					}
				}

			}
			list = turmas;
		}

		modelo.addColumn("Escola");
		modelo.addColumn("Turma");
		modelo.addColumn("Turno");
		modelo.addColumn("N° Total de Vagas");
		modelo.addColumn("Vagas Disponíveis");

		Object[] array = new Object[5];
		for (Turma e : list) {
			array[0] = e.getEscola().getNome();
			array[1] = e.getNome();
			array[2] = e.getTurno();
			array[3] = e.getNumeroDeVagas();
			array[4] = e.getNumeroDeVagasDiponiveis();
			modelo.addRow(array);
		}
		table = new JTable(modelo);

		JScrollPane painelTabela = new JScrollPane(table);
		painelTabela.setBounds(10, 128, 524, 307);
		frame.getContentPane().add(painelTabela);

		frame.repaint();

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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
}