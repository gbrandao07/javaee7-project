package br.com.javaee7.batch;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named
public class MyItemWriter extends AbstractItemWriter {

	@Override
	public void writeItems(List<Object> items) throws Exception {

		items.forEach(System.out::println);
	}
}
