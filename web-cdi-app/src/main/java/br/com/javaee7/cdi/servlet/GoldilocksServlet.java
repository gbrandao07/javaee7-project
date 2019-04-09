package br.com.javaee7.cdi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaee7.cdi.bean.Bed;
import br.com.javaee7.cdi.bean.qualifier.Comfort;

/**
 * Servlet para testar a injecao de dependencias com CDI. Utiliza injecao com e sem qualifiers.
 * 
 * "
 *  In this example, we retell the traditional children’s story in which the little girl Goldilocks finds a
 *  house that belongs to three bears and tries various things in it, including the beds. 
 * "
 * 
 * @author gustavo
 *
 */
@WebServlet(name = "GoldilocksServlet", urlPatterns = { "/GoldilocksServlet" })
public class GoldilocksServlet extends HttpServlet {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Bed bed3;
	
	@Inject
	@Comfort("firm")
	private Bed bed1;

	private Bed bed2;

	@Inject
	public void initializeBed(@Comfort("yielding") Bed bean) {
		this.bed2 = bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Goldilocks and the CDI beans</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div align='center'>");
			out.println("<h2>Hello Servlet using three CDI beans</h2>");
			out.println("<img width = '80' height='80' src='Goldilocks.jpg'></img>");
			out.println("<p>");
			out.println("Goldilocks tried the first bed, but it was " + bed1.tryIt() + ".<br><br>");
			out.println("Goldilocks tried the second bed, but it was " + bed2.tryIt() + ".<br><br>");
			out.println("Goldilocks tried the third bed, and it was " + bed3.tryIt() + ".<br><br>");
			out.println("</p>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}