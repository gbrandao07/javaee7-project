package br.com.javaee7.cdi.bean;

import br.com.javaee7.cdi.bean.impl.BabyBearBed;
import br.com.javaee7.cdi.bean.impl.DaddyBearBed;
import br.com.javaee7.cdi.bean.impl.MommyBearBed;

/**
 * Interface para os beans {@link BabyBearBed}, {@link DaddyBearBed} e {@link MommyBearBed}
 * 
 * @author gustavo
 *
 */
public interface Bed {
	
	/**
	 * 
	 * @return o texto com o resultado da tentativa
	 */
	public String tryIt();
}