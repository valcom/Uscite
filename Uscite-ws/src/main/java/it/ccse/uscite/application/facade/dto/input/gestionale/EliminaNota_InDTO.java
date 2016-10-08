/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.math.BigInteger;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class EliminaNota_InDTO extends Base_InDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger idProcessoErogazione;

	/**
	 * @return the idProcessoErogazione
	 */
	public BigInteger getIdProcessoErogazione() {
		return idProcessoErogazione;
	}

	/**
	 * @param idProcessoErogazione the idProcessoErogazione to set
	 */
	public void setIdProcessoErogazione(BigInteger idProcessoErogazione) {
		this.idProcessoErogazione = idProcessoErogazione;
	}


}
