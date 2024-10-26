<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro Candidato</title>
</head>
<body>
    <h2>Cadastro Candidato</h2>
    
    <form action="CadastroServlet" method="post">
    	<label for="codigo">Codigo :</label>&nbsp;&nbsp;
        <input type="text" name="codigo" id="codigo" value="<%= request.getParameter("codigo") != null ? request.getParameter("codigo") : "" %>"required><br><br>
        
        <label for="nome">Nome :</label>&nbsp;&nbsp;
        <input type="text" name="nome" id="nome" value="<%= request.getParameter("nome") != null ? request.getParameter("nome") : "" %>" required><br><br>
        
        <label for="sexo">Sexo :</label>&nbsp;&nbsp;
        <input type="text" name="sexo" id="sexo" value="<%= request.getParameter("sexo") != null ? request.getParameter("sexo") : "" %>" required><br><br>
        
        <label for="data_nascimento">Data de Nascimento:</label>&nbsp;
        <input type="date" name="data_nascimento" id="data_nascimento" value="<%= request.getParameter("data_nascimento") != null ? request.getParameter("data_nascimento") : "" %>" required><br><br>
        
        <label for="cargo_pretendido">Cargo Pretendido:</label>&nbsp;
        <input type="text" name="cargo_pretendido" id="cargo_pretendido" value="<%= request.getParameter("cargo_pretendido") != null ? request.getParameter("cargo_pretendido") : "" %>" required><br><br>
        
        <label for="texto_curriculo">Texto do Currículo:</label>&nbsp;&nbsp;
        <textarea name="texto_curriculo" id="texto_curriculo" required><%= request.getParameter("texto_curriculo") != null ? request.getParameter("texto_curriculo") : "" %></textarea><br>
        
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
