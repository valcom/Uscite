/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.List;

import it.ccse.uscite.application.facade.dto.DettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;

/**
 * @author vcompagnone
 *
 */
public class SearchNote_OutDTO extends PageDTO<DettaglioNotaPagamentoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7872285885495484146L;
	private List<DettaglioNotaPagamentoDTO> content;

	@Override
	public List<DettaglioNotaPagamentoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DettaglioNotaPagamentoDTO> content) {
		this.content = content;		
	}

}
