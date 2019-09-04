package br.com.javaee7.jms.servlet.message;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
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

	@Resource(lookup="java:/myJmsTest/MyConnectionFactory")
	private ConnectionFactory cf;
	
	@Resource(lookup="java:/queue/myQueue")
	private Queue queue;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = request.getParameter("message") != null ? request.getParameter("message") : "Empty message";
		
		try {
			
			Connection conn = cf.createConnection();
			
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			MessageProducer publisher = session.createProducer(queue);
			
			conn.start();
			
			TextMessage message = session.createTextMessage(text);
			
			publisher.send(message);
			
			response.getWriter().append("Mensagem " + text + " enviada a fila... verifique o log do console...");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("Erro ao enviar mensagem... verifique o log do console !!!");
		}
	}
}
