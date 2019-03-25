package br.com.javaee7.ejb;

import javax.ejb.Local;

/**
 * Primeiro EJB criado. "Hello World"
 * 
 * @author gustavo
 *
 */
@Local
public interface HelloEJB {

	/**
	 * @param name o nome
	 * 
	 * @return "Ola" para o nome passado com parametro
	 */
	String sayHello(String name);
}
