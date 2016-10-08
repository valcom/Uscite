/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class ApriNota_InDTO extends Base_InDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idProcessoErogazione;

	/**
	 * @return the idProcessoErogazione
	 */
	public Integer getIdProcessoErogazione() {
		return idProcessoErogazione;
	}

	/**
	 * @param idProcessoErogazione the idProcessoErogazione to set
	 */
	public void setIdProcessoErogazione(Integer idProcessoErogazione) {
		this.idProcessoErogazione = idProcessoErogazione;
	}


}
