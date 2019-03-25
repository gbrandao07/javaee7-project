package br.com.javaee7.ejb.impl;

import javax.ejb.Stateless;

import br.com.javaee7.ejb.HelloEJB;

/**
 * Implementacao do EJB {@link HelloEJB}
 * 
 * @author gustavo
 *
 */
@Stateless
public class HelloEJBImpl implements HelloEJB {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javaee7.ejb.HelloEJB#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		return "Hello world from EJB to: " + name;
	}
}
