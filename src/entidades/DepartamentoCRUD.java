package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DepartamentoCRUD {
	
	public boolean inserirDepartamento(Departamento d ) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "insert into departamento (id, nome, descricao,ativo) values(?,?,?,1)";
		try (PreparedStatement pst = conn.prepareStatement(comando);) { // Executa a query do banco
			pst.setInt(1, d.getId()); // Parametros do values
			pst.setString(2, d.getNome());
			pst.setString(3, d.getDescricao());

			pst.execute();// Executa a query

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean atualizar(Departamento d ) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "update departamento set id=?, nome=?, descricao=? where id=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {
			// Parametros do values
			
			
			pst.setInt(1, d.getId());
			pst.setString(2, d.getNome());
			pst.setString(3, d.getDescricao());
			pst.setInt(4, d.getId());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return true;
	}
	
	public boolean validarCod(Departamento d) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "select id from departamento where id=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setInt(1, d.getId());

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					d.setId(rs.getInt("id"));

					JOptionPane.showMessageDialog(null, "Código Valido!");
					return true;
					
				} else {
					JOptionPane.showMessageDialog(null, "Digite um Código Valido!");
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

	public void deleteDepartamento(Departamento d) {
		Connection conn = ConnectionFactory.getConnection();
		String delete = "delete from departamento where id=?";
		try (PreparedStatement pst = conn.prepareStatement(delete);) {

			pst.setInt(1, d.getId());
			int result = pst.executeUpdate();

			if (result > 0) {
				JOptionPane.showMessageDialog(null, "Departamento excluido com sucesso!");

			} else {
				JOptionPane.showMessageDialog(null, "Digite um Id valido");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
	public List<Departamento> carregar(Departamento d) {
		Connection conn = ConnectionFactory.getConnection();
		List<Departamento> departamentos = new ArrayList<>();
		String comando = "SELECT * FROM departamento WHERE id = ? AND ativo = 1";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setInt(1, d.getId());

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					d.setId(rs.getInt("id"));
					d.setNome(rs.getString("nome"));
					d.setDescricao(rs.getString("descricao"));

					departamentos.add(d);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departamentos;
	}
	
	
	public List<Departamento> read(){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Departamento> departamentos = new ArrayList<>();
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM departamento WHERE ativo = 1");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt("id"));
				departamento.setNome(rs.getString("nome"));
				departamento.setDescricao(rs.getString("descricao"));
				
				departamentos.add(departamento);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departamentos;
	}

}
