package PesquisaArquivoXml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import Models.Funcionario;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o cpf do funcionário: ");
        String cpf = leitor.nextLine();

        leitor.close();

        String caminhoDoArquivo = "data/" + cpf + ".xml";
        File arquivo = new File(caminhoDoArquivo);

        if (!arquivo.exists()) {
            System.err.println("Não existe funcionário salvo com o cpf pesquisado!");
            return;
        }

        String funcionarioXmlString = "";

        try {
            BufferedReader leitorArquivo = new BufferedReader(new FileReader(arquivo));
            String linhaAtual = leitorArquivo.readLine();

            while (linhaAtual != null) {
                funcionarioXmlString += linhaAtual;
                linhaAtual = leitorArquivo.readLine();
            }

            leitorArquivo.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado!");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        XStream xstream = new XStream();
        xstream.alias("funcionario", Funcionario.class);

        xstream.addPermission(AnyTypePermission.ANY);

        Funcionario funcionarioPesquisado = (Funcionario) xstream.fromXML(funcionarioXmlString);
        System.out.println(funcionarioPesquisado);
    }
}
