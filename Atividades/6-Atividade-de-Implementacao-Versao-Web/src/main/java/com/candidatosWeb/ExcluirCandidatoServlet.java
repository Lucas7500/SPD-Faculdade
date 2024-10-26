package com.candidatosWeb;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.CandidatoDAO;

@WebServlet("/ExcluirCandidato")
public class ExcluirCandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
	        doPost(req, resp);
	    } else {
	        super.service(req, resp);
	    }
	}

    public ExcluirCandidatoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        int codigo = Integer.parseInt(request.getParameter("codigo"));
	        CandidatoDAO candidatoDAO = new CandidatoDAO();
	        candidatoDAO.remover(codigo);
	        response.sendRedirect("listagem.jsp");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.sendRedirect("erro.jsp");
	    }
	}
}
