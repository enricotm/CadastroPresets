package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bo.PresetBO;
import br.com.fiap.model.Preset;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PresetBO bo = new PresetBO();
		String nome = request.getParameter("nome");
		String body = request.getParameter("body");
		String cor = request.getParameter("cor").equals("none") ? null : request.getParameter("cor");
		String decal = request.getParameter("decal").equals("none") ? null : request.getParameter("decal");
		String roda = request.getParameter("roda");
		String boost = request.getParameter("boost");
		
		try {			
			Preset p = new Preset();
			p.setNome(nome);
			p.setBody(body);
			p.setCor(cor);
			p.setDecal(decal);
			p.setRoda(roda);
			p.setBoost(boost);
			System.out.println(p.toString());
			boolean sent = bo.cadastrar(p);
			
			if (sent)
				request.setAttribute("popup", 0);
			else
				request.setAttribute("popup", 1);
			request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
