package br.com.javaee7.ejb;

import javax.ejb.Local;

/**
 * EJB para processar mensagens
 * 
 * @author gustavo
 *
 */
@Local
public interface FormProcessorBean {

	/**
	 * Dado uma mensagem, retorna um texto simulando um processamento realizado no servidor
	 * 
	 * @param requestText
	 *            a mensagem
	 * @return o texto de resposta
	 * @throws Exception
	 *             se o parametro vier vazio
	 */
	String processRequest(String requestText) throws Exception;
}
