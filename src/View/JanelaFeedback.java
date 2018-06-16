package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Ouvintes.OuvinteEnviarEmail;
import Ouvintes.OuvinteVoltarInicio;

import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JanelaFeedback {

	private JFrame frame;
	private TextArea textotextArea;
	private JTextField textField;

	public TextArea getTextotextArea() {
		return textotextArea;
	}

	public void setTextotextArea(TextArea textotextArea) {
		this.textotextArea = textotextArea;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaFeedback window = new JanelaFeedback();
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
	public JanelaFeedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		frame.setTitle("Acompanhamento de Vagas");
		frame.setBounds(100, 100, 550, 550);
		frame.setJMenuBar(Janela.setMenuBar(frame));
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 100);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(426, 434, 98, 41);
		OuvinteEnviarEmail enviarEmail= new OuvinteEnviarEmail(this);
		btnEnviar.addActionListener(enviarEmail);
		frame.getContentPane().add(btnEnviar);
		
		textotextArea = new TextArea();
		textotextArea.setBounds(10, 177, 514, 251);
		frame.getContentPane().add(textotextArea);
		
		JLabel lblFeedback = new JLabel("FeedBack");
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setBounds(118, 0, 247, 26);
		lblFeedback.setFont(new Font("Arial", Font.PLAIN, 24));
		lblFeedback.setBackground(Color.BLACK);
		frame.getContentPane().add(lblFeedback);
		
		JLabel lblARtaSystem = new JLabel("A empresa R.T.A System gostaria de saber o que voc\u00EA tem a dizer");
		lblARtaSystem.setForeground(new Color(0, 0, 0));
		lblARtaSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblARtaSystem.setBounds(28, 30, 496, 33);
		frame.getContentPane().add(lblARtaSystem);
		
		JLabel lbldeixaAquiSua = new JLabel("Reclama\u00E7\u00F5es, D\u00FAvidas e Sugest\u00F5es de Melhoria");
		lbldeixaAquiSua.setForeground(new Color(0, 0, 0));
		lbldeixaAquiSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbldeixaAquiSua.setBounds(92, 74, 368, 43);
		frame.getContentPane().add(lbldeixaAquiSua);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(327, 434, 89, 41);
		OuvinteVoltarInicio voltarinicio=new OuvinteVoltarInicio(this.frame);
		btnVoltar.addActionListener(voltarinicio);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNome.setBounds(10, 144, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(66, 143, 334, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}