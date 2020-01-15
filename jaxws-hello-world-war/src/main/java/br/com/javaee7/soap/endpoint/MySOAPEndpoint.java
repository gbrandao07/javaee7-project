package br.com.javaee7.soap.endpoint;

import javax.jws.WebService;

@WebService
public class MySOAPEndpoint {

	
	public String sayHello() {
		return "Hello";
	}
}
