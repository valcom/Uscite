/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class LavorazioneContabileDTO extends DomainDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PraticaErogazioneDTO> praticheInSospeso;
	
	private List<PraticaErogazioneDTO> praticheInErogazione;

	/**
	 * @return the praticheInSospeso
	 */
	public List<PraticaErogazioneDTO> getPraticheInSospeso() {
		return praticheInSospeso;
	}

	/**
	 * @param praticheInSospeso the praticheInSospeso to set
	 */
	public void setPraticheInSospeso(List<PraticaErogazioneDTO> praticheInSospeso) {
		this.praticheInSospeso = praticheInSospeso;
	}

	/**
	 * @return the praticheInErogazione
	 */
	public List<PraticaErogazioneDTO> getPraticheInErogazione() {
		return praticheInErogazione;
	}

	/**
	 * @param praticheInErogazione the praticheInErogazione to set
	 */
	public void setPraticheInErogazione(
			List<PraticaErogazioneDTO> praticheInErogazione) {
		this.praticheInErogazione = praticheInErogazione;
	}

}
