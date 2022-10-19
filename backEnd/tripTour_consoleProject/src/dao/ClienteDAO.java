package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionDBmySQL;
import model.Cliente;

public class ClienteDAO {

	public void cadastrar(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE(NOME, TELEFONE, EMAIL, CPF) VALUES(?, ?, ?, ?)";

		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setString(1, cliente.getNome());
			pdst.setString(2, cliente.getTelefone());
			pdst.setString(3, cliente.getEmail());
			pdst.setString(4, cliente.getCpf());
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

	public List<Cliente> getClientes() {
		String sql = "SELECT * FROM CLIENTE";

		List<Cliente> clientes = new ArrayList<>();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			rset = pdst.executeQuery();
			while (rset.next()) {
				Cliente ct = new Cliente();
				ct.setId_cliente(rset.getInt("ID_CLIENTE"));
				ct.setNome(rset.getString("NOME"));
				ct.setTelefone(rset.getString("TELEFONE"));
				ct.setEmail(rset.getString("EMAIL"));
				ct.setCpf(rset.getString("CPF"));
				clientes.add(ct);
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
		return clientes;
	}

	public void atualizar(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET TELEFONE = ?, EMAIL = ? WHERE CPF = ?";

		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setString(1, cliente.getTelefone());
			pdst.setString(2, cliente.getEmail());
			pdst.setString(3, cliente.getCpf());
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