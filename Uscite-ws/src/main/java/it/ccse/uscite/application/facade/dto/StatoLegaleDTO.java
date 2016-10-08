/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;

/**
 * @author vcompagnone
 *
 */
public class StatoLegaleDTO extends DomainDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7148865815583237499L;
	private AutorizzazioneLegale autorizzazioneLegale;
	private String descrizione;
	private Boolean bloccante;
	
	/**
	 * @return the autorizzazioneLegale
	 */
	public AutorizzazioneLegale getAutorizzazioneLegale() {
		return autorizzazioneLegale;
	}
	/**
	 * @param autorizzazioneLegale the autorizzazioneLegale to set
	 */
	public void setAutorizzazioneLegale(AutorizzazioneLegale autorizzazioneLegale) {
		this.autorizzazioneLegale = autorizzazioneLegale;
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
