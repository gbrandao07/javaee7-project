package br.com.javaee7.concurrency.runner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;

/**
 * Cria algumas tasks para execucao
 * 
 * @author gustavo
 *
 */
public class ConcurrencyApiRunner {

	@Inject
	private ManagedExecutorService mes;
	
	public void runTasks() throws InterruptedException, ExecutionException {
		
		Callable<String> c1 = () -> {
			System.out.println("Executando callable 1 na thread: " + Thread.currentThread().getName());
			return "Sucesso no callable 1";
		};
		
		Callable<String> c2 = () -> {
			System.out.println("Executando callable 2 na thread: " + Thread.currentThread().getName());
			return "Sucesso no callable 2";
		};
		
		Callable<String> c3 = () -> {
			System.out.println("Executando callable 3 na thread: " + Thread.currentThread().getName());
			return "Sucesso no callable 3";
		};
		
		List<Future<String>> results = mes.invokeAll(Arrays.asList(c1, c2, c3));
		for (Future<String> result : results) {
			System.out.println(result.get());
		}
	}
}
