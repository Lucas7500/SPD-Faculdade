package PesquisaArquivoTexto;

import java.util.List;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

import Models.Estado;
import Services.ServicoDeArquivoUF;

public class Main {
    public static void main(String[] args) {
        Scanner leitorInput = new Scanner(System.in);

        System.out.print("Informe o Estado que você deseja pesquisar: ");
        String siglaEstado = leitorInput.nextLine();

        leitorInput.close();

        try {
            List<Estado> estados = ServicoDeArquivoUF.obterEstadosPorSigla(siglaEstado);

            for (Estado estado : estados) {
                System.out.println(estado);
            }
        } catch (NameNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
