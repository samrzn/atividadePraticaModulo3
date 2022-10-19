package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDBmySQL;
import model.Cliente;
import model.Compra;
import model.Pacote;

public class CompraDAO {

	public void comprar(Compra compra, Cliente cliente, Pacote pacote) {
		String sql = "INSERT INTO COMPRA(DESTINO, VALOR, FK_ID_CLIENTE, FK_ID_PACOTE) VALUES(?, ?, ?, ?)";

		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setString(1, compra.getDestino());
			pdst.setDouble(2, compra.getValor());
			pdst.setInt(3, cliente.getId_cliente());
			pdst.setInt(4, pacote.getId_pacote());
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
		String sql = "SELECT * FROM COMPRA WHERE FK_ID_CLIENTE = ?";

		Compra reservas = new Compra();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setInt(1, fk_id_cliente);
			rset = pdst.executeQuery();
			rset.next();
			reservas.setId_compra(rset.getInt("ID_COMPRA"));
			reservas.setDestino(rset.getString("DESTINO"));
			reservas.setValor(rset.getDouble("VALOR"));
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
		return reservas;
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
				out.setFk_id_cliente(rset.getInt("FK_ID_CLIENTE"));
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