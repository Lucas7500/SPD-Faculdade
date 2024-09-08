package Models;

import java.util.List;

public class Funcionario {
    private String cpf;
    private String nome;
    private int idade;
    private double salario;
    private String cargo;
    private List<String> habilidades;

    public Funcionario(String cpf, String nome, int idade, double salario, String cargo, List<String> habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
        this.habilidades = habilidades;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        String habilidades = "\n";

        for (String habilidadeAtual : this.habilidades) {
            habilidades += habilidadeAtual + '\n';  
        }

        return String.format("cpf: %s\nnome: %s\nidade: %d\nsalario: %f\ncargo: %s\nhabilidades: %s",
            this.cpf, this.nome, this.idade, this.salario, this.cargo, habilidades);
    }
}
