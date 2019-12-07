package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entidades.ConnectionFactory;
import entidades.Funcionario;
import entidades.FuncionarioCRUD;
import entidades.Ponto;
import entidades.PontoCRUD;

public class TelaInicial extends JFrame{

	private JPanel contentPane;
	private JTextField txtCPF;
	
	Connection conn = ConnectionFactory.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPontoEletrnico = new JLabel("Ponto Eletr\u00F4nico");
		lblPontoEletrnico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontoEletrnico.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPontoEletrnico.setBounds(83, 67, 195, 47);
		contentPane.add(lblPontoEletrnico);
		
		txtCPF = new JTextField();
		
		
		txtCPF.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtCPF.setBounds(70, 166, 208, 19);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JButton btnEntrar = new JButton("Registrar Ponto");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Funcionario	funcionario1 = new Funcionario();
				funcionario1.setCpf(txtCPF.getText());
				
				FuncionarioCRUD funcrud = new FuncionarioCRUD();
				
				if(funcrud.validarCpf(funcionario1)) {
					Ponto ponto = new Ponto();
					PontoCRUD pcrud = new PontoCRUD();
					String cpf = funcionario1.getCpf();
					ponto.setCpf(cpf);
					pcrud.registrar(ponto);
				}
				
			}
		});
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEntrar.setBounds(106, 207, 140, 30);
		contentPane.add(btnEntrar);
		
		JLabel lblDigiteOSeu = new JLabel("Digite o seu CPF");
		lblDigiteOSeu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigiteOSeu.setBounds(120, 125, 126, 30);
		contentPane.add(lblDigiteOSeu);
		
		JButton btnMenuAdmin = new JButton("Menu Admin");
		btnMenuAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame1 = new MenuPrincipal();
				frame1.setVisible(true);
				dispose();
			}
		});
		btnMenuAdmin.setBounds(10, 337, 115, 23);
		contentPane.add(btnMenuAdmin);
	}
}
