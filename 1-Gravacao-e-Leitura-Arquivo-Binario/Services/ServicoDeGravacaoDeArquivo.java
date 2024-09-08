package Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Models.Pessoa;

public final class ServicoDeGravacaoDeArquivo {
    private static final String nomeArquivo = "pessoas.dat";

    public static void gravarPessoa(Pessoa pessoa) {
        File arquivo = new File(nomeArquivo);

        try {
            List<Pessoa> pessoas = new ArrayList<Pessoa>();

            if (arquivo.exists()) {
                pessoas = obterPessoasSalvas();
            }

            pessoas.add(pessoa);

            FileOutputStream arquivoStream = new FileOutputStream(arquivo);
            ObjectOutputStream escritorArquivo = new ObjectOutputStream(arquivoStream);
            
            escritorArquivo.writeObject(pessoas);
            escritorArquivo.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static List<Pessoa> obterPessoasSalvas() {
        List<Pessoa> pessoasSalvas = new ArrayList<Pessoa>();

        try {
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream leitorArquivo = new ObjectInputStream(arquivo);
            pessoasSalvas = (ArrayList<Pessoa>) leitorArquivo.readObject();

            leitorArquivo.close();
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return pessoasSalvas;
    }
}
