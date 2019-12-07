package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import entidades.Ponto;
import entidades.PontoCRUD;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPonto extends JFrame {

	private JPanel contentPane;
	private JTable jTablePontos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPonto frame = new TelaPonto();
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
	public TelaPonto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 490);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ponto");
		menuBar.add(mnNewMenu);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});
		mnOpes.add(mntmVoltar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		jTablePontos = new JTable();
		jTablePontos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"FUNCION\u00C1RIO", "TIPO", "DATA/HORA"
			}
		));
		jTablePontos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jTablePontos.setBounds(24, 51, 714, 273);
		contentPane.add(jTablePontos);
		
		JLabel lblFuncionrio = new JLabel("FUNCION\u00C1RIO");
		lblFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFuncionrio.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		lblFuncionrio.setBounds(24, 29, 238, 23);
		contentPane.add(lblFuncionrio);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblTipo.setBounds(262, 29, 238, 23);
		contentPane.add(lblTipo);
		
		JLabel lblDataHora = new JLabel("DATA / HORA");
		lblDataHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataHora.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblDataHora.setBounds(500, 29, 238, 23);
		contentPane.add(lblDataHora);
		
		DefaultTableModel modelo = (DefaultTableModel) jTablePontos.getModel();
		
		readJTablePonto();
	}
	
	public void readJTablePonto(){
		DefaultTableModel modelo = (DefaultTableModel) jTablePontos.getModel();
		modelo.setNumRows(0);
		PontoCRUD pcrud = new PontoCRUD();
		
		for(Ponto p: pcrud.read()) {
			modelo.addRow(new Object[] {
					p.getUsuario(),
					p.getTipo_ponto(),
					p.getData_hora()
			});
		}
		
	}
}
