/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.NotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaNota_OutDTO extends Base_OutDTO implements ContainerDTO<NotaPagamentoFullDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NotaPagamentoFullDTO content;
	
	@Override
	public NotaPagamentoFullDTO getContent() {
		return content;
	}

	@Override
	public void setContent(NotaPagamentoFullDTO content) {
		this.content = content;		
	}

}
