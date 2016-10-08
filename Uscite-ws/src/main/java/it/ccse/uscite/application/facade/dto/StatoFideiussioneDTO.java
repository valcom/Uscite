/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;

/**
 * @author vcompagnone
 *
 */
public class StatoFideiussioneDTO extends DomainDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9150657469358245324L;
	
	private FideiussionePratica fideiussione;
	private String descrizione;
	private Boolean bloccante;
	
	/**
	 * @return the fideiussione
	 */
	public FideiussionePratica getFideiussione() {
		return fideiussione;
	}
	/**
	 * @param fideiussione the fideiussione to set
	 */
	public void setFideiussione(FideiussionePratica fideiussione) {
		this.fideiussione = fideiussione;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * @return the bloccante
	 */
	public Boolean getBloccante() {
		return bloccante;
	}
	/**
	 * @param bloccante the bloccante to set
	 */
	public void setBloccante(Boolean bloccante) {
		this.bloccante = bloccante;
	}
}
