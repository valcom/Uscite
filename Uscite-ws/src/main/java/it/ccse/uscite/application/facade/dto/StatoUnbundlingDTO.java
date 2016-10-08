/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;

/**
 * @author vcompagnone
 *
 */
public class StatoUnbundlingDTO extends DomainDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -796919398199141193L;
	private UnbundlingPratica unbundling;
	private String descrizione;
	private Boolean bloccante;
	
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
	/**
	 * @return the unbundling
	 */
	public UnbundlingPratica getUnbundling() {
		return unbundling;
	}
	/**
	 * @param unbundling the unbundling to set
	 */
	public void setUnbundling(UnbundlingPratica unbundling) {
		this.unbundling = unbundling;
	}
}
