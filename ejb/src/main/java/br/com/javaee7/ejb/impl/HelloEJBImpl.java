package br.com.javaee7.ejb.impl;

import javax.ejb.Stateless;

import br.com.javaee7.ejb.HelloEJB;

@Stateless
public class HelloEJBImpl implements HelloEJB {

	@Override
	public String sayHello(String name) {
		return "Hello world from EJB to: " + name;
	}

}
