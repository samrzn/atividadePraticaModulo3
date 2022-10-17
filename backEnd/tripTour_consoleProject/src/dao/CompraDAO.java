package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectionDBmySQL;
import model.Compra;
import model.Pacote;

public class CompraDAO {

	public void comprar(Compra compra) {
		String sql = "INSERT INTO COMPRA(DESTINO, VALOR, FK_ID_CLIENTE, FK_ID_PACOTE) (SELECT DESTINO, VALOR, ID_PACOTE FROM PACOTE WHERE ID_PACOTE = ?)";

		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setInt(1, compra.getId_pacote());
			pdst.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pdst != null)
					pdst.close();
				if (conx != null)
					conx.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void deleteById(int id_compra) {
		String sql = "DELETE FROM COMPRA WHERE ID_COMPRA = ?";

		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setInt(1, id_compra);
			pdst.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pdst != null)
					pdst.close();
				if (conx != null)
					conx.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public Compra getCompraById(int fk_id_cliente) {
		String sql = "";
		
		Compra vendas = new Compra();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setInt(1, fk_id_cliente);
			rset = pdst.executeQuery();
			rset.next();
			vendas.setId_compra(rset.getInt("ID_COMPRA"));
			vendas.setDestino(rset.getString("DESTINO"));
			vendas.setValor(rset.getDouble("VALOR"));
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