package GravacaoArquivoJson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import Models.Funcionario;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o CPF do funcionário: ");
        String cpf = leitor.nextLine();

        System.out.print("Digite o nome do funcionário: ");
        String nome = leitor.nextLine();

        System.out.print("Digite a idade do funcionário: ");
        int idade = leitor.nextInt();

        System.out.print("Digite o salário do funcionário: ");
        double salario = leitor.nextDouble();

        leitor.nextLine(); // Para limpar o buffer do teclado ('\n') após a leitura do double

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = leitor.nextLine();

        System.out.println("Digite as habilidades do funcionário (digite 'fim' para encerrar):");
        List<String> habilidades = new ArrayList<>();
        
        while (true) {
            String habilidade = leitor.nextLine();
            
            if (habilidade.equalsIgnoreCase("fim")) {
                break;
            }

            habilidades.add(habilidade);
        }

        Funcionario funcionario = new Funcionario(cpf, nome, idade, salario, cargo, habilidades);

        String caminhoDoArquivo = "data/" + funcionario.getCpf() + ".json";
        File arquivo = new File(caminhoDoArquivo);
        
        try {
            FileOutputStream arquivoStream = new FileOutputStream(arquivo);
            OutputStreamWriter escritor = new OutputStreamWriter(arquivoStream);

            escritor.write(new Gson().toJson(funcionario));

            escritor.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado!");;
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}