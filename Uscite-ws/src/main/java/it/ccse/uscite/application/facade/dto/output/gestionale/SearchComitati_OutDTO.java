/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.DettaglioComitatoDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vcompagnone
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchComitati_OutDTO extends PageDTO<DettaglioComitatoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185721839724701147L;
	
	@XmlElementWrapper(name="comitati")
	@XmlElement(name="comitato")
	private List<DettaglioComitatoDTO> content;
	
	@Override
	public List<DettaglioComitatoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DettaglioComitatoDTO> content) {
		this.content = content;
		
	}

}
