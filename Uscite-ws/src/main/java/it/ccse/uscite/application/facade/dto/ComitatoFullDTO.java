/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import it.ccse.uscite.application.facade.xml_adapter.ComitatoFullDTOAdapter;

/**
 * @author vcompagnone
 *
 */
@XmlJavaTypeAdapter(ComitatoFullDTOAdapter.class)
public class ComitatoFullDTO extends DettaglioComitatoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7571745070853999713L;

	
	private List<NotaPagamentoFullDTO> note = new ArrayList<NotaPagamentoFullDTO>();

	
	public List<NotaPagamentoFullDTO> getNote() {
		return note;
	}

	public void setNote(List<NotaPagamentoFullDTO> note) {
		this.note = note;
	}
	
}
