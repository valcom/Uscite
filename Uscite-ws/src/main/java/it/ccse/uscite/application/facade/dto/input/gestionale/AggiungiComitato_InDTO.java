/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.util.Date;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno.TipologiaComitato;

/**
 * @author vcompagnone
 *
 */
public class AggiungiComitato_InDTO extends Base_InDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date dataComitato;
	
	private String descrizione;
	
	private Integer numeroComitato;
	
	private TipologiaComitato tipologia;

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
