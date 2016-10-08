/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.uscite;

import java.util.ArrayList;
import java.util.Collection;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaSemaforiAnagrafica_InDTO extends Base_InDTO implements
		ContainerDTO<Collection<SettoreAttivitaDTO>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<SettoreAttivitaDTO> content = new ArrayList<SettoreAttivitaDTO>();

	@Override
	public Collection<SettoreAttivitaDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(Collection<SettoreAttivitaDTO> content) {
		this.content = content;
	}

}
