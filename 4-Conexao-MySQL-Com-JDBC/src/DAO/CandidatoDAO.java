package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Candidato;
import Utils.FabricaDeConexao;

public class CandidatoDAO {
    private final Connection connection;

    public CandidatoDAO() throws SQLException {
        connection = FabricaDeConexao.obterConexao();
    }

    public void criar(Candidato candidato) {
        String sql = "INSERT INTO Candidato(nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = connection.prepareStatement(sql);

            comando.setString(1, candidato.getNome());
            comando.setString(2, String.valueOf(candidato.getSexo()));
            comando.setDate(3, candidato.getDataNasc());
            comando.setString(4, candidato.getCargoPretendido());
            comando.setString(5, candidato.getTextoCurriculo());

            comando.executeUpdate();
        } catch (Exception e) {
            System.err.println("Erro durante a inserção de dados: " + e.getMessage());
        }
    }

    public Candidato buscar(int codigo) {
        String sql = "SELECT * FROM Candidato WHERE codigo = ?";
        Candidato candidato = null;

        try {
            PreparedStatement comando = connection.prepareStatement(sql);
            comando.setInt(1, codigo);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                String nome = resultado.getString("nome");
                char sexo = resultado.getString("sexo").charAt(0); // Lê como char
                Date dataNasc = resultado.getDate("data_nasc");
                String cargoPretendido = resultado.getString("cargo_pretendido");
                String textoCurriculo = resultado.getString("texto_curriculo");

                candidato = new Candidato(nome, sexo, dataNasc, cargoPretendido, textoCurriculo);
            }
        } catch (Exception e) {
            System.err.println("Erro durante a busca de dados: " + e.getMessage());
        }

        return candidato;
    }
}
