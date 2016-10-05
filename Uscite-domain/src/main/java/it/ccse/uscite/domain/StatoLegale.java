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
@Table(name="stato_legale")
public class StatoLegale extends StatoPratica<StatoLegale.AutorizzazioneLegale>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1804279633895682240L;

	public static enum AutorizzazioneLegale{
		UNDEFINED,AUTORIZZATO,DONT_CARE,DEROGA_SOGLIA,DEROGA_CAM,DEROGA_123,NON_AUTORIZZATO,DI_UFFICIO,CAM_SCADUTA,IN_LAVORAZIONE,TEMPORANEA,ISTRUTTORIA_COMPLESSA,CESSATA_ATTIVITA;
	} 
	
	
	public StatoLegale(AutorizzazioneLegale aut,Boolean bloccante) {
		setValore(aut);
		setBloccante(bloccante);
	}

	
	public StatoLegale() {
		this(AutorizzazioneLegale.UNDEFINED,Boolean.FALSE);
	}
	

	

	public AutorizzazioneLegale getAutorizzazioneLegale(){
		return getValore();
	}

}
