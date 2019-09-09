package br.com.javaee7.batch;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.javaee7.batch.util.Source;

@Named
public class MyItemReader extends AbstractItemReader {

	@Inject
	private Source source;

	private int counter;

	@Override
	public Object readItem() throws Exception {
		
		if (counter < source.getEntries().size()) {
			return source.getEntries().get(counter++);
		}
		
		return null; // indica fim do processamento (nao chama mais o processor, nem o writer)
	}
}
