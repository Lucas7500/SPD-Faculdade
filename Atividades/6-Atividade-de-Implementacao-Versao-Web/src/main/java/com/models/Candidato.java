package com.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Candidato {
	int codigo;
	String nome;
	String sexo;
	Date data_nascimento;
	String cargo_pretendido;
	String texto_curriculo;
	
	
	
	public Candidato(int codigo, String nome, String sexo, Date data_nascimento, String cargo_pretendido,
			String texto_curriculo) {
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.data_nascimento = data_nascimento;
		this.cargo_pretendido = cargo_pretendido;
		this.texto_curriculo = texto_curriculo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getCargo_pretendido() {
		return cargo_pretendido;
	}
	public void setCargo_pretendido(String cargo_pretendido) {
		this.cargo_pretendido = cargo_pretendido;
	}
	public String getTexto_curriculo() {
		return texto_curriculo;
	}
	public void setTexto_curriculo(String texto_curriculo) {
		this.texto_curriculo = texto_curriculo;
	}

	@Override
	public String toString() {
	    return String.format(
	        "Candidato [codigo=%d, nome='%s', sexo='%s', data_nascimento=%s, cargo_pretendido='%s', texto_curriculo='%s']",
	        codigo, nome, sexo, data_nascimento, cargo_pretendido, texto_curriculo
	    );
	}
}
