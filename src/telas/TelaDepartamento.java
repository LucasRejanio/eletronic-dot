package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;

import entidades.Departamento;
import entidades.DepartamentoCRUD;
import entidades.Funcionario;
import entidades.FuncionarioCRUD;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class TelaDepartamento extends JFrame {

	private JPanel JPanel1;
	private JTextField txtID;
	private JTable jTDepartamentos;
	private JPanel JPanelCadastro;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtIDUP;
	private JTextField txtNomeUP;
	private JTextField txtDescricaoUP;
	private JTable jTDepartamentoUP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDepartamento frame = new TelaDepartamento();
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
	public TelaDepartamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 490);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDepartamento = new JMenu("Departamento");
		menuBar.add(mnDepartamento);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Listar");
			}
		});
		mnDepartamento.add(mntmListar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Cadastrar");
			}
		});
		mnDepartamento.add(mntmCadastrar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Alterar");
			}
		});
		mnDepartamento.add(mntmAlterar);
		
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
		JPanel1 = new JPanel();
		JPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel1);
		JPanel1.setLayout(new CardLayout(0, 0));
		
		JPanel JPanelListar = new JPanel();
		JPanelListar.setLayout(null);
		JPanel1.add(JPanelListar, "Listar");
		
		jTDepartamentos = new JTable();
		jTDepartamentos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jTDepartamentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "DESCRICAO"
			}
		));
		jTDepartamentos.setBounds(22, 34, 578, 273);
		JPanelListar.add(jTDepartamentos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 0, 0);
		JPanelListar.add(scrollPane_1);
		
		JLabel label_5 = new JLabel("C\u00D3DIGO");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		label_5.setBounds(22, 11, 193, 23);
		JPanelListar.add(label_5);
		
		JLabel label_6 = new JLabel("NOME");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		label_6.setBounds(215, 11, 193, 23);
		JPanelListar.add(label_6);
		
		JLabel lblDescrio_1 = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrio_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescrio_1.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblDescrio_1.setBounds(408, 11, 192, 23);
		JPanelListar.add(lblDescrio_1);
		
		JPanelCadastro = new JPanel();
		JPanel1.add(JPanelCadastro, "Cadastrar");
		JPanelCadastro.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(159, 52, 201, 20);
		JPanelCadastro.add(txtID);
		
		JLabel lblCdigoDepartamento = new JLabel("Código Departamento:");
		lblCdigoDepartamento.setBounds(22, 55, 139, 14);
		JPanelCadastro.add(lblCdigoDepartamento);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 99, 139, 14);
		JPanelCadastro.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(159, 93, 201, 20);
		JPanelCadastro.add(txtNome);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(22, 138, 139, 14);
		JPanelCadastro.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(159, 132, 287, 20);
		JPanelCadastro.add(txtDescricao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento dep = new Departamento();
				DepartamentoCRUD dcrud = new DepartamentoCRUD();
				
				if(txtID.getText().equals("") || txtNome.getText().equals("") || txtDescricao.getText().equals("")) {
					JOptionPane.showMessageDialog(JPanel1,"Preencha os campos !");
				}else {
					dep.setId(Integer.parseInt(txtID.getText()));
					dep.setNome(txtNome.getText());
					dep.setDescricao(txtDescricao.getText());
					
					if(dcrud.inserirDepartamento(dep) == true) {
						JOptionPane.showMessageDialog(JPanel1,"Cadastro concluido com sucesso!");
					}
					
					readJTableDepartamento();
					
					CardLayout cl = (CardLayout) JPanel1.getLayout();
					cl.show(JPanel1, "Listar");
					
				}
				
				
				
			}
		});
		btnCadastrar.setBounds(22, 215, 118, 37);
		JPanelCadastro.add(btnCadastrar);
		
		JPanel JPanelAlterar = new JPanel();
		JPanelAlterar.setLayout(null);
		JPanel1.add(JPanelAlterar, "Alterar");
		
		txtIDUP = new JTextField();
		txtIDUP.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDUP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					Departamento dep = new Departamento();
					dep.setId(Integer.parseInt(txtIDUP.getText()));
					
					DepartamentoCRUD dcrud = new DepartamentoCRUD();
					
					if(dcrud.validarCod(dep)) {
						txtNomeUP.setEnabled(true);
						txtNomeUP.setBackground(Color.WHITE);
						txtDescricaoUP.setEnabled(true);
						txtDescricaoUP.setBackground(Color.WHITE);

					
						
						FuncionarioCRUD fcrud = new FuncionarioCRUD();
						
						for(Departamento d: dcrud.carregar(dep)) {
							
									txtNomeUP.setText(d.getNome());
									txtDescricaoUP.setText(d.getDescricao());

							
						}
						
					}

				}
			}
		});
		txtIDUP.setBounds(164, 208, 67, 20);
		JPanelAlterar.add(txtIDUP);
		
		JLabel label_2 = new JLabel("C\u00F3digo Departamento:");
		label_2.setBounds(27, 211, 139, 14);
		JPanelAlterar.add(label_2);
		
		JLabel label_3 = new JLabel("Nome:");
		label_3.setBounds(27, 255, 139, 14);
		JPanelAlterar.add(label_3);
		
		txtNomeUP = new JTextField();
		txtNomeUP.setBounds(164, 249, 201, 20);
		txtNomeUP.setBackground(Color.LIGHT_GRAY);
		txtNomeUP.setEnabled(false);
		JPanelAlterar.add(txtNomeUP);
		
		JLabel label_4 = new JLabel("Descri\u00E7\u00E3o:");
		label_4.setBounds(27, 294, 139, 14);
		JPanelAlterar.add(label_4);
		
		txtDescricaoUP = new JTextField();
		txtDescricaoUP.setBounds(164, 288, 287, 20);
		txtDescricaoUP.setBackground(Color.LIGHT_GRAY);
		txtDescricaoUP.setEnabled(false);
		JPanelAlterar.add(txtDescricaoUP);
		
		JButton txtAlterar = new JButton("Alterar");
		txtAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Departamento dep = new Departamento();
				DepartamentoCRUD dcrud = new DepartamentoCRUD();
				
				if(txtIDUP.getText().equals("") || txtNomeUP.getText().equals("") || txtDescricaoUP.getText().equals("")) {
					JOptionPane.showMessageDialog(JPanel1,"Preencha os campos !");
				}else {
					dep.setId(Integer.parseInt(txtIDUP.getText()));
					dep.setNome(txtNomeUP.getText());
					dep.setDescricao(txtDescricaoUP.getText());
					
					if(dcrud.atualizar(dep) == true) {
						JOptionPane.showMessageDialog(JPanel1,"Departamento Atualizado!");
					}
					
					readJTableDepartamentoUP();
					
					
				}
			}
		});
		txtAlterar.setBounds(27, 353, 118, 37);
		JPanelAlterar.add(txtAlterar);
		
		jTDepartamentoUP = new JTable();
		jTDepartamentoUP.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jTDepartamentoUP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME"
			}
		));
		jTDepartamentoUP.setBounds(10, 44, 460, 153);
		JPanelAlterar.add(jTDepartamentoUP);
		
		JLabel label_7 = new JLabel("C\u00D3DIGO");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		label_7.setBounds(10, 20, 230, 23);
		JPanelAlterar.add(label_7);
		
		JLabel label_8 = new JLabel("NOME");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		label_8.setBounds(240, 20, 230, 23);
		JPanelAlterar.add(label_8);
		
		DefaultTableModel modelo2 = (DefaultTableModel) jTDepartamentos.getModel();
		DefaultTableModel modelo = (DefaultTableModel) jTDepartamentoUP.getModel();
		readJTableDepartamento();
		readJTableDepartamentoUP();
	}
	
	public void readJTableDepartamento(){
		DefaultTableModel modelo2 = (DefaultTableModel) jTDepartamentos.getModel();
		modelo2.setNumRows(0);
		DepartamentoCRUD dcrud = new DepartamentoCRUD();
		
		for(Departamento d: dcrud.read()) {
			modelo2.addRow(new Object[] {
					d.getId(),
					d.getNome(),
					d.getDescricao()
			});
		}
		
	}
	
	public void readJTableDepartamentoUP(){
		DefaultTableModel modelo = (DefaultTableModel) jTDepartamentoUP.getModel();
		modelo.setNumRows(0);
		DepartamentoCRUD dcrud = new DepartamentoCRUD();
		
		for(Departamento d: dcrud.read()) {
			modelo.addRow(new Object[] {
					d.getId(),
					d.getNome()
			});
		}
		
	}
}
