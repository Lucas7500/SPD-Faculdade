package PesquisaArquivoJson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

import Models.Funcionario;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o cpf do funcionário: ");
        String cpf = leitor.nextLine();

        String caminhoDoArquivo = "data/" + cpf + ".json";
        File arquivo = new File(caminhoDoArquivo);

        if (!arquivo.exists()) {
            System.err.println("Não existe funcionário salvo com o cpf pesquisado!");
            return;
        }

        String funcionarioJsonString = "";

        try {
            BufferedReader leitorArquivo = new BufferedReader(new FileReader(arquivo));
            String linhaAtual = leitorArquivo.readLine();

            while (linhaAtual != null) {
                funcionarioJsonString += linhaAtual;
                linhaAtual = leitorArquivo.readLine();
            }

            leitorArquivo.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado!");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        Funcionario funcionarioPesquisado = new Gson().fromJson(funcionarioJsonString, Funcionario.class);

        System.out.println(funcionarioPesquisado);
    }
}
