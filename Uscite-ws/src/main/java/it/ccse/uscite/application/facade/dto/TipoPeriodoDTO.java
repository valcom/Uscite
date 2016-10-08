/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

/**
 * @author vcompagnone
 *
 */
public class TipoPeriodoDTO extends DomainDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;

	private String descrizione;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
