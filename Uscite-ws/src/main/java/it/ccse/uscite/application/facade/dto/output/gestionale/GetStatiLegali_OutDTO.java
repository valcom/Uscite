/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.Collection;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.StatoLegaleDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class GetStatiLegali_OutDTO extends Base_OutDTO implements ContainerDTO<Collection<StatoLegaleDTO>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4308432196172829433L;

	private Collection<StatoLegaleDTO> content;
	
	@Override
	public Collection<StatoLegaleDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(Collection<StatoLegaleDTO> content) {
		this.content = content;
	}

}
