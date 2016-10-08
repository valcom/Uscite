/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;

/**
 * @author vcompagnone
 *
 */
public class StatoContabileDTO extends DomainDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 447277749229776853L;
	
	private AutorizzazioneContabile autorizzazioneContabile;
	private String descrizione;
	private Boolean bloccante;
	
	/**
	 * @return the autorizzazioneContabile
	 */
	public AutorizzazioneContabile getAutorizzazioneContabile() {
		return autorizzazioneContabile;
	}
	/**
	 * @param autorizzazioneContabile the autorizzazioneContabile to set
	 */
	public void setAutorizzazioneContabile(
			AutorizzazioneContabile autorizzazioneContabile) {
		this.autorizzazioneContabile = autorizzazioneContabile;
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
