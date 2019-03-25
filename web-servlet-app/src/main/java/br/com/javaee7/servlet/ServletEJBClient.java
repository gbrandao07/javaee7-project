package br.com.javaee7.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaee7.ejb.HelloEJB;

/**
 * Servlet implementation class ServletEJBClient
 */
@WebServlet(urlPatterns = "/EjbClient")
public class ServletEJBClient extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	HelloEJB helloEJB;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		response.getWriter().append(helloEJB.sayHello(name));
	}
}
