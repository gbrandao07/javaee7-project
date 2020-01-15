package br.com.javaee7.websocket.chat.data;

abstract class BasicMessage extends ChatMessage {
	protected String dataString;

	BasicMessage(String type, String dataString) {
		super(type);
		this.dataString = dataString;
	}

	String getData() {
		return this.dataString;
	}

}
