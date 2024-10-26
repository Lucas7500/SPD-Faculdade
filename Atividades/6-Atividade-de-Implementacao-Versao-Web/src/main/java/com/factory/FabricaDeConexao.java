package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	private static String usuario = "root";
	private static String senha = "root";
	private static String connectionString = "jdbc:mysql://127.0.0.1:3306/minhabase";

	 public static Connection obterConexao() throws SQLException{
			return DriverManager.getConnection(connectionString, usuario, senha);
	}
}
