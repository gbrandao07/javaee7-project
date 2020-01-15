package br.com.javaee7.jms.servlet.message;

import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para disparar o envio de mensagens a queue "myQueue"
 * 
 * @author gustavo
 *
 */
@WebServlet("/producer")
public class ProducerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@JMSConnectionFactory("java:/myJmsTest/MyConnectionFactory")
	private JMSContext jmsContext;
	
	@Resource(lookup="java:/queue/myQueue")
	private Destination queue;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String text = request.getParameter("message") != null ? request.getParameter("message") : "Empty message";
		
		try {	
			jmsContext.createProducer().send(queue, text);
			response.getWriter().append("Mensagem " + text + " enviada a fila... verifique o log do console...");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("Erro ao enviar mensagem... verifique o log do console !!!");
		}
	}
}
