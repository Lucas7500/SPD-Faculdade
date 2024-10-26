package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(name = "dt_nasc", nullable = false)
    private Date dtNasc;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Sexo sexo;

    @Column(nullable = false, length = 60)
    private String logradouro;

    private Integer numero;

    @Column(length = 40)
    private String setor;

    @Column(length = 40)
    private String cidade;

    @Column(length = 25)
    private String uf;

    public enum Sexo {
        Masculino,
        Feminino
    }

    public Usuario() {}

    public Usuario(String nome, Date dtNasc, Sexo sexo, String logradouro, Integer numero, String setor, String cidade, String uf) {
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.setor = setor;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dtNasc=" + dtNasc +
                ", sexo=" + sexo +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", setor='" + setor + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

}