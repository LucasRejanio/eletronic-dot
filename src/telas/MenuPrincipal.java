package telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnFuncionario = new JButton("Funcion\u00E1rio");
		btnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaFuncionario frame2 = new TelaFuncionario();
				frame2.setVisible(true);
				
				dispose();
			}
		});
		btnFuncionario.setBounds(0, 0, 170, 120);
		contentPane.add(btnFuncionario);
		
		JButton btnDepartamento = new JButton("Departamentos");
		btnDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaDepartamento frame3 = new TelaDepartamento();
				frame3.setVisible(true);
				dispose();
			}
		});
		btnDepartamento.setBounds(0, 119, 170, 120);
		contentPane.add(btnDepartamento);
		
		JButton btnPonto = new JButton("Pontos");
		btnPonto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaPonto frame4 = new TelaPonto();
				frame4.setVisible(true);
				dispose();
			}
		});
		btnPonto.setBounds(0, 237, 170, 120);
		contentPane.add(btnPonto);
		
		JLabel lblSeja = new JLabel("Seja Bem Vindo");
		lblSeja.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeja.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeja.setBounds(291, 145, 168, 42);
		contentPane.add(lblSeja);
		
		JLabel lblNewLabel = new JLabel("PONTO ELETRONICO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(278, 175, 206, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(0, 380, 170, 23);
		contentPane.add(btnSair);
		
		JButton btnTelaInicial = new JButton("Voltar a Tela Inicial");
		btnTelaInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
				dispose();
			}
		});
		btnTelaInicial.setBounds(0, 356, 170, 25);
		contentPane.add(btnTelaInicial);
	}
}
