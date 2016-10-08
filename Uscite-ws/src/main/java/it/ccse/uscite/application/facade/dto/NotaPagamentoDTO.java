/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.math.BigInteger;

import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;


/**
 * @author vcompagnone
 *
 */
public class NotaPagamentoDTO extends DomainDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger idProcessoErogazione;

	private String causale;

	private StatoLavorazioneContabile lavorazioneContabile;

	private Integer numeroNota;

	private StatoProcesso stato;
	
	
	/**
	 * @return the idProcessoErogazione
	 */
	public BigInteger getId() {
		return idProcessoErogazione;
	}

	/**
	 * @param idProcessoErogazione the idProcessoErogazione to set
	 */
	public void setId(BigInteger id) {
		this.idProcessoErogazione = id;
	}

	
	/**
	 * @return the causale
	 */
	public String getCausale() {
		return causale;
	}

	/**
	 * @param causale the causale to set
	 */
	public void setCausale(String causale) {
		this.causale = causale;
	}

	/**
	 * @return the lavorazioneContabile
	 */
	public StatoLavorazioneContabile getLavorazioneContabile() {
		return lavorazioneContabile;
	}

	/**
	 * @param lavorazioneContabile the lavorazioneContabile to set
	 */
	public void setLavorazioneContabile(StatoLavorazioneContabile lavorazioneContabile) {
		this.lavorazioneContabile = lavorazioneContabile;
	}

	/**
	 * @return the numeroNota
	 */
	public Integer getNumeroNota() {
		return numeroNota;
	}

	/**
	 * @param numeroNota the numeroNota to set
	 */
	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	

	/**
	 * @return the stato
	 */
	public StatoProcesso getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(StatoProcesso stato) {
		this.stato = stato;
	}

	

	

}
