package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDBmySQL;
import model.Pacote;

public class PacoteDAO {

	public List<Pacote> getPacote() {
		String sql = "SELECT * FROM PACOTE";
		
		List<Pacote> destinos = new ArrayList<>();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			rset = pdst.executeQuery();
			while (rset.next()) {
				Pacote p = new Pacote();
				p.setId_pacote(rset.getInt("ID_PACOTE"));
				p.setDestino(rset.getString("DESTINO"));
				p.setValor(rset.getDouble("VALOR"));
				p.setData_viagem(rset.getString("DATA_VIAGEM"));
				destinos.add(p);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pdst != null)
					pdst.close();
				if (conx != null)
					conx.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return destinos;
	}

	public Pacote getPacoteById(int id_pacote) {
		String sql = "SELECT * FROM PACOTE WHERE ID_PACOTE = ?";
		
		Pacote destino = new Pacote();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setInt(1, id_pacote);
			rset = pdst.executeQuery();
			rset.next();
			destino.setId_pacote(rset.getInt("ID_PACOTE"));
			destino.setDestino(rset.getString("DESTINO"));
			destino.setValor(rset.getDouble("VALOR"));
			destino.setData_viagem(rset.getString("DATA_VIAGEM"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pdst != null) {
					pdst.close();
				}
				if (conx != null) {
					conx.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;
	}
}