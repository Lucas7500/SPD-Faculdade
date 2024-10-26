import Models.Curso;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Pesquisar por nome (curso ou disciplina)");
            System.out.println("2. Pesquisar por ano e nome do curso");
            System.out.println("3. Mostrar todos os cursos");
            System.out.println("4. Transferir dados para o banco de dados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    pesquisarPorNome(scanner);
                    break;
                case 2:
                    pesquisarPorAnoENome(scanner);
                    break;
                case 3:
                    mostrarTodosOsCursos();
                    break;
                case 4:
                    transferirParaBancoDeDados();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }

    private static void pesquisarPorNome(Scanner scanner) {
        System.out.print("Digite o nome do curso ou da disciplina: ");
        String nomePesquisa = scanner.nextLine().toLowerCase();
        List<Curso> cursos = carregarCursosDoArquivo();

        List<Curso> cursosFiltrados = new ArrayList<>();

        for (Curso curso : cursos) {
            if (curso.getNome().toLowerCase().contains(nomePesquisa)
                    || curso.getDisciplina().toLowerCase().contains(nomePesquisa)) {
                cursosFiltrados.add(curso);
            }
        }

        if (cursosFiltrados.isEmpty()) {
            System.out.println("Nenhum curso ou disciplina encontrado.");
            return;
        }

        System.out.println("Cursos encontrados:");
        for (Curso curso : cursosFiltrados) {
            System.out.println(curso);
        }
    }

    private static void pesquisarPorAnoENome(Scanner scanner) {
        System.out.print("Digite o ano do curso: ");
        int anoPesquisa = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do curso: ");
        String nomePesquisa = scanner.nextLine().toLowerCase();

        List<Curso> cursos = carregarCursosDoArquivo();

        List<Curso> cursosFiltrados = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getAno() == anoPesquisa && curso.getNome().toLowerCase().contains(nomePesquisa)) {
                cursosFiltrados.add(curso);
            }
        }

        if (cursosFiltrados.isEmpty()) {
            System.out.println("Nenhum curso encontrado.");
            return;
        }

        System.out.println("Cursos encontrados:");
        for (Curso curso : cursosFiltrados) {
            System.out.println(curso);
        }
    }

    private static void mostrarTodosOsCursos() {
        List<Curso> cursos = carregarCursosDoArquivo();

        System.out.println("Todos os cursos:");
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }

    private static void transferirParaBancoDeDados() {
        List<Curso> cursos = carregarCursosDoArquivo();
        Set<Integer> cursosInseridosNoBanco = new HashSet<>(cursos.size());

        String url = "jdbc:mysql://localhost:3306/avaliacao1";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String queryInserirCurso = "INSERT INTO curso (iden, ano, nome) VALUES (?, ?, ?)";
            String queryInserirDisciplina = "INSERT INTO disciplina (nome, ch, iden_curso) VALUES (?, ?, ?)";

            PreparedStatement comandoInserirCurso = connection.prepareStatement(queryInserirCurso);
            PreparedStatement comandoInserirDisciplina = connection.prepareStatement(queryInserirDisciplina);

            for (Curso curso : cursos) {
                int idenOriginal = curso.getIden();

                while (cursosInseridosNoBanco.contains(idenOriginal)) {
                    idenOriginal = (int) (Math.random() * 10000) + 1;
                }

                curso.setIden(idenOriginal);

                comandoInserirCurso.setInt(1, curso.getIden());
                comandoInserirCurso.setInt(2, curso.getAno());
                comandoInserirCurso.setString(3, curso.getNome());
                comandoInserirCurso.executeUpdate();

                comandoInserirDisciplina.setString(1, curso.getDisciplina());
                comandoInserirDisciplina.setInt(2, curso.getCh());
                comandoInserirDisciplina.setInt(3, curso.getIden());
                comandoInserirDisciplina.executeUpdate();

                cursosInseridosNoBanco.add(curso.getIden());
            }

            System.out.println("Dados transferidos para o banco de dados com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static List<Curso> carregarCursosDoArquivo() {
        List<Curso> cursos = new ArrayList<>();

        try {
            File arquivo = new File("data/dados.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(arquivo);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            XPathExpression expression = xpath.compile("/universidade/curso");
            NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                String iden = xpath.compile("iden").evaluate(nodeList.item(i));
                String ano = xpath.compile("ano").evaluate(nodeList.item(i));
                String nome = xpath.compile("nome").evaluate(nodeList.item(i));
                String disciplina = xpath.compile("disciplina").evaluate(nodeList.item(i));
                String ch = xpath.compile("ch").evaluate(nodeList.item(i));

                Curso curso = new Curso();
                curso.setIden(Integer.parseInt(iden));
                curso.setAno(Integer.parseInt(ano));
                curso.setNome(nome);
                curso.setDisciplina(disciplina);
                curso.setCh(Integer.parseInt(ch));

                cursos.add(curso);
            }

        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo XML: " + e.getMessage());
        }

        return cursos;
    }
}
