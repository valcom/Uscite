/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiungiNota_InDTO extends Base_InDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroNota;
	
	private String causale;
	
	private String owner;
	
	private ComitatoDTO ordineDelGiorno;

	/**
	 * @return the numeroNota
	 */
	public Integer getNumeroNota() {
		return numeroNota;
	}

	/**
	 * @param numeroNota the numeroNota to set
	 */
	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	/**
	 * @return the causale
	 */
	public String getCausale() {
		return causale;
	}

	/**
	 * @param causale the causale to set
	 */
	public void setCausale(String causale) {
		this.causale = causale;
	}

	/**
	 * @return the unita
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param unita the unita to set
	 */
	public void setOwner(String unita) {
		this.owner = unita;
	}

	/**
	 * @return the ordine
	 */
	public ComitatoDTO getOrdineDelGiorno() {
		return ordineDelGiorno;
	}

	/**
	 * @param ordine the ordine to set
	 */
	public void setOrdineDelGiorno(ComitatoDTO ordine) {
		this.ordineDelGiorno = ordine;
	}

	
	
}
