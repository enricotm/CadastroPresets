package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConexao() {
		String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(jdbc, "rm94371", "250304");			
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
