package br.com.javaee7.cdi.bean.impl;

import br.com.javaee7.cdi.bean.Bed;
import br.com.javaee7.cdi.bean.qualifier.Comfort;

/**
 * 
 * @author gustavo
 *
 */
@Comfort("firm")
public class DaddyBearBed implements Bed {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javaee7.cdi.bean.Bed#tryIt()
	 */
	@Override
	public String tryIt() {
		return "too hard";
	}
}