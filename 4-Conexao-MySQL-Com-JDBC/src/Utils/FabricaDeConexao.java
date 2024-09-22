package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
    private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/minhabase";
    
    private static final String usuario = "root";
    private static final String senha = "root";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(connectionString, usuario, senha);
    }
}