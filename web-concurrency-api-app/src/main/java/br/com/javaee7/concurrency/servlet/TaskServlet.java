package br.com.javaee7.concurrency.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaee7.concurrency.runner.ConcurrencyApiRunner;

/**
 * Dispara as threads a partir de uma simples requisicao get 
 * 
 * @author gustavo
 *
 */
@WebServlet("/task")
public class TaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// ConcurrencyApiRunner c = new ConcurrencyApiRunner(); // nao injeta o @Resource

	// @Inject caso falhe lança erro no deploy, ja o @Resource fica null apenas
	@Inject
	private ConcurrencyApiRunner c;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			c.runTasks();
			response.getWriter().append("Threads finalizadas... verifique o console...");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			response.getWriter().append("Erro ao iniciar as Threads... verique o console !!!");
		}
	}
}
