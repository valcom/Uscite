/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.util.List;


/**
 * @author vcompagnone
 *
 */
public class NotaPagamentoFullDTO extends DettaglioNotaPagamentoDTO{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2428110640163323827L;
	
	private List<PraticaErogazioneDTO> praticheErogazione;
	
	public List<PraticaErogazioneDTO> getPraticheErogazione() {
		return praticheErogazione;
	}

	/**
	 * @param praticheErogazione the praticheErogazione to set
	 */
	public void setPraticheErogazione(
			List<PraticaErogazioneDTO> praticheErogazione) {
		this.praticheErogazione = praticheErogazione;
	}

	
	
	
}
