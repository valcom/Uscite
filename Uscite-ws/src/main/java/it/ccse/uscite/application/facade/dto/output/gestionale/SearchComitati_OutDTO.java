/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.DettaglioComitatoDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;

import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class SearchComitati_OutDTO extends PageDTO<DettaglioComitatoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185721839724701147L;
	private List<DettaglioComitatoDTO> content;
	
	@Override
	public List<DettaglioComitatoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DettaglioComitatoDTO> content) {
		this.content = content;
		
	}

}
