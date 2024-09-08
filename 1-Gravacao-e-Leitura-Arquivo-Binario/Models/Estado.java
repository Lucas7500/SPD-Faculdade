package Models;

import java.util.HashMap;

public class Estado {
    private int codigo;
    private String sigla;
    private String nome;
    private int regiao;
    private String pais;

    private static final HashMap<Integer, String> regiaoHashMap;

    public Estado(String linha) {
        String[] dados = linha.split(",");

        this.codigo = Integer.parseInt(dados[0]);
        this.sigla = dados[1];
        this.nome = dados[2];
        this.regiao = Integer.parseInt(dados[3]);
        this.pais = dados[4];
    }

    static {
        regiaoHashMap = new HashMap<>();

        regiaoHashMap.put(1, "Norte");
        regiaoHashMap.put(2, "Nordeste");
        regiaoHashMap.put(3, "Sudeste");
        regiaoHashMap.put(4, "Sul");
        regiaoHashMap.put(5, "Centro-Oeste");
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getNome() {
        return this.nome;
    }

    public String getRegiao() {
        return regiaoHashMap.get(this.regiao);
    }

    public String getPais() {
        return this.pais;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nRegião: %s\nPaís: %s\n", this.getNome(), this.getRegiao(), this.getPais());
    }
}
