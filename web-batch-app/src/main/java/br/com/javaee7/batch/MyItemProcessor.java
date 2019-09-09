package br.com.javaee7.batch;

import java.time.LocalDateTime;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

import br.com.javaee7.batch.pojo.ProcessedItemModel;

@Named
public class MyItemProcessor implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {

		if (item instanceof String) { // Lack of Generics in this Spec =/
			return new ProcessedItemModel((String) item, LocalDateTime.now().toString());
		}
		
		return null;
	}
}
