package com.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.Candidato;


public class CandidatoDAO {
private Connection connection;
	
	public CandidatoDAO() throws SQLException{
		connection = FabricaDeConexao.obterConexao();
	}
	
	public void criar(Candidato candidato) {
		String sql = "INSERT INTO candidato (codigo, nome, sexo, data_nasc,cargo_pretendido,texto_curriculo) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement comando = connection.prepareStatement(sql);
			
			comando.setInt(1, candidato.getCodigo());
			comando.setString(2, candidato.getNome());
			comando.setString(3, candidato.getSexo());
			comando.setDate(4, candidato.getData_nascimento());
			comando.setString(5, candidato.getCargo_pretendido());
			comando.setString(6, candidato.getTexto_curriculo());
			comando.execute();
			
		}catch(SQLException e) {
			System.err.print("Erro ao inserir dados!");
			e.printStackTrace();
		}
	}
	
	
	public void editar(Candidato candidato) {
		String sql = "UPDATE candidato SET nome = ?, sexo = ?, data_nasc = ?,cargo_pretendido = ?,texto_curriculo = ? WHERE codigo = ?";
	
		try{
			PreparedStatement comando = connection.prepareStatement(sql);
			
			comando.setInt(6, candidato.getCodigo());
			comando.setString(1, candidato.getNome());
			comando.setString(2, candidato.getSexo());
			comando.setDate(3, candidato.getData_nascimento());
			comando.setString(4, candidato.getCargo_pretendido());
			comando.setString(5, candidato.getTexto_curriculo());
			comando.execute();
			
		}catch(SQLException e){
			System.err.print("Erro ao atualizar candidato!");
		}
	}
	
	
	public void remover(int codigo) {
		String sql = " DELETE FROM candidato Where codigo = ?";
		try {
			PreparedStatement comando = connection.prepareStatement(sql);
			
			comando.setInt(1, codigo);
			comando.execute();
			
		}catch(SQLException e) {
			System.err.print("Erro ao excluir candidato!");
		}
		
	}
	
	public List<Candidato> List(){
		List<Candidato> candidatos = new ArrayList<>();
		
String sql = "SELECT codigo,nome,sexo,data_nasc,cargo_pretendido,texto_curriculo FROM candidato";
		
		try {
			PreparedStatement instr = connection.prepareStatement(sql);
			ResultSet result = instr.executeQuery();
			while(result.next()) {
				Candidato cand =  new Candidato(result.getInt("codigo"), 
						result.getString("nome"), 
						result.getString("sexo"), 
						result.getDate("data_nasc"), 
						result.getString("cargo_pretendido"), 
						result.getString("texto_curriculo"));
				candidatos.add(cand);
			}
			
		}catch(SQLException e) {
			System.err.print("Erro ao Listar candidatos!");
		}
		return candidatos;
	}
	

	public Candidato buscar(int codigo) {
		String sql = "SELECT codigo,nome,sexo,data_nasc,cargo_pretendido,texto_curriculo FROM candidato WHERE codigo = ?";
		try {
			PreparedStatement comando = connection.prepareStatement(sql);
			comando.setInt(1, codigo);
			ResultSet result = comando.executeQuery();
			
			if(result.next()) {		
				return new Candidato(result.getInt("codigo"), 
						result.getString("nome"), 
						result.getString("sexo"), 
						result.getDate("data_nasc"), 
						result.getString("cargo_pretendido"), 
						result.getString("texto_curriculo"));
			}
			
		} catch(SQLException e) {
			System.err.println("Erro ao buscar candidato!");
		}
		
		return null;
	}
	
	public boolean existe(int codigo) {
	    String sql = "SELECT COUNT(*) FROM candidato WHERE codigo = ?";
	    
	    try {
	        PreparedStatement comando = connection.prepareStatement(sql);
	        
	        comando.setInt(1, codigo);
	        ResultSet result = comando.executeQuery();

	        if (result.next()) {
	            return result.getInt(1) > 0; 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; 
	}
}
