package br.com.javaee7.jpa.ejb.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.javaee7.jpa.ejb.DatabasePopulatorLocal;
import br.com.javaee7.jpa.entity.Car;

@Singleton
@Startup
public class DatabasePopulatorImpl implements DatabasePopulatorLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void fillDefaultData() {

		Car c1 = new Car();
		c1.setName("Honda Civic");
		c1.setYear(2012);
		em.persist(c1);
		
		Car c2 = new Car();
		c2.setName("Honda City");
		c2.setYear(2015);
		em.persist(c2);
		
		Car c3 = new Car();
		c3.setName("GM Meriva");
		c3.setYear(2012);
		em.persist(c3);
	}
}
