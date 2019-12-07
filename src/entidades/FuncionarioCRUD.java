package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioCRUD {

	
	public void inserir(Funcionario f) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "insert into usuario (cpf, nome, email, cargo, telefone, pis, id_departamento, ativo) values(?,?,?,?,?,?,?,1)";
		try (PreparedStatement pst = conn.prepareStatement(comando);) { // Executa a query do banco
			pst.setString(1, f.getCpf()); // Parametros do values
			pst.setString(2, f.getNome());
			pst.setString(3, f.getEmail());
			pst.setString(4, f.getCargo());
			pst.setString(5, f.getTelefone());
			pst.setInt(6, f.getPis());
			pst.setInt(7, f.getDepartamento());

			pst.executeUpdate();// Executa a query
			
			JOptionPane.showMessageDialog(null,
					"Funcionario cadastrado com sucesso!\n" + "Nome: " + f.getNome() + "\nCPF: " + f.getCpf() + "\nE-mail: "
							+ f.getEmail() + "\nCargo: " + f.getCargo() + "\nTelefone: " + f.getTelefone() + "\nPIS: " + f.getPis()
							+ "\nDepartamento: " + f.getDepartamento());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Funcionario f) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "update usuario set nome=?, email=?, cargo=?, telefone=?, pis=?, id_departamento=? where cpf=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {
			// Parametros do values

			pst.setString(1, f.getNome());
			pst.setString(2, f.getEmail());
			pst.setString(3, f.getCargo());
			pst.setString(4, f.getTelefone());
			pst.setInt(5, f.getPis());
			pst.setInt(6, f.getDepartamento());
			pst.setString(7, f.getCpf());
			int result = pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Funcionario Atualizado!");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public boolean validarCpf(Funcionario f) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "select cpf,nome from usuario where cpf=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setString(1, f.getCpf());

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					f.setCpf(rs.getString("cpf"));
					f.setNome(rs.getString("nome"));

					JOptionPane.showMessageDialog(null, "Funcionario Valido!");
					return true;
					
				} else {
					JOptionPane.showMessageDialog(null, "Digite um CPF Valido!");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public List<Funcionario> carregar(Funcionario f) {
		Connection conn = ConnectionFactory.getConnection();
		List<Funcionario> funcionarios = new ArrayList<>();
		String comando = "select cpf, nome, email, cargo, telefone, pis, id_departamento from usuario where ativo = 1 AND cpf=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setString(1, f.getCpf());

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					f.setCpf(rs.getString("cpf"));
					f.setNome(rs.getString("nome"));
					f.setEmail(rs.getString("email"));
					f.setCargo(rs.getString("cargo")); 
					f.setTelefone(rs.getString("telefone"));
					f.setPis(rs.getInt("pis"));
					f.setDepartamento(rs.getInt("id_departamento"));
					funcionarios.add(f);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}
	
	public List<Funcionario> read(){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM usuario WHERE ativo = 1");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo")); 
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setPis(rs.getInt("pis"));
				funcionarios.add(funcionario);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionarios;
	}

	public void delete(Funcionario f ) {
		
		Connection conn = ConnectionFactory.getConnection();
		String comando = "UPDATE usuario SET ativo = 0 WHERE cpf=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setString(1, f.getCpf());
			int result = pst.executeUpdate();

			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso!");	

			} else {
				JOptionPane.showMessageDialog(null, "Digite um CPF valido");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	

}


