package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PontoCRUD {
	
	public void registrar(Ponto p) {
		Connection conn = ConnectionFactory.getConnection();
		String comando = "select count(*) as total  from ponto where DAY(data_hora) = DAY(NOW()) AND  id_usuario = ? ";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setString(1, p.getCpf());

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					String total = rs.getString("total");
					int tipo_ponto = Integer.parseInt(total) + 1;
					if(tipo_ponto > 4) {	
						JOptionPane.showMessageDialog(null, "Todos os pontos foram inseridos hoje");
					}else {
					String comandoinserir = "insert into ponto (id_usuario, id_tipo, data_hora) values(?,?,current_timestamp)";
					try (PreparedStatement pst3 = conn.prepareStatement(comandoinserir);) { // Executa a query do banco
						pst3.setString(1, p.getCpf()); // Parametros do values
						pst3.setInt	(2, tipo_ponto);
						pst3.execute();// Executa a query
						String comandoshowponto = "select descricao from tipo_ponto where id = ? ";
						try (PreparedStatement pstt = conn.prepareStatement(comandoshowponto);) {

							pstt.setInt(1, tipo_ponto);
							
							
							try (ResultSet result = pstt.executeQuery();) {
								if (result.next()) {
									String tipo = result.getString(1);
								
									JOptionPane.showMessageDialog(null, "Ponto de "+tipo+" Inserido com Sucesso \n");
								}
							}catch (SQLException e) {
								
								e.printStackTrace();
							}
							
							
						}catch (SQLException e) {
							
							e.printStackTrace();
						}						
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
				} else {

				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ponto> read(){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Ponto> pontos = new ArrayList<>();
		
		try {
			stmt = conn.prepareStatement("SELECT tu.nome as usuario_nome, ttp.descricao as ponto_desc , DATE_FORMAT(p.data_hora,\"%d/%m/%Y %H:%i:%s\") as data_hora FROM ponto p INNER JOIN usuario tu ON tu.cpf = p.id_usuario INNER JOIN tipo_ponto ttp ON ttp.id = p.id_tipo");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Ponto ponto = new Ponto();
				ponto.setUsuario(rs.getString("usuario_nome"));
				ponto.setTipo_ponto(rs.getString("ponto_desc"));
				ponto.setData_hora(rs.getString("data_hora"));
				pontos.add(ponto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pontos;
	}

}
