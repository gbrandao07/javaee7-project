package br.com.javaee7.batch.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class Source {

	private List<String> entries = new ArrayList<String>();
	
	@PostConstruct
	public void populateEntries() {
		for (int i = 0; i < 20000; i++) {
			entries.add("String: " + i);
 		}
	}

	public List<String> getEntries() {
		return entries;
	}
}
