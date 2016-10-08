/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.math.BigDecimal;

/**
 * @author vcompagnone
 *
 */
public class DettaglioComitatoDTO extends ComitatoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer totaleNote;
	
	private BigDecimal totaleImporto;

	
	//private List<NotaPagamentoDTO> note;

	/**
	 * @return the totaleNote
	 */
	public Integer getTotaleNote() {
		return totaleNote;
	}

	/**
	 * @param totaleNote the totaleNote to set
	 */
	public void setTotaleNote(Integer totaleNote) {
		this.totaleNote = totaleNote;
	}

	/**
	 * @return the totaleImporto
	 */
	public BigDecimal getTotaleImporto() {
		return totaleImporto;
	}

	/**
	 * @param totaleImporto the totaleImporto to set
	 */
	public void setTotaleImporto(BigDecimal totaleImporto) {
		this.totaleImporto = totaleImporto;
	}
	
	
	
}
