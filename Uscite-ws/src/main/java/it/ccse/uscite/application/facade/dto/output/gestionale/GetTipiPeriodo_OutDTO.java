/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.TipoPeriodoDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTipiPeriodo_OutDTO extends Base_OutDTO implements ContainerDTO<Collection<TipoPeriodoDTO>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069844054416282636L;
	
	@XmlElement(name="tipoPeriodo")
	private Collection<TipoPeriodoDTO> content = new ArrayList<TipoPeriodoDTO>();

	@Override
	public Collection<TipoPeriodoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(Collection<TipoPeriodoDTO> content) {
		this.content = content;
	}

}
