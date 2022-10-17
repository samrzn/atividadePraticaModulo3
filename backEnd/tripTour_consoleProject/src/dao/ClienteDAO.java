package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public Cliente getClienteById(String cpf) {
		String sql = "SELECT * FROM CLIENTE WHERE CPF = ?";
		
		Cliente cliente = new Cliente();
		Connection conx = null;
		PreparedStatement pdst = null;
		ResultSet rset = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setString(1, cpf);
			rset = pdst.executeQuery();
			rset.next();
			cliente.setId_cliente(rset.getInt("ID_CLIENTE"));
			cliente.setNome(rset.getString("NOME"));
			cliente.setTelefone(rset.getString("TELEFONE"));
			cliente.setEmail(rset.getString("EMAIL"));
			cliente.setCpf(rset.getString("CPF"));
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
		return cliente;
	}

	public void atualizar(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET TELEFONE = ?, EMAIL = ? WHERE ID_CLIENTE = ?";
		
		Connection conx = null;
		PreparedStatement pdst = null;
		try {
			conx = ConnectionDBmySQL.createConnectionToMySQL();
			pdst = conx.prepareStatement(sql);
			pdst.setString(1, cliente.getTelefone());
			pdst.setString(2, cliente.getEmail());
			pdst.setInt(3, cliente.getId_cliente());
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