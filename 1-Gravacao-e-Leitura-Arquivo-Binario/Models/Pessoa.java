package Models;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private int idade;
    private int codigoEstado;
    private double salario;

    public Pessoa(String nome, int idade, int codigoEstado, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.codigoEstado = codigoEstado;
        this.salario = salario;
    }
}
