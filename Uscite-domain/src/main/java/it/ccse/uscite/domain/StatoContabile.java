/**
 * 
 */
package it.ccse.uscite.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author vcompagnone
 *
 */
@Entity
@Table(name="stato_contabile")
public class StatoContabile extends StatoPratica<StatoContabile.AutorizzazioneContabile>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5855780198467766153L;

	public static enum AutorizzazioneContabile {
		UNDEFINED,DONT_CARE,AUTORIZZATO,NON_AUTORIZZATO,IN_LAVORAZIONE;
		
	}
	
	
	public StatoContabile(AutorizzazioneContabile aut,Boolean bloccante) {
		setAutorizzazioneContabile(aut);
		setBloccante(bloccante);
	}

	
	public StatoContabile() {
		this(AutorizzazioneContabile.UNDEFINED,Boolean.TRUE);
	}
	

	

	public AutorizzazioneContabile getAutorizzazioneContabile(){
		return getValore();
	}

	public void setAutorizzazioneContabile(AutorizzazioneContabile aut){
		setValore(aut);
	}
	
}
