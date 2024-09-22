package Models;

import java.sql.Date;

public class Candidato {
    private int codigo;
    private String nome;
    private char sexo;
    private Date dataNasc;
    private String cargoPretendido;
    private String textoCurriculo;

    public Candidato(String nome, char sexo, Date dataNasc, String cargoPretendido, String textoCurriculo) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.cargoPretendido = cargoPretendido;
        this.textoCurriculo = textoCurriculo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCargoPretendido() {
        return cargoPretendido;
    }

    public void setCargoPretendido(String cargoPretendido) {
        this.cargoPretendido = cargoPretendido;
    }

    public String getTextoCurriculo() {
        return textoCurriculo;
    }

    public void setTextoCurriculo(String textoCurriculo) {
        this.textoCurriculo = textoCurriculo;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataNasc=" + dataNasc +
                ", cargoPretendido='" + cargoPretendido + '\'' +
                ", textoCurriculo='" + textoCurriculo + '\'' +
                '}';
    }
}
