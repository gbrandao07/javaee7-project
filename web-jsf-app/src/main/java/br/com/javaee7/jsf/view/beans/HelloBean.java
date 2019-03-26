package br.com.javaee7.jsf.view.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "myHelloBean")
@RequestScoped
public class HelloBean {

	private String name = "dear reader";

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
