/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import it.ccse.uscite.application.facade.dto.DettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;

/**
 * @author vcompagnone
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchNote_OutDTO extends PageDTO<DettaglioNotaPagamentoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7872285885495484146L;
	
	@XmlElementWrapper(name="note")
	@XmlElement(name="nota")
	private List<DettaglioNotaPagamentoDTO> content;

	@Override
	public List<DettaglioNotaPagamentoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DettaglioNotaPagamentoDTO> content) {
		this.content = content;		
	}

}
