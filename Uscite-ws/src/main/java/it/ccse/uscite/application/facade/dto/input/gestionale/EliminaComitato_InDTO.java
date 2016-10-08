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
public class EliminaComitato_InDTO extends Base_InDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger idOrdineDelGiorno;

	/**
	 * @return the idOrdineDelGiorno
	 */
	public BigInteger getIdOrdineDelGiorno() {
		return idOrdineDelGiorno;
	}

	/**
	 * @param idOrdineDelGiorno the idOrdineDelGiorno to set
	 */
	public void setIdOrdineDelGiorno(BigInteger idOrdineDelGiorno) {
		this.idOrdineDelGiorno = idOrdineDelGiorno;
	}

	
}
