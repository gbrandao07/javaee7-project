package br.com.javaee7.jms.ejb.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * MDB para consumir as mensagens enviadas para a fila myQueue
 * 
 * @author gustavo
 *
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destination", propertyValue="java:/queue/myQueue"),
})
public class MessageConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("Mensagem recebida: " + textMessage.getText());
		} catch (Exception e) {
			System.err.println("Erro ao ler mensagem da fila");
		}
	}
}
