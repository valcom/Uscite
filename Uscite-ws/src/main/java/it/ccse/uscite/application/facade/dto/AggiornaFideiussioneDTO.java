/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;

/**
 * @author vcompagnone
 *
 */
public class AggiornaFideiussioneDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1575155183352128378L;
	
	
	private String codicePratica;
	private FideiussionePratica fideiussione;
	
	
	public String getCodicePratica() {
		return codicePratica;
	}
	public void setCodicePratica(String codicePratica) {
		this.codicePratica = codicePratica;
	}
	public FideiussionePratica getFideiussione() {
		return fideiussione;
	}
	public void setFideiussione(FideiussionePratica fideiussione) {
		this.fideiussione = fideiussione;
	}
	
	

}
