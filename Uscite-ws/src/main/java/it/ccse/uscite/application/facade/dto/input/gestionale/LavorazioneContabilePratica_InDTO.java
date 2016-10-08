/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.util.ArrayList;
import java.util.Collection;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class LavorazioneContabilePratica_InDTO extends Base_InDTO implements
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
