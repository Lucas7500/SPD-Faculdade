package GravacaoArquivoBinario;

import java.util.List;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import Models.Estado;
import Models.Pessoa;
import Services.ServicoDeArquivoUF;
import Services.ServicoDeGravacaoDeArquivo;

public class Main {
    public static void main(String[] args) {
        Scanner leitorInput = new Scanner(System.in);

        System.out.print("Quantas pessoas serão informadas? ");
        int numPessoas = leitorInput.nextInt();
        leitorInput.nextLine(); // limpar buffer ('\n') do teclado
        
        for (int i = 1; i <= numPessoas; i++) {
            System.out.println(String.format("Digite o nome da pessoa %d:", i));
            String nome = leitorInput.nextLine();

            System.out.println(String.format("Digite a idade da pessoa %d:", i));
            int idade = leitorInput.nextInt();
            leitorInput.nextLine(); // limpar buffer ('\n') do teclado

            System.out.println(String.format("Digite a sigla do estado da pessoa %d:", i));
            String siglaEstado = leitorInput.nextLine();
            int codigoEstado = 0;

            try {
                List<Estado> estados = ServicoDeArquivoUF.obterEstadosPorSigla(siglaEstado);

                if (estados.size() > 1) {
                    String paises = "";

                    for (int indexEstadoAtual = 0; indexEstadoAtual < estados.size(); indexEstadoAtual++) {
                        paises += estados.get(indexEstadoAtual).getPais();

                        if (indexEstadoAtual + 1 == estados.size()) {
                            break;
                        }

                        paises += " ou ";
                    }

                    System.out.println(String.format("A qual país você se refere? (%s)", paises));
                    String paisSelecionado = leitorInput.nextLine();

                    for (Estado estado : estados) {
                        if (estado.getPais().equalsIgnoreCase(paisSelecionado)) {
                            codigoEstado = estado.getCodigo();
                        }
                    }
                } else {
                    codigoEstado = estados.get(0).getCodigo();
                }

            } catch (NameNotFoundException e) {
                System.err.println(e.getMessage());
            }

            System.out.println(String.format("Digite o salário da pessoa %d:", i));
            double salario = leitorInput.nextDouble();
            leitorInput.nextLine(); // limpar buffer ('\n') do teclado

            Pessoa pessoa = new Pessoa(nome, idade, codigoEstado, salario);
            ServicoDeGravacaoDeArquivo.gravarPessoa(pessoa);
        }

        leitorInput.close();
    }
}
