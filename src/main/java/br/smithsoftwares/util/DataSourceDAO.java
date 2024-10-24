package br.smithsoftwares.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceDAO {
	
	public DataSourceDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n#### Driver carregado com sucesso!\n");
		} catch (ClassNotFoundException e) {
			System.out.println("\n#### Erro ao carregar o Driver!\n");
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/backend_java";
		Connection conn = DriverManager.getConnection(url, "root", "Cacau123@#");
		return conn;
	}
	
}

