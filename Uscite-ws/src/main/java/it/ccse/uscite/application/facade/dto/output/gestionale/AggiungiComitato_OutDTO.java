/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiungiComitato_OutDTO extends Base_OutDTO implements ContainerDTO<ComitatoDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComitatoDTO content;

	@Override
	public ComitatoDTO getContent() {
		return content;
	}

	@Override
	public void setContent(ComitatoDTO content) {
		this.content = content;
		
	}
	
	

	
}
