package br.com.javaee7.webfilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Exemplo de web filter (intercepta todas as requisicoes http ao servidor)
 * @author gustavo
 *
 */
@WebFilter(filterName = "UpperCase", urlPatterns = "*.xhtml")
public class MWebFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * Baseado um parametro na url, exibe na pagina se o filtro teve efeito na requisicao ou nao.
	 * Nesse exemplo, o filtro muda o writer padrao para escrever sempre em maisculo (@see {@link UppercaseResponse}
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// http://localhost:8180/javaee7-c8-war-1.0.0-SNAPSHOT/index.xhtml?shouldApplyFilter=<true ou false>
		
		Boolean shouldApplyFilter = Boolean.valueOf(request.getParameter("shouldApplyFilter"));
		
		PrintWriter writer = new PrintWriter(response.getWriter());
		if (shouldApplyFilter) {
			writer.println("<div align=\"center\"><h1>The page is filtered for YOU !!!" + "</h1></div>");
			
			try {
				// cria um response wrapper, customizando o comportamento do write
				UppercaseResponse uResponse = new UppercaseResponse((HttpServletResponse) response);
				
				// chama o proximo filter, no caso o proprio webcomponent em questao
				chain.doFilter(request, uResponse);
			} catch (Throwable t) {
				throw new ServletException("Error during filtering: " + t.getMessage());
			}
			
		} else {
			writer.println("<div align=\"center\"><h1>The page is NOT filtered for YOU !!!" + "</h1></div>");
			
			// chama o proximo filter, no caso o proprio webcomponent em questao, porem sem manipular o request ou response
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}



