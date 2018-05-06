package Janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.text.ParseException;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class JanelaCadastrar {

	private JFrame frame;
	private JTextField textFielNome;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastrar = new JLabel("Cadastro de Escola");
		lblCadastrar.setBounds(7, 23, 517, 37);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(lblCadastrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 109, 103, 17);
		frame.getContentPane().add(lblNome);
		
		textFielNome = new JTextField();
		textFielNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFielNome.setBounds(123, 107, 145, 20);
		frame.getContentPane().add(textFielNome);
		textFielNome.setColumns(10);
		
		JLabel lblNvelDeEnsino = new JLabel("N\u00EDvel de Governo");
		lblNvelDeEnsino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNvelDeEnsino.setBounds(11, 145, 102, 14);
		frame.getContentPane().add(lblNvelDeEnsino);
		
		String[] niveis = { "Municipal", "Estadual", "Federal" };
		JComboBox comboBox = new JComboBox(niveis);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(123, 142, 145, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefoneCelular.setBounds(293, 110, 103, 14);
		frame.getContentPane().add(lblTelefoneCelular);

		JFormattedTextField formattedTextField;
		try {
			MaskFormatter mascaraTelefone =new MaskFormatter("(##) # ####-####");
			formattedTextField = new JFormattedTextField(mascaraTelefone);
			formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			formattedTextField.setBounds(379, 107, 145, 20);
			frame.getContentPane().add(formattedTextField);
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}
}
