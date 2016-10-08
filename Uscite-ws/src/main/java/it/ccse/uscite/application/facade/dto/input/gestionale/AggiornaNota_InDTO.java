/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaNota_InDTO extends Base_InDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idNota;
	
	private Integer numeroNota;
	
	private String causale;
	
	private String owner;

	/**
	 * @return the idNota
	 */
	public Integer getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}
	
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
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	
	
	
}
