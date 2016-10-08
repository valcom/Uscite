/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.uscite;

import java.util.ArrayList;
import java.util.Collection;

import it.ccse.uscite.application.facade.dto.AggiornaFideiussioneDTO;
import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaFideiussione_InDTO extends Base_InDTO implements ContainerDTO<Collection<AggiornaFideiussioneDTO>>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7129185738111649528L;
	private Collection<AggiornaFideiussioneDTO> content = new ArrayList<AggiornaFideiussioneDTO>();

	@Override
	public Collection<AggiornaFideiussioneDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(Collection<AggiornaFideiussioneDTO> content) {
		this.content = content;		
	}

}
