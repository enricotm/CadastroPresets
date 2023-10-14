package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bo.PresetBO;
import br.com.fiap.model.Preset;

/**
 * Servlet implementation class Consulta
 */
@WebServlet("/consulta")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PresetBO bo = new PresetBO();
		
		try {				
			Preset p = bo.consultaNome(request.getParameter("nome"));
			
			request.getRequestDispatcher(
				"consulta.jsp?"
				+ "nome=" + p.getNome()
			    + "&body=" + p.getBody()
				+ "&cor=" + p.getCor()
				+ "&decal=" + p.getDecal()
				+ "&roda=" + p.getRoda()
				+ "&boost=" + p.getBoost())
			.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
