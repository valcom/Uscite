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
public class LavorazioneContabileNota_InDTO extends Base_InDTO  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger idNota;

	/**
	 * @return the idNota
	 */
	public BigInteger getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(BigInteger idNota) {
		this.idNota = idNota;
	}

	
	
}
