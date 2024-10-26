import DAO.UsuarioDAO;
import entities.Usuario;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final UsuarioDAO UsuarioDAOImpl = new UsuarioDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Consulta por ID");
            System.out.println("2 - Inserção");
            System.out.println("3 - Exclusão");
            System.out.println("4 - Listar todos os usuários");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> consultarPorId();
                case 2 -> inserirUsuario();
                case 3 -> excluirUsuario();
                case 4 -> listarTodos();
                case 5 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void consultarPorId() {
        System.out.print("Digite o ID do usuário: ");
        Long id = scanner.nextLong();
        Usuario usuario = UsuarioDAOImpl.obterPorId(id);

        if (usuario != null) {
            System.out.println("Usuário encontrado: " + usuario);
            return;
        }

        System.out.println("Usuário não encontrado.");
    }

    private static void inserirUsuario() {
        scanner.nextLine(); // limpar buffer
        Usuario usuario = new Usuario();

        System.out.print("Nome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        usuario.setDtNasc(Date.valueOf(scanner.nextLine()));

        System.out.print("Sexo (MASCULINO/FEMININO): ");
        usuario.setSexo(Usuario.Sexo.valueOf(scanner.nextLine().trim().toUpperCase()));

        System.out.print("Logradouro: ");
        usuario.setLogradouro(scanner.nextLine());

        System.out.print("Número (opcional): ");
        String numeroStr = scanner.nextLine();
        usuario.setNumero(numeroStr.isEmpty() ? null : Integer.parseInt(numeroStr));

        System.out.print("Setor: ");
        usuario.setSetor(scanner.nextLine());

        System.out.print("Cidade: ");
        usuario.setCidade(scanner.nextLine());

        System.out.print("UF: ");
        usuario.setUf(scanner.nextLine());

        UsuarioDAOImpl.criar(usuario);
        System.out.println("Usuário inserido com sucesso!");
    }

    private static void excluirUsuario() {
        System.out.print("Digite o ID do usuário para excluir: ");
        Long id = scanner.nextLong();
        UsuarioDAOImpl.deletar(id);
        System.out.println("Usuário excluído com sucesso!");
    }

    private static void listarTodos() {
        List<Usuario> usuarios = UsuarioDAOImpl.obterTodos();

        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
            return;
        }

        usuarios.forEach(System.out::println);
    }
}
