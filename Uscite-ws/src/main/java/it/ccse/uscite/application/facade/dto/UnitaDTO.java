/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

/**
 * @author vcompagnone
 *
 */
public class UnitaDTO extends DomainDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idUnita;

	private byte autorizzante;

	private String descrizione;

	private byte lavorante;

	private byte proponente;

	private byte sistema;

	/**
	 * @return the idUnita
	 */
	public String getId() {
		return idUnita;
	}

	/**
	 * @param idUnita the idUnita to set
	 */
	public void setId(String id) {
		this.idUnita = id;
	}

	/**
	 * @return the autorizzante
	 */
	public byte getAutorizzante() {
		return autorizzante;
	}

	/**
	 * @param autorizzante the autorizzante to set
	 */
	public void setAutorizzante(byte autorizzante) {
		this.autorizzante = autorizzante;
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
	 * @return the lavorante
	 */
	public byte getLavorante() {
		return lavorante;
	}

	/**
	 * @param lavorante the lavorante to set
	 */
	public void setLavorante(byte lavorante) {
		this.lavorante = lavorante;
	}

	/**
	 * @return the proponente
	 */
	public byte getProponente() {
		return proponente;
	}

	/**
	 * @param proponente the proponente to set
	 */
	public void setProponente(byte proponente) {
		this.proponente = proponente;
	}

	/**
	 * @return the sistema
	 */
	public byte getSistema() {
		return sistema;
	}

	/**
	 * @param sistema the sistema to set
	 */
	public void setSistema(byte sistema) {
		this.sistema = sistema;
	}

	
	
}
