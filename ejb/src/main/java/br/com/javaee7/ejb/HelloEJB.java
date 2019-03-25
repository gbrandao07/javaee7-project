package br.com.javaee7.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloEJB {

	String sayHello(String name);
}
