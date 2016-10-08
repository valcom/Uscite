/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;


/**
 * @author vcompagnone
 *
 */
public class GetPraticaByCodicePratica_OutDTO extends Base_OutDTO implements ContainerDTO<DettaglioPraticaErogazioneDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DettaglioPraticaErogazioneDTO content;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.facade.dto.output.SingleContentDTO#getContent()
	 */
	@Override
	public DettaglioPraticaErogazioneDTO getContent() {
		return content;
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.facade.dto.output.SingleContentDTO#setContent(it.ccse.uscite.facade.dto.DomainDTO)
	 */
	@Override
	public void setContent(DettaglioPraticaErogazioneDTO content) {
		this.content = content;
	}

}
