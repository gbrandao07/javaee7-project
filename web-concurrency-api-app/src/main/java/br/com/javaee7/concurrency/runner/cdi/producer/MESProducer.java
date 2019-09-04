package br.com.javaee7.concurrency.runner.cdi.producer;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Produces;

/**
 * Producer que possibilita usar @Inject ao invés de @Resource para obter o ManagedExecutorService
 * 
 * @author gustavo
 *
 */
public class MESProducer {

	@Produces
	@Resource(lookup = "java:comp/DefaultManagedExecutorService")
	private ManagedExecutorService mes;
}
