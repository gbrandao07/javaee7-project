package br.com.javaee7.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaee7.ejb.FormProcessorBean;

@WebServlet(urlPatterns = "/FormServlet")
public class FormServlet extends HttpServlet {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3810797242195480197L;
	
	@EJB
	private FormProcessorBean formProcessorBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = resp.getWriter()) {

			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>Formulario</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<br>");
			out.println("		<div align='center'>");
			out.println("			<h2>Ola para voce</h2>");
			out.println("			<p>Entre com uma mensagem que sera processada por um EJB e exibida novamente com uma resposta do EJB</p>");
			out.println("			<br><br><br>");
			out.println("			<form action='./FormServlet' method='POST'>");
			out.println("				<input type='submit' value='Enter'>");
			out.println("				<input type='text' name='requestText'> ");
			out.println("			</form>");
			out.println("			<br>");
			out.println("		</div>");
			out.println("	</body>");
			out.println("</html>");
		}
		
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String requestText = req.getParameter("requestText");
		
		String responseText;
		try {
			responseText = formProcessorBean.processRequest(requestText);
		} catch (Exception e) {
			responseText = e.getMessage();
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = resp.getWriter()) {

			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>Resposta do Formulario</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<div align='center'>");
			out.println("			<h2>" + responseText + "</h2>");
			out.println("		</div>");
			out.println("	</body>");
			out.println("</html>");
		}
		
		super.doPost(req, resp);
	}
}
