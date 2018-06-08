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

public class JanelaFeedback {

	private JFrame frame;
	private TextArea textotextArea;

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
		frame.getContentPane().setBackground(new Color(255, 153, 51));
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
		lblFeedback.setBounds(147, 50, 247, 26);
		lblFeedback.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFeedback.setBackground(Color.BLACK);
		frame.getContentPane().add(lblFeedback);
		
		JLabel lblARtaSystem = new JLabel("A empresa R.T.A System gostaria de saber o que voc\u00EA tem a dizer");
		lblARtaSystem.setForeground(new Color(0, 0, 0));
		lblARtaSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblARtaSystem.setBounds(28, 138, 496, 33);
		frame.getContentPane().add(lblARtaSystem);
		
		JLabel lbldeixaAquiSua = new JLabel("Reclama\u00E7\u00F5es, D\u00FAvidas e Sugest\u00F5es de melhoria");
		lbldeixaAquiSua.setForeground(new Color(0, 0, 0));
		lbldeixaAquiSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbldeixaAquiSua.setBounds(0, 434, 368, 43);
		frame.getContentPane().add(lbldeixaAquiSua);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(327, 434, 89, 41);
		OuvinteVoltarInicio voltarinicio=new OuvinteVoltarInicio(frame);
		btnVoltar.addActionListener(voltarinicio);
		frame.getContentPane().add(btnVoltar);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}