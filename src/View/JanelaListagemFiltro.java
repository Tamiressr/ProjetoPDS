package View;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import Controllers.EscolaController;
import Controllers.TurmaController;
import Model.Escola;
import Model.Turma;

public class JanelaListagemFiltro {
	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelo;
	private JComboBox escolaComboBox = null;
	private JComboBox TurmacomboBox = null;
	private JComboBox TurnocomboBox = null;
	private String[] turnos = { "", "MANHÃ", "TARDE", "INTEGRAL", "NOITE" };
	private List<Escola> escolas;
	private String[] arrayturmas = { "1° ANO", "2° ANO", "3° ANO", "4° ANO", "5° ANO", " 6° ANO", "7° ANO", "8° ANO",
			"9° ANO" };
	private List<Turma> turma;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());

					JanelaListagemFiltro window = new JanelaListagemFiltro();
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
	public JanelaListagemFiltro() {
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

	
		
		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setFont(new Font("Arial", Font.BOLD, 14));
		lblEscola.setBounds(10, 64, 77, 14);
		frame.getContentPane().add(lblEscola);

		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("Arial", Font.BOLD, 14));
		lblTurma.setBounds(10, 89, 60, 14);
		frame.getContentPane().add(lblTurma);

		escolaComboBox = new JComboBox<>();
		escolaComboBox.setToolTipText("Selecione o nome da escola desejada");
		escolaComboBox.setBounds(70, 64, 301, 20);
		frame.getContentPane().add(escolaComboBox);

		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		modelo.addColumn("Turma");
		modelo.addColumn("Turno");
		modelo.addColumn("N° Total de Vagas");
		modelo.addColumn("Vagas Disponíveis");
		
		frame.getContentPane().add(table);
		escolas = EscolaController.getEscolaController().listar();

		for (Escola e : escolas) {
			escolaComboBox.addItem(e.getNome().toUpperCase());
		}
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

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btnPesquisar.setBounds(395, 64, 109, 42);
		OuvinteListagemFiltro pesquisar = new OuvinteListagemFiltro(this.frame);
		btnPesquisar.addActionListener(pesquisar);
		frame.getContentPane().add(btnPesquisar);
		frame.setVisible(true);

		frame.getContentPane().add(btnPesquisar);
		frame.setVisible(true);



		JScrollPane painelTabela = new JScrollPane(table);
		painelTabela.setBounds(10, 131, 524, 231);
		frame.getContentPane().add(painelTabela);
		
		JLabel lblListagemDeVagas = new JLabel("Filtragem de Vagas");
		lblListagemDeVagas.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblListagemDeVagas.setBounds(115, 11, 283, 55);
		frame.getContentPane().add(lblListagemDeVagas);

	}

	public ArrayList<String> retornaValores() {
		ArrayList<String> array = new ArrayList<>();
		array.add(arrayturmas[TurmacomboBox.getSelectedIndex()]);
		array.add(turnos[TurnocomboBox.getSelectedIndex()]);
		array.add(escolas.get(escolaComboBox.getSelectedIndex()).getNome());
		return array;

	}

	public String[] getTurnos() {
		return turnos;
	}

	public void setTurnos(String[] turnos) {
		this.turnos = turnos;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public String[] getArrayturmas() {
		return arrayturmas;
	}

	public void setArrayturmas(String[] arrayturmas) {
		this.arrayturmas = arrayturmas;
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

	public JComboBox getEscolaComboBox() {
		return escolaComboBox;
	}

	public void setEscolaComboBox(JComboBox escolaComboBox) {
		this.escolaComboBox = escolaComboBox;
	}

	public JComboBox getTurmacomboBox() {
		return TurmacomboBox;
	}

	public void setTurmacomboBox(JComboBox turmacomboBox) {
		TurmacomboBox = turmacomboBox;
	}

	public JComboBox getTurnocomboBox() {
		return TurnocomboBox;
	}

	public void setTurnocomboBox(JComboBox turnocomboBox) {
		TurnocomboBox = turnocomboBox;
	}



	
	
	public class OuvinteListagemFiltro implements ActionListener {
		private JFrame janela;

		public OuvinteListagemFiltro(JFrame janela) {
			this.janela = janela;
		}

		public void actionPerformed(ActionEvent e) {
			
		
			List<Turma> list = TurmaController.getTurmaController().listar();
			ArrayList<String> resul = retornaValores();
	
			Object[] array = new Object[5];
		
			
			
			for (Turma es : list) {
				

				if (resul.get(2).equalsIgnoreCase(es.getEscola().getNome())&& resul.get(0).substring(0,1).equals(es.getNome().substring(0,1))&& resul.get(1).substring(0, 1).equals(es.getTurno().substring(0, 1)) ) {
						array[0] = es.getNome();
						 array[1]=es.getTurno();
						 array[2]=es.getNumeroDeVagas();
						 array[3]=es.getNumeroDeVagasDiponiveis();
						 modelo.addRow(array);
						 break;

					
				
				}
			else if(resul.get(1).substring(0, 1)!=es.getTurno().substring(0, 1)&& resul.get(0).substring(0,1)!=es.getNome().substring(0,1)){
						JOptionPane.showMessageDialog(null,":( nenhum resultado correspondente foi encontrado");
						break;
					
			
						
					}	
						
					
				
				}
		
		
		

}

		}

}
