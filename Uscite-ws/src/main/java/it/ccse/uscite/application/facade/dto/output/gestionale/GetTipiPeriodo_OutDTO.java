/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.TipoPeriodoDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class GetTipiPeriodo_OutDTO extends Base_OutDTO implements ContainerDTO<Collection<TipoPeriodoDTO>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069844054416282636L;
	
	
	private Collection<TipoPeriodoDTO> content = new ArrayList<TipoPeriodoDTO>();

	@Override
	@XmlElement
	public Collection<TipoPeriodoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(Collection<TipoPeriodoDTO> content) {
		this.content = content;
	}

}
