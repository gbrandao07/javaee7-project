package br.com.javaee7.batch.util.cdi;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.enterprise.inject.Produces;

public class JobOperatorProducer {

	@Produces
	JobOperator jobOperator = BatchRuntime.getJobOperator();
}
