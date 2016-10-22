/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.StatoLegaleDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetStatiLegali_OutDTO extends Base_OutDTO implements ContainerDTO<Collection<StatoLegaleDTO>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4308432196172829433L;

	@XmlElement(name="statoLegale")
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
