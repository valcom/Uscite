/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;


/**
 * @author vcompagnone
 *
 */
public class GetPraticaByCodicePratica_InDTO extends Base_InDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codicePratica;

	/**
	 * @return the codicePratica
	 */
	public String getCodicePratica() {
		return codicePratica;
	}

	/**
	 * @param codicePratica the codicePratica to set
	 */
	public void setCodicePratica(String codicePratica) {
		this.codicePratica = codicePratica;
	}

}
