package telas;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidades.Departamento;
import entidades.DepartamentoCRUD;
import entidades.Funcionario;
import entidades.FuncionarioCRUD;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class TelaFuncionario extends JFrame {

	private JPanel JPanel1;
	private JTextField txtDepartamento;
	
	private JTextField txtDepartamentoUP;
	private JTextField txtVerificaCPF;
	private JTable jTFuncionarios;
	private JTable jTDepartamentos;
	private JTable jTDepartamentosUP;
	private JTextField txtCPFDEL;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaFuncionario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 490);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFuncionario = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionario);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Cadastrar");
				
			}
		});
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Listar");
			}
		});
		mnFuncionario.add(mntmListar);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		mnFuncionario.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Alterar");

			}
		});
		mnFuncionario.add(mntmNewMenuItem_1);
		
		JMenu mnOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpcoes);
		
		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				dispose();
				
			}
		});
		mnOpcoes.add(mntmVoltar);
		
		JPanel1 = new JPanel();
		JPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel1);
		JPanel1.setLayout(new CardLayout(0, 0));
		
		JPanel JPanelListar = new JPanel();
		JPanel1.add(JPanelListar, "Listar");
		JPanelListar.setLayout(null);
		
		jTFuncionarios = new JTable();
		jTFuncionarios.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jTFuncionarios.setBounds(10, 35, 713, 273);
		jTFuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "NOME", "E-MAIL", "CARGO", "TELEFONE", "PIS"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(171);
		JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	
		JPanelListar.add(jTFuncionarios);
		JPanelListar.add(jScrollPane1);
		
		txtCPFDEL = new JTextField();
		txtCPFDEL.setBounds(65, 367, 201, 20);
		JPanelListar.add(txtCPFDEL);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setBounds(22, 370, 46, 14);
		JPanelListar.add(label_1);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF para excluir");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf.setBounds(20, 324, 167, 32);
		JPanelListar.add(lblDigiteOCpf);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario1 =  new Funcionario();
				FuncionarioCRUD funcrud = new FuncionarioCRUD();
				
				funcionario1.setCpf(txtCPFDEL.getText());
				
				if(funcrud.validarCpf(funcionario1)) {
					funcrud.delete(funcionario1);
					
				}
				
				readJTableFuncionario();
			}
		});
		btnExcluir.setBounds(304, 366, 89, 23);
		JPanelListar.add(btnExcluir);
		
		JLabel lblTabelaCPF = new JLabel("CPF");
		lblTabelaCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaCPF.setBounds(10, 11, 103, 23);
		lblTabelaCPF.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		JPanelListar.add(lblTabelaCPF);
		
		JLabel lblTabelaNome = new JLabel("NOME");
		lblTabelaNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaNome.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblTabelaNome.setBounds(111, 11, 105, 23);
		JPanelListar.add(lblTabelaNome);
		
		JLabel lblTabelaEmail = new JLabel("E-MAIL");
		lblTabelaEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaEmail.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblTabelaEmail.setBounds(215, 11, 200, 23);
		JPanelListar.add(lblTabelaEmail);
		
		JLabel lblTabelaCargo = new JLabel("CARGO");
		lblTabelaCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaCargo.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblTabelaCargo.setBounds(411, 11, 107, 23);
		JPanelListar.add(lblTabelaCargo);
		
		JLabel lblTabelaTelefone = new JLabel("TELEFONE");
		lblTabelaTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaTelefone.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblTabelaTelefone.setBounds(518, 11, 103, 23);
		JPanelListar.add(lblTabelaTelefone);
		
		JLabel lblTabelaPIS = new JLabel("PIS");
		lblTabelaPIS.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaPIS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaPIS.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lblTabelaPIS.setBounds(620, 11, 103, 23);
		JPanelListar.add(lblTabelaPIS);
		
		
		
		
		
		JPanel JPanelCadastro = new JPanel();
		JPanelCadastro.setBackground(UIManager.getColor("Button.background"));
		JPanel1.add(JPanelCadastro, "Cadastrar");
		JPanelCadastro.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 21, 46, 14);
		JPanelCadastro.add(lblNewLabel);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(67, 15, 201, 20);
		JPanelCadastro.add(txtNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 58, 46, 14);
		JPanelCadastro.add(lblCpf);
		
		JTextField txtCPF = new JTextField();
		txtCPF.setBounds(67, 52, 201, 20);
		JPanelCadastro.add(txtCPF);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 101, 46, 14);
		JPanelCadastro.add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(67, 95, 201, 20);
		JPanelCadastro.add(txtEmail);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(10, 141, 46, 14);
		JPanelCadastro.add(lblCargo);
		
		JTextField txtCargo = new JTextField();
		txtCargo.setBounds(67, 135, 201, 20);
		JPanelCadastro.add(txtCargo);
		
		
		JLabel lblPis = new JLabel("PIS:");
		lblPis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPis.setBounds(10, 217, 48, 14);
		JPanelCadastro.add(lblPis);
		
		JTextField txtPIS = new JTextField();
		txtPIS.setBounds(67, 211, 201, 20);
		JPanelCadastro.add(txtPIS);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 174, 67, 14);
		JPanelCadastro.add(lblTelefone);
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setBounds(67, 172, 201, 20);
		JPanelCadastro.add(txtTelefone);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario1 =  new Funcionario();
				Departamento departamento1 = new Departamento();
				FuncionarioCRUD funcrud = new FuncionarioCRUD();
				
				funcionario1.setNome(txtNome.getText());
				funcionario1.setCpf(txtCPF.getText());
				funcionario1.setEmail(txtEmail.getText());
				funcionario1.setCargo(txtCargo.getText());
				funcionario1.setTelefone(txtTelefone.getText());
				funcionario1.setPis(Integer.parseInt(txtPIS.getText()));
				funcionario1.setDepartamento(Integer.parseInt(txtDepartamento.getText()));
				
				funcrud.inserir(funcionario1);// INSERT

				
				
				readJTableFuncionario();
				
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Listar");
				
			}
		});
		
		btnCadastrar.setBounds(300, 242, 128, 41);
		JPanelCadastro.add(btnCadastrar);
		
		JLabel lblDepartamento = new JLabel("C\u00F3digo Departamento:");
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartamento.setBounds(10, 255, 167, 17);
		JPanelCadastro.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDepartamento.setBounds(151, 254, 46, 20);
		JPanelCadastro.add(txtDepartamento);
		txtDepartamento.setColumns(10);
	
		
		JLabel lblNewLabel_1 = new JLabel("Departamentos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(300, 19, 154, 21);
		JPanelCadastro.add(lblNewLabel_1);
		
		jTDepartamentos = new JTable();
		jTDepartamentos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jTDepartamentos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		jTDepartamentos.setBounds(300, 73, 308, 149);
		
		JPanelCadastro.add(jTDepartamentos);
		
		JLabel lblTabelaIdDep = new JLabel("C\u00D3DIGO");
		lblTabelaIdDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabelaIdDep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTabelaIdDep.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		lblTabelaIdDep.setBounds(300, 51, 154, 23);
		JPanelCadastro.add(lblTabelaIdDep);
		
		JLabel lvlTabelaNomeDep = new JLabel("NOME");
		lvlTabelaNomeDep.setHorizontalAlignment(SwingConstants.CENTER);
		lvlTabelaNomeDep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lvlTabelaNomeDep.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		lvlTabelaNomeDep.setBounds(454, 51, 154, 23);
		JPanelCadastro.add(lvlTabelaNomeDep);
		
			
		
		JPanel JPanelAlterar = new JPanel();
		JPanelAlterar.setBackground(UIManager.getColor("Button.background"));
		JPanel1.add(JPanelAlterar, "Alterar");
		JPanelAlterar.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 66, 46, 14);
		JPanelAlterar.add(label);
		
		JTextField txtNomeUP = new JTextField();
		txtNomeUP.setBackground(Color.WHITE);
		txtNomeUP.setBounds(71, 66, 201, 20);
		txtNomeUP.setBackground(Color.LIGHT_GRAY);
		txtNomeUP.setEnabled(false);
		JPanelAlterar.add(txtNomeUP);
		
		
		JLabel label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 97, 46, 14);
		JPanelAlterar.add(label_2);
		
		JTextField txtEmailUP = new JTextField();
		txtEmailUP.setBounds(71, 97, 201, 20);
		txtEmailUP.setBackground(Color.LIGHT_GRAY);
		txtEmailUP.setEnabled(false);
		JPanelAlterar.add(txtEmailUP);
		
		JLabel label_3 = new JLabel("Cargo:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 128, 46, 14);
		JPanelAlterar.add(label_3);
		
		JTextField txtPISUP = new JTextField();
		txtPISUP.setBounds(71, 190, 201, 20);
		txtPISUP.setBackground(Color.LIGHT_GRAY);
		txtPISUP.setEnabled(false);
		JPanelAlterar.add(txtPISUP);
		
		
		JLabel label_4 = new JLabel("PIS:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(10, 190, 48, 14);
		JPanelAlterar.add(label_4);
		
		JTextField txtTelefoneUP = new JTextField();
		txtTelefoneUP.setBounds(71, 159, 201, 20);
		txtTelefoneUP.setBackground(Color.LIGHT_GRAY);
		txtTelefoneUP.setEnabled(false);
		JPanelAlterar.add(txtTelefoneUP);
		
		JLabel label_5 = new JLabel("Telefone:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(10, 159, 67, 14);
		JPanelAlterar.add(label_5);
		
		JTextField txtCargoUP = new JTextField();
		txtCargoUP.setBounds(71, 128, 201, 20);
		txtCargoUP.setBackground(Color.LIGHT_GRAY);
		txtCargoUP.setEnabled(false);
		JPanelAlterar.add(txtCargoUP);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario1 =  new Funcionario();
				FuncionarioCRUD funcrud = new FuncionarioCRUD();
				
				funcionario1.setCpf(txtVerificaCPF.getText());
				
				funcionario1.setNome(txtNomeUP.getText());
				funcionario1.setEmail(txtEmailUP.getText());
				funcionario1.setCargo(txtCargoUP.getText());
				funcionario1.setTelefone(txtTelefoneUP.getText());
				funcionario1.setPis(Integer.parseInt(txtPISUP.getText()));
				funcionario1.setDepartamento(Integer.parseInt(txtDepartamentoUP.getText()));
				
				funcrud.atualizar(funcionario1);// INSERT

				
				
				readJTableFuncionario();
				
				CardLayout cl = (CardLayout) JPanel1.getLayout();
				cl.show(JPanel1, "Listar");
				
			}
		});
		btnAtualizar.setBounds(318, 248, 128, 41);
		JPanelAlterar.add(btnAtualizar);
		
		JLabel label_7 = new JLabel("Departamentos");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(318, 20, 128, 23);
		JPanelAlterar.add(label_7);
		
		JLabel label_8 = new JLabel("CPF:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(10, 26, 46, 14);
		JPanelAlterar.add(label_8);
		
		JLabel lblCdigoDepartamento = new JLabel("C\u00F3digo Departamento:");
		lblCdigoDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigoDepartamento.setBounds(10, 236, 160, 14);
		JPanelAlterar.add(lblCdigoDepartamento);
		
		txtDepartamentoUP = new JTextField();
		txtDepartamentoUP.setHorizontalAlignment(SwingConstants.CENTER);
		txtDepartamentoUP.setBounds(147, 234, 57, 20);
		txtDepartamentoUP.setBackground(Color.LIGHT_GRAY);
		txtDepartamentoUP.setEnabled(false);
		JPanelAlterar.add(txtDepartamentoUP);
		txtDepartamentoUP.setColumns(10);
		
		txtVerificaCPF = new JTextField();
		txtVerificaCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					Funcionario	funcionario1 = new Funcionario();
					funcionario1.setCpf(txtVerificaCPF.getText());
					
					FuncionarioCRUD funcrud = new FuncionarioCRUD();
					
					if(funcrud.validarCpf(funcionario1)) {
						txtNomeUP.setEnabled(true);
						txtNomeUP.setBackground(Color.WHITE);
						txtEmailUP.setEnabled(true);
						txtEmailUP.setBackground(Color.WHITE);
						txtCargoUP.setEnabled(true);
						txtCargoUP.setBackground(Color.WHITE);
						txtTelefoneUP.setEnabled(true);
						txtTelefoneUP.setBackground(Color.WHITE);
						txtPISUP.setEnabled(true);
						txtPISUP.setBackground(Color.WHITE);
						txtDepartamentoUP.setEnabled(true);
						txtDepartamentoUP.setBackground(Color.WHITE);
						
						
						txtVerificaCPF.setBackground(Color.LIGHT_GRAY);
						txtVerificaCPF.setDisabledTextColor(Color.BLACK);
						txtVerificaCPF.setEnabled(false);
						
						FuncionarioCRUD fcrud = new FuncionarioCRUD();
						
						for(Funcionario f: fcrud.carregar(funcionario1)) {
							
									txtNomeUP.setText(f.getNome());
									txtEmailUP.setText(f.getEmail());
									txtCargoUP.setText(f.getCargo());
									txtTelefoneUP.setText(f.getTelefone());
									txtPISUP.setText(Integer.toString(f.getPis()));
									txtDepartamentoUP.setText(Integer.toString(f.getDepartamento()));
							
						}
						
					}

				}
			}
		});
	
		txtVerificaCPF.setBounds(71, 23, 201, 20);
		JPanelAlterar.add(txtVerificaCPF);
		txtVerificaCPF.setColumns(10);
		
		jTDepartamentosUP = new JTable();
		jTDepartamentosUP.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jTDepartamentosUP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTDepartamentosUP.setBounds(315, 88, 308, 149);
		JPanelAlterar.add(jTDepartamentosUP);
		
		JLabel label_9 = new JLabel("C\u00D3DIGO");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		label_9.setBounds(315, 66, 154, 23);
		JPanelAlterar.add(label_9);
		
		JLabel label_10 = new JLabel("NOME");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		label_10.setBounds(469, 66, 154, 23);
		JPanelAlterar.add(label_10);

		DefaultTableModel modelo = (DefaultTableModel) jTFuncionarios.getModel();
		DefaultTableModel modelo2 = (DefaultTableModel) jTDepartamentos.getModel();
		DefaultTableModel modelo3 = (DefaultTableModel) jTDepartamentosUP.getModel();
		
		readJTableFuncionario();
		readJTableDepartamento();
		readJTableDepartamentoUpdate();
	}
	
	public void readJTableFuncionario(){
		DefaultTableModel modelo = (DefaultTableModel) jTFuncionarios.getModel();
		modelo.setNumRows(0);
		FuncionarioCRUD fcrud = new FuncionarioCRUD();
		
		for(Funcionario f: fcrud.read()) {
			modelo.addRow(new Object[] {
					f.getCpf(),
					f.getNome(),
					f.getEmail(),
					f.getCargo(),
					f.getTelefone(),
					f.getPis()
			});
		}
		
	}
	
	public void readJTableDepartamento(){
		DefaultTableModel modelo2 = (DefaultTableModel) jTDepartamentosUP.getModel();
		modelo2.setNumRows(0);
		DepartamentoCRUD dcrud = new DepartamentoCRUD();
		
		for(Departamento d: dcrud.read()) {
			modelo2.addRow(new Object[] {
					d.getId(),
					d.getNome()
			});
		}
		
	}
	
	public void readJTableDepartamentoUpdate(){
		DefaultTableModel modelo3 = (DefaultTableModel) jTDepartamentos.getModel();
		modelo3.setNumRows(0);
		DepartamentoCRUD dcrud = new DepartamentoCRUD();
		
		for(Departamento d: dcrud.read()) {
			modelo3.addRow(new Object[] {
					d.getId(),
					d.getNome()
			});
		}
		
	}
}
