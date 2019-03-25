package br.com.javaee7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para o form.jsp
 * 
 * @author gustavo
 *
 */
@WebServlet(urlPatterns = "/SaveInfo")
public class SaveInfoServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8716369227060228564L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");
		String peso = req.getParameter("peso");
		
		// envia para a jsp passando os parametros recebidos no formulario
		resp.sendRedirect("jsp_redirect.jsp?nome=" + nome + "&idade=" + idade + "&peso=" + peso);
	}
}
