package br.com.javaee7.ejb.impl;

import javax.ejb.Stateless;

import br.com.javaee7.ejb.FormProcessorBean;

/**
 * Implementacao do {@link FormProcessorBean} 
 * 
 * @author gustavo
 *
 */
@Stateless
public class FormProcessorBeanImpl implements FormProcessorBean {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.javaee7.ejb.FormProcessorBean#processRequest(java.lang.String)
	 */
	@Override
	public String processRequest(String requestText) throws Exception {
		
		if (requestText == null || requestText.isEmpty()) {
			throw new Exception("Um texto deve ser informado...");
		}
		
		return "O texto ('" + requestText +  "') " + "foi processado pelo EJB " + FormProcessorBean.class.getSimpleName() 
				+ " cuja implementacao injetada eh " + this.getClass().getSimpleName();
	}
}
