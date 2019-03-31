package br.com.javaee7.jpa.ejb;

import javax.ejb.Local;

import br.com.javaee7.jpa.ejb.impl.DatabasePopulatorImpl;

/**
 * Contrato para o Singleton Session Bean implementado por {@link DatabasePopulatorImpl}
 *   
 * @author gustavo
 *
 */
@Local
public interface DatabasePopulatorLocal {
	
}
