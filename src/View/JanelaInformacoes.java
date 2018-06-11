package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.TurmaController;
import Model.Facade;
import Model.Turma;
import Ouvintes.OuvinteVoltarInicio;

import javax.swing.JLabel;
import javax.swing.JButton;

public class JanelaInformacoes {
	
	private JFrame frame;
	private JLabel lblEscola;
	private JLabel lblDocumentaoNecessaria;
	private JLabel nomeEscola;
	private JLabel lblSrie;
	private JLabel lSerie;
	private JLabel lblTurno;
	private JLabel lTurno;
	private JLabel lblNumeroTotalDe;
	private JLabel lNumeroTotal;
	private JLabel lblNumeroDisponivelDe;
	private JLabel lNDisponivel;
	private JLabel lblLocalizacao;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lRua;
	private JLabel lNumero;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lCidade;
	private JLabel lBairro;
	private JLabel lCEP;
	
	private static  int id;

	public JanelaInformacoes(int id) {
		this.id=id;
		initialize();
		colocarDados();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new  JanelaInformacoes(1);
	}
	
	public void colocarDados() {
		List<String> list= Facade.getFacade().retornarValoresTurmaPorID(id);
		

		nomeEscola.setText(list.get(0));
		lSerie.setText(list.get(1));
		lTurno.setText(list.get(2));
		lNumeroTotal.setText(list.get(3));
		lNDisponivel.setText(list.get(4));
		lRua.setText(list.get(5));
		lNumero.setText(list.get(6));
		lCidade.setText(list.get(7));
		
		lBairro.setText(list.get(8));
		lCEP.setText(list.get(9));
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("Acompanhamento de Vagas");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 450);
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.getContentPane().setLayout(null);
		
		lblEscola = new JLabel("Escola:");
		lblEscola.setBounds(10, 59, 46, 14);
		frame.getContentPane().add(lblEscola);
		
		lblDocumentaoNecessaria = new JLabel("Documentação necessaria:");
		lblDocumentaoNecessaria.setBounds(10, 215, 162, 14);
		frame.getContentPane().add(lblDocumentaoNecessaria);
		
		nomeEscola = new JLabel("");
		nomeEscola.setBounds(54, 59, 192, 14);
		frame.getContentPane().add(nomeEscola);
		
		lblSrie = new JLabel("Série:");
		lblSrie.setBounds(10, 83, 33, 14);
		frame.getContentPane().add(lblSrie);
		
		lSerie = new JLabel("");
		lSerie.setBounds(64, 83, 96, 14);
		frame.getContentPane().add(lSerie);
		
		lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(10, 108, 46, 14);
		frame.getContentPane().add(lblTurno);
		
		lTurno = new JLabel("");
		lTurno.setBounds(54, 108, 106, 14);
		frame.getContentPane().add(lTurno);
		
		lblNumeroTotalDe = new JLabel("Número total de vagas:");
		lblNumeroTotalDe.setBounds(10, 133, 133, 14);
		frame.getContentPane().add(lblNumeroTotalDe);
		
		lNumeroTotal = new JLabel("");
		lNumeroTotal.setBounds(153, 133, 56, 14);
		frame.getContentPane().add(lNumeroTotal);
		
		lblNumeroDisponivelDe = new JLabel("Número disponivel de vagas:");
		lblNumeroDisponivelDe.setBounds(10, 158, 172, 14);
		frame.getContentPane().add(lblNumeroDisponivelDe);
		
		lNDisponivel = new JLabel("");
		lNDisponivel.setBounds(192, 158, 46, 14);
		frame.getContentPane().add(lNDisponivel);
		
		lblLocalizacao = new JLabel("Localização:");
		lblLocalizacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalizacao.setBounds(281, 58, 87, 14);
		frame.getContentPane().add(lblLocalizacao);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(281, 83, 33, 14);
		frame.getContentPane().add(lblRua);
		
		lRua = new JLabel("");
		lRua.setBounds(319, 83, 87, 14);
		frame.getContentPane().add(lRua);

		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(281, 108, 62, 14);
		frame.getContentPane().add(lblNumero);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(281, 133, 46, 14);
		frame.getContentPane().add(lblCidade);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(281, 158, 39, 14);
		frame.getContentPane().add(lblBairro);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(281, 183, 39, 14);
		frame.getContentPane().add(lblCep);
		
		lRua = new JLabel("");
		lRua.setBounds(319, 83, 46, 14);
		frame.getContentPane().add(lRua);
		
		lNumero = new JLabel("");
		lNumero.setBounds(337, 108, 46, 14);
		frame.getContentPane().add(lNumero);
		
		lCidade = new JLabel("");
		lCidade.setBounds(337, 133, 46, 14);
		frame.getContentPane().add(lCidade);
		
		lBairro = new JLabel("");
		lBairro.setBounds(337, 158, 46, 14);
		frame.getContentPane().add(lBairro);
		
		lCEP = new JLabel("");
		lCEP.setBounds(319, 183, 87, 14);
		frame.getContentPane().add(lCEP);
		
		JLabel lblInformaesDaTurma = new JLabel("Informa\u00E7\u00F5es da Turma");
		lblInformaesDaTurma.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformaesDaTurma.setBounds(133, 11, 161, 14);
		frame.getContentPane().add(lblInformaesDaTurma);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(317, 355, 89, 23);
		btnVoltar.addActionListener(new OuvinteVoltarInicio(frame));
		frame.getContentPane().add(btnVoltar);
		
		
	}
}
