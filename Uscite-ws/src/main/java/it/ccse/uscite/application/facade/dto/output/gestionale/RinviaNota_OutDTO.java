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
public class RinviaNota_OutDTO extends Base_OutDTO implements ContainerDTO<NotaPagamentoFullDTO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NotaPagamentoFullDTO content;

	/**
	 * @return the content
	 */
	public NotaPagamentoFullDTO getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(NotaPagamentoFullDTO content) {
		this.content = content;
	}

}
