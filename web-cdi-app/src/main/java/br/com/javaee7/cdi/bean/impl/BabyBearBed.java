package br.com.javaee7.cdi.bean.impl;

import br.com.javaee7.cdi.bean.Bed;

/**
 * 
 * @author gustavo
 *
 */
public class BabyBearBed implements Bed {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javaee7.cdi.bean.Bed#tryIt()
	 */
	@Override
	public String tryIt() {
		return "just right";
	}
}