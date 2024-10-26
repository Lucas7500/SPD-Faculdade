package com.candidatosWeb;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.CandidatoDAO;
import com.models.Candidato;

@WebServlet("/Cadastro")
public class CadastroCandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastroCandidatoServlet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
	        doPost(req, resp);
	    } else {
	        super.service(req, resp);
	    }
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        int codigo = Integer.parseInt(request.getParameter("codigo"));
	        String nome = request.getParameter("nome");
	        String sexo = request.getParameter("sexo");
	        Date dataNascimento = Date.valueOf(request.getParameter("data_nascimento"));
	        String cargoPretendido = request.getParameter("cargo_pretendido");
	        String textoCurriculo = request.getParameter("texto_curriculo");
	        
	        Candidato candidato = new Candidato(codigo, nome, sexo, dataNascimento, cargoPretendido, textoCurriculo);
	        
	        CandidatoDAO candidatoDAO = new CandidatoDAO();
	        
	        if (candidatoDAO.existe(codigo)) { 
	            candidatoDAO.editar(candidato);
	        } else { 
	            candidatoDAO.criar(candidato);
	        }
	        
	        response.sendRedirect("listagem.jsp");

	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.sendRedirect("erro.jsp");
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        response.sendRedirect("erro.jsp");
	    }
	}
}
