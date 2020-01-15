package br.com.javaee7.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/clock")
public class ClockServerEndpoint {

	private Thread updateThread;
	private boolean running = false;

	// Session eh um objeto implicito, caso desejar acessar apenas declarar como parametro
	@OnOpen
	public void startClock(Session session) {
		
		// teste para exibir URI do client
		System.out.println(session.getRequestURI());
		
		final Session mySession = session;
		this.running = true;
		final SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
		this.updateThread = new Thread() {
			public void run() {
				while (running) {
					String dateString = sdf.format(new Date());
					try {
						mySession.getBasicRemote().sendText(dateString);
						sleep(1000);
					} catch (IOException | InterruptedException ie) {
						running = false;
					}
				}
			}
		};
		this.updateThread.start();
	}

	@OnMessage
	public String handleMessage(String incomingMessage) {
		if ("stop".equals(incomingMessage)) {
			this.stopClock();
			return "clock stopped";
		} else {
			return "unknown message: " + incomingMessage;
		}
	}

	@OnError
	public void clockError(Throwable t) {
		this.stopClock();
	}

	@OnClose
	public void stopClock() {
		this.running = false;
		this.updateThread = null;
	}
}