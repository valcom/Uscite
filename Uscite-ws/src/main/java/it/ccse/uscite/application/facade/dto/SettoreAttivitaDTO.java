/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.SettoreAttivita.StatoAntimafia;
import it.ccse.uscite.domain.SettoreAttivita.Unbundling;

/**
 * @author vcompagnone
 *
 */
public class SettoreAttivitaDTO extends DomainDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String ragioneSociale;
	
	private StatoAntimafia statoAntimafia;
	
	private Unbundling unbundling;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the statoAntimafia
	 */
	public StatoAntimafia getStatoAntimafia() {
		return statoAntimafia;
	}

	/**
	 * @param statoAntimafia the statoAntimafia to set
	 */
	public void setStatoAntimafia(StatoAntimafia statoAntimafia) {
		this.statoAntimafia = statoAntimafia;
	}

	/**
	 * @return the unbundling
	 */
	public Unbundling getUnbundling() {
		return unbundling;
	}

	/**
	 * @param unbundling the unbundling to set
	 */
	public void setUnbundling(Unbundling unbundling) {
		this.unbundling = unbundling;
	}

	/**
	 * @return the regioneSociale
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @param regioneSociale the regioneSociale to set
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	

}
