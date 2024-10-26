package Models;

public class Curso {
    private int iden;
    private int ano;
    private String disciplina;
    private String nome;
    private int ch;

    public int getIden() {
        return iden;
    }

    public int getAno() {
        return ano;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getNome() {
        return nome;
    }

    public int getCh() {
        return ch;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return String.format("Curso {iden='%d', ano='%d', disciplina='%s', nome='%s', ch='%d'}", 
            this.iden, this.ano, this.disciplina, this.nome, this.ch); 
    }
}