/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.uscite;

import java.util.ArrayList;
import java.util.Collection;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaSemaforiAnagrafica_OutDTO extends Base_OutDTO implements
		ContainerDTO<Collection<PraticaErogazioneDTO>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<PraticaErogazioneDTO> content = new ArrayList<PraticaErogazioneDTO>();

	@Override
	public Collection<PraticaErogazioneDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(Collection<PraticaErogazioneDTO> content) {
		this.content = content;
	}

}
