package it.ccse.uscite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_periodo database table.
 * 
 */
@Entity
@Table(name="tipo_periodo")
public class TipoPeriodo  extends DomainEntity<Integer>{
	private static final long serialVersionUID = 1L;

	private String descrizione;
	
	@Column(nullable=false,unique=true)
	private String codice;

	public TipoPeriodo() {
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}