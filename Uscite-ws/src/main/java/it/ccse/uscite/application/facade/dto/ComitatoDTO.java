/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;
import it.ccse.uscite.domain.OrdineDelGiorno.TipologiaComitato;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author vcompagnone
 *
 */
public class ComitatoDTO extends DomainDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigInteger idOrdineDelGiorno;

	private Date dataComitato;

	private String descrizione;

	private Integer numeroComitato;

	private StatoComitato stato;

	private TipologiaComitato tipologia;
	


	/**
	 * @return the idOrdineDelGiorno
	 */
	public BigInteger getId() {
		return idOrdineDelGiorno;
	}

	/**
	 * @param idOrdineDelGiorno the idOrdineDelGiorno to set
	 */
	public void setId(BigInteger id) {
		this.idOrdineDelGiorno = id;
	}

	/**
	 * @return the dataComitato
	 */
	public Date getDataComitato() {
		return dataComitato;
	}

	/**
	 * @param dataComitato the dataComitato to set
	 */
	public void setDataComitato(Date dataComitato) {
		this.dataComitato = dataComitato;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the numeroComitato
	 */
	public Integer getNumeroComitato() {
		return numeroComitato;
	}

	/**
	 * @param numeroComitato the numeroComitato to set
	 */
	public void setNumeroComitato(Integer numeroComitato) {
		this.numeroComitato = numeroComitato;
	}

	/**
	 * @return the stato
	 */
	public StatoComitato getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(StatoComitato stato) {
		this.stato = stato;
	}

	/**
	 * @return the tipologia
	 */
	public TipologiaComitato getTipologia() {
		return tipologia;
	}

	/**
	 * @param tipologia the tipologia to set
	 */
	public void setTipologia(TipologiaComitato tipologia) {
		this.tipologia = tipologia;
	}

	

	
	
}
