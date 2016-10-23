/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.uscite;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;

/**
 * @author vcompagnone
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchPratiche_OutDTO extends PageDTO<DettaglioPraticaErogazioneDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name="pratica")
	private List<DettaglioPraticaErogazioneDTO> content;
	
	@Override
	public List<DettaglioPraticaErogazioneDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DettaglioPraticaErogazioneDTO> content) {
		this.content = content;
		
	}

}
