/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;

/**
 * @author vcompagnone
 *
 */
public class StatoComitatoDTO extends DomainDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2438943803147586626L;
	private Integer id;
	private AutorizzazioneComitato autorizzazioneComitato;
	private String descrizione;
	private Boolean bloccante;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the autorizzazioneComitato
	 */
	public AutorizzazioneComitato getAutorizzazioneComitato() {
		return autorizzazioneComitato;
	}
	/**
	 * @param autorizzazioneComitato the autorizzazioneComitato to set
	 */
	public void setAutorizzazioneComitato(
			AutorizzazioneComitato autorizzazioneComitato) {
		this.autorizzazioneComitato = autorizzazioneComitato;
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
