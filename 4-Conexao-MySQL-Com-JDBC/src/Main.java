import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.CandidatoDAO;
import Models.Candidato;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Registrar um novo candidato");
        System.out.println("2 - Ler um registro de candidato");
        
        int opcao;

        do {
            opcao = leitor.nextInt();
            leitor.nextLine(); // limpar o buffer ('\n') do teclado
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1) {
            System.out.print("Digite o nome do candidato: ");
            String nome = leitor.nextLine();

            System.out.print("Digite o sexo do candidato (M/F): ");
            char sexo = leitor.nextLine().charAt(0);

            System.out.print("Digite a data de nascimento (YYYY-MM-DD): ");
            Date dataNasc = Date.valueOf(leitor.nextLine());

            System.out.print("Digite o cargo pretendido: ");
            String cargoPretendido = leitor.nextLine();

            System.out.print("Digite o texto do currículo: ");
            String textoCurriculo = leitor.nextLine();

            leitor.close();

            Candidato candidato = new Candidato(nome, sexo, dataNasc, cargoPretendido, textoCurriculo);

            new CandidatoDAO().criar(candidato);
            System.out.println("Candidato criado com sucesso!");
            return;
        } 
        
        if (opcao == 2) {
            System.out.print("Digite o código do candidato que deseja ler: ");
            int codigo = leitor.nextInt();

            leitor.close();

            Candidato candidato = new CandidatoDAO().buscar(codigo);

            if (candidato == null) {
                System.out.println("Candidato com o código " + codigo + " não encontrado!");
            }

            System.out.println("Dados do candidato:");
            System.out.println(candidato);
        }

    }
}

