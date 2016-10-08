/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class DissociaPraticheDaNota_InDTO extends Base_InDTO implements ContainerDTO<Collection<DettaglioPraticaErogazioneDTO>>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5410795341012845492L;

	private BigInteger idNota;
	
	private Collection<DettaglioPraticaErogazioneDTO> content = new ArrayList<DettaglioPraticaErogazioneDTO>();

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

	public Collection<DettaglioPraticaErogazioneDTO> getContent() {
		return content;
	}

	public void setContent(Collection<DettaglioPraticaErogazioneDTO> content) {
		this.content = content;
	}

	
}
