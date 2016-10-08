/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.math.BigDecimal;

/**
 * @author vcompagnone
 *
 */
public class DettaglioNotaPagamentoDTO extends NotaPagamentoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private BigDecimal totaleImporto;
	
	private Integer numeroPratiche;
	
	private String owner;
		
	private ComitatoDTO ordineDelGiorno;

	
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

	/**
	 * @return the numeroPratiche
	 */
	public Integer getNumeroPratiche() {
		return numeroPratiche;
	}

	/**
	 * @param numeroPratiche the numeroPratiche to set
	 */
	public void setNumeroPratiche(Integer numeroPratiche) {
		this.numeroPratiche = numeroPratiche;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the ordineDelGiorno
	 */
	public ComitatoDTO getOrdineDelGiorno() {
		return ordineDelGiorno;
	}

	/**
	 * @param ordineDelGiorno the ordineDelGiorno to set
	 */
	public void setOrdineDelGiorno(ComitatoDTO ordineDelGiorno) {
		this.ordineDelGiorno = ordineDelGiorno;
	}


	

}
