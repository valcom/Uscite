package it.ccse.uscite.domain.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ResourceBundle bundle = null;
	
	private Object[] args;
	
	
	public String getTextMessage() {
		String codice = this.getMessageCode();
		initBundle();
		if (bundle.containsKey(codice))
			return MessageFormat.format(bundle.getString(codice), this.args);
		else
			return codice;
	}	
	
	

	public MessageException(String messageCode) {
		super(messageCode);
	}

	public MessageException(String messageCode, Object[] args) {
		super(messageCode);
		this.args = args;
	}

	public String getMessageCode() {
		return this.getMessage();
	}
	
	private void initBundle() {
		if (bundle == null) {
			bundle = ResourceBundle.getBundle("messages");
		}
	}
	
	
}
