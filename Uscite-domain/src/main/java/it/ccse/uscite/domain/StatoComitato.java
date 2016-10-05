/**
 * 
 */
package it.ccse.uscite.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author vcompagnone
 * Stato Comitato di una pratica
 */
@Entity
@Table(name="stato_comitato")
public class StatoComitato extends StatoPratica<StatoComitato.AutorizzazioneComitato>{

	public static enum AutorizzazioneComitato {
		UNDEFINED,DONT_CARE,AUTORIZZATO,NON_AUTORIZZATO,IN_LAVORAZIONE,RINVIATA;		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1804279633895682240L;
	
	public StatoComitato(AutorizzazioneComitato aut,Boolean bloccante) {
		setValore(aut);
		setBloccante(bloccante);
	}

	
	public StatoComitato() {
		this(AutorizzazioneComitato.UNDEFINED,Boolean.TRUE);
	}

}
