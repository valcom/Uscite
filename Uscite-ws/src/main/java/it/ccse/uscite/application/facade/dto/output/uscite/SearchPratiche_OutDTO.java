/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.uscite;

import java.util.List;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;

/**
 * @author vcompagnone
 *
 */
public class SearchPratiche_OutDTO extends PageDTO<DettaglioPraticaErogazioneDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DettaglioPraticaErogazioneDTO> content;
	
	@Override
	public List<DettaglioPraticaErogazioneDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DettaglioPraticaErogazioneDTO> content) {
		this.content = content;
		
	}

}
