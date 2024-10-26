package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String usuario = "root";
	private static String senha = "Louis3377!";
	private static String textoDeconexao = "jdbc:mysql://127.0.0.1:3306/cadastro_candid";
	
	 static {
	        try {
	            // Registrar o driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException("Erro ao registrar o driver JDBC", e);
	        }
	   }

	 public static Connection obterConexao() throws SQLException{
			Connection con = DriverManager.getConnection(textoDeconexao,usuario,senha);
			
			return con;
	}
}
