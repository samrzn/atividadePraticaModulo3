package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDBmySQL;
import model.Compra;
import model.Pacote;

public class CompraDAO {

	public void comprar(Compra compra) {
		String sql = "INSERT INTO COMPRA(DESTINO, VALOR, FK_ID_CLIENTE, FK_ID_PACOTE) VALUES(?, ?, ?, ?)";

		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setString(1, compra.getDestino());
			pdst.setDouble(2, compra.getValor());
			pdst.setInt(3, compra.getId_cliente());
			pdst.setInt(4, compra.getId_pacote());
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
	
	public List<Compra> getCompras() {
		String sql = "SELECT * FROM COMPRA";
		
		List<Compra> compras = new ArrayList<>();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			rset = pdst.executeQuery();
			while (rset.next()) {
				Compra ccp = new Compra();
				ccp.setId_compra(rset.getInt("ID_COMPRA"));
				ccp.setDestino(rset.getString("DESTINO"));
				ccp.setValor(rset.getDouble("VALOR"));
				ccp.setId_cliente(rset.getInt("FK_ID_CLIENTE"));
				ccp.setId_pacote(rset.getInt("FK_ID_PACOTE"));
				compras.add(ccp);
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
		return compras;
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
	
	public List<Compra> getCompra() {
		String sql = "SELECT * FROM COMPRA ORDER BY ID_COMPRA DESC LIMIT 1";
		
		List<Compra> checkout = new ArrayList<>();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			rset = pdst.executeQuery();
			while (rset.next()) {
				Compra out = new Compra();
				out.setId_compra(rset.getInt("ID_COMPRA"));
				out.setDestino(rset.getString("DESTINO"));
				out.setValor(rset.getDouble("VALOR"));
				out.setId_cliente(rset.getInt("FK_ID_CLIENTE"));
				checkout.add(out);
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
		return checkout;
	}
	
	public void cancelByLastId(int id_compra) {
		String sql = "DELETE FROM COMPRA ORDER BY ID_COMPRA DESC LIMIT 1";
		
		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
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
	
}