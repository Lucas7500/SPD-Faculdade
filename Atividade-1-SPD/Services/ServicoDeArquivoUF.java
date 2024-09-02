package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.NameNotFoundException;

import Models.Estado;

public final class ServicoDeArquivoUF {
    private static final String nomeArquivo = "UF.csv";
    private static final HashMap<String, List<Estado>> estadoHashMap = new HashMap<String, List<Estado>>();
    
    static {
        try {
            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader leitorArquivo = new BufferedReader(arquivo);

            String linhaAtual = leitorArquivo.readLine();

            while (linhaAtual != null) {
                Estado estadoAtual = new Estado(linhaAtual);
                String siglaEstadoAtual = estadoAtual.getSigla();

                if (estadoHashMap.get(siglaEstadoAtual) == null) {
                    estadoHashMap.put(siglaEstadoAtual, new ArrayList<Estado>());
                }

                estadoHashMap.get(siglaEstadoAtual).add(estadoAtual);

                linhaAtual = leitorArquivo.readLine();
            }

            arquivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static List<Estado> obterEstadosPorSigla(String siglaEstado) throws NameNotFoundException {
        List<Estado> estados = estadoHashMap.get(siglaEstado.toUpperCase());

        if (estados == null) {
            throw new NameNotFoundException("A sigla de estado informada não consta no arquivo texto!");
        }

        return estados;
    }
}
