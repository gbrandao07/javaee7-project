package br.com.javaee7.batch.pojo;

public class ProcessedItemModel {

	private String input;
	private String createdDateStamp;
	
	public ProcessedItemModel(String input, String createdDateStamp) {
		this.input = input;
		this.createdDateStamp = createdDateStamp;
	}

	@Override
	public String toString() {
		return "ProcessedItemModel [input=" + input + ", createdDateStamp=" + createdDateStamp + "]";
	}
}
