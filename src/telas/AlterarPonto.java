package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlterarPonto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarPonto frame = new AlterarPonto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlterarPonto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPontoEletrnico = new JLabel("Alteração de Dados");
		lblPontoEletrnico.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPontoEletrnico.setBounds(135, 0, 264, 47);
		contentPane.add(lblPontoEletrnico);
		
		txtCpf = new JTextField();
		
		
		txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtCpf.setBounds(139, 92, 208, 19);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnEntrar = new JButton("Alterar");
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEntrar.setBounds(200, 118, 92, 15);
		contentPane.add(btnEntrar);
		
		JLabel lblDigiteOSeu = new JLabel("Digite o CPF do funcionário que deseja alterar");
		lblDigiteOSeu.setBounds(87, 65, 356, 15);
		contentPane.add(lblDigiteOSeu);
	}
}
