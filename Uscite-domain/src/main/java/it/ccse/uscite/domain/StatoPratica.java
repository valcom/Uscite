/**
 * 
 */
package it.ccse.uscite.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * @author vcompagnone
 *
 */
@MappedSuperclass
@Cacheable
public abstract class StatoPratica<V extends Enum<?>> extends DomainEntity<Integer> implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(updatable=false,nullable=false)
	private Boolean bloccante;
	
	@Column(updatable=false,nullable=false)
	private String descrizione;
	
	@Column(updatable=false,nullable=false,unique=true)
	@Enumerated(EnumType.STRING)
	private V valore;

	/**
	 * @return the bloccante
	 */
	public Boolean getBloccante() {
		return bloccante;
	}

	/**
	 * @param bloccante the bloccante to set
	 */
	public void setBloccante(Boolean bloccante) {
		this.bloccante = bloccante;
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

	public V getValore() {
		return valore;
	}

	public void setValore(V valore) {
		this.valore = valore;
	}
	
	

	

}
