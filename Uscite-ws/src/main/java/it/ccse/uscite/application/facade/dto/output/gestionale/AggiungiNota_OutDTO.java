/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.DettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiungiNota_OutDTO extends Base_OutDTO implements ContainerDTO<DettaglioNotaPagamentoDTO>{

	private DettaglioNotaPagamentoDTO processoErogazione;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public DettaglioNotaPagamentoDTO getContent() {
		return processoErogazione;
	}

	@Override
	public void setContent(DettaglioNotaPagamentoDTO content) {
		processoErogazione = content;		
	}

}
