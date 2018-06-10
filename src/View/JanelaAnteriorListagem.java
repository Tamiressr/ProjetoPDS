package View;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import Ouvintes.OuvinteJanelaListagemVagas;
import Ouvintes.OuvinteJanelaListarTurma;
import Ouvintes.OuvinteListagemFiltro;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JanelaAnteriorListagem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAnteriorListagem window = new JanelaAnteriorListagem();
					UIManager.setLookAndFeel(new BernsteinLookAndFeel());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public JanelaAnteriorListagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.getContentPane().setBackground(new Color(255, 153, 51));
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
		
		JLabel lblCaroPaiOu = new JLabel("Caro Pai ou Respons\u00E1vel, Selecione a Op\u00E7\u00E3o Desejada");
		lblCaroPaiOu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCaroPaiOu.setBounds(22, 30, 442, 44);
		frame.getContentPane().add(lblCaroPaiOu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JanelaAnteriorListagem.class.getResource("/AnitaBlack.jpg")));
		lblNewLabel.setBounds(22, 171, 524, 412);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVisualizarVagasDe = new JButton("Visualizar Vagas de Todas as Escolas");
		btnVisualizarVagasDe.setBounds(22, 103, 427, 23);
		btnVisualizarVagasDe.addActionListener(new  OuvinteJanelaListagemVagas(frame));
		frame.getContentPane().add(btnVisualizarVagasDe);
		
		JButton btnSelecionarVagasPor = new JButton("Selecionar Vagas por Turno, Turma e Escola");
		btnSelecionarVagasPor.setBounds(22, 137, 427, 23);
		
		btnSelecionarVagasPor.addActionListener(new OuvinteListagemFiltro(frame));
		frame.getContentPane().add(btnSelecionarVagasPor);
		
	}
}
