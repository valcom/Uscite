/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import it.ccse.uscite.application.facade.dto.BaseDTO;

/**
 * @author vcompagnone
 *
 */
public abstract class Base_OutDTO extends BaseDTO {

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Esito esito;
	private String message;
	private String errorCode;
	private String[] errorParams;

	/**
	 * @return the esito
	 */
	public Esito getEsito() {
		return esito;
	}
	/**
	 * @param esito the esito to set
	 */
	public void setEsito(Esito esito) {
		this.esito = esito;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}



	/**
	 * @return the errorParams
	 */
	public String[] getErrorParams() {
		return errorParams;
	}
	/**
	 * @param errorParams the errorParams to set
	 */
	public void setErrorParams(String[] errorParams) {
		this.errorParams = errorParams;
	}



	@XmlType(name="esito")
	@XmlEnum
	public enum Esito {

		SUCCESS("Success"),
		APPLICATION_ERROR("Application Error"),
		GENERIC_EXCEPTION("Generic Exception");

		private final String descrizione;

		private Esito(String d){
			descrizione = d;
		}

		public String getDescrizione(){
			return descrizione;
		}

		public String toString(){
			return descrizione;
		}
	}


}
