package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.ComitatoFullDTO;
import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

public class AggiornaComitato_OutDTO extends Base_OutDTO implements ContainerDTO<ComitatoFullDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ComitatoFullDTO content;

	@Override
	public ComitatoFullDTO getContent() {
		return content;
	}

	@Override
	public void setContent(ComitatoFullDTO content) {
		this.content = content;
		
	}
	
}
