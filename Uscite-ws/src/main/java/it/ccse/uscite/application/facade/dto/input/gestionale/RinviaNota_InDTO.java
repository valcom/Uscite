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
public class RinviaNota_InDTO extends Base_InDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger idNota;
	
	private BigInteger idComitato;

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

	/**
	 * @return the idComitato
	 */
	public BigInteger getIdComitato() {
		return idComitato;
	}

	/**
	 * @param idComitato the idComitato to set
	 */
	public void setIdComitato(BigInteger idComitato) {
		this.idComitato = idComitato;
	}

	

}
