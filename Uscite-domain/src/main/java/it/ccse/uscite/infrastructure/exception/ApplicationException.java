package it.ccse.uscite.infrastructure.exception;

public class ApplicationException  extends MessageException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException(String messageCode) {
		super(messageCode);
	}
}
