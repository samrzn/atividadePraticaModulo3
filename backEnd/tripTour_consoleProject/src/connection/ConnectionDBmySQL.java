package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDBmySQL {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "m3lo0698Dram4*";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/triptour";
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conn;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando teste ConnectionFactory.");
		Connection conx = createConnectionToMySQL();
		if (conx != null) {
			System.out.println("Conexão estabelecida!");
			Statement st = conx.createStatement();
			ResultSet resu = st.executeQuery("SELECT * FROM pacote");
			System.out.println("Exibindo destinos de 'pacote': destino -> valor.");
			while (resu.next()) {
				System.out.println(resu.getString("DESTINO") + " -> " + resu.getDouble("VALOR"));
			}
			st.close();
			conx.close();
			System.out.println("Fim da conexão.");
		}
	}
}