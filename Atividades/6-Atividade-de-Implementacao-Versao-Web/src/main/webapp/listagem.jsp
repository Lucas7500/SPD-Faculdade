<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.models.Candidato" %>
<%@ page import="com.factory.CandidatoDAO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Listagem de Candidatos</title>
</head>
<body>
	<ul>
		<li><a href = "index.jsp"> Menu Principal</a></li>
	</ul>
    <h2>Lista de Candidatos</h2>
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Sexo</th>
            <th>Data de Nascimento</th>
            <th>Cargo Pretendido</th>
            <th>Texto do Currículo</th>
        </tr>

        <%
            CandidatoDAO candidatoDAO = new CandidatoDAO();
            List<Candidato> candidatos = candidatoDAO.List();
            for(Candidato candidato : candidatos) {
        %>
        <tr>
            <td><%= candidato.getCodigo() %></td>
            <td><%= candidato.getNome() %></td>
            <td><%= candidato.getSexo() %></td>
            <td><%= candidato.getData_nascimento() %></td>
            <td><%= candidato.getCargo_pretendido() %></td>
            <td><%= candidato.getTexto_curriculo() %></td>
            <td>
                <a href="incluirCandidato.jsp?codigo=<%= candidato.getCodigo() %>&nome=<%= candidato.getNome() %>&sexo=<%= candidato.getSexo() %>&data_nascimento=<%= candidato.getData_nascimento() %>&cargo_pretendido=<%= candidato.getCargo_pretendido() %>&texto_curriculo=<%= candidato.getTexto_curriculo() %>">Editar</a>
                <form action="ExcluirCandidatoServlet" method="post" style="display:inline;">
                    <input type="hidden" name="codigo" value="<%= candidato.getCodigo() %>">
                    <input type="submit" value="Excluir">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>