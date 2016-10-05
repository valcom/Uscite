/**
 * 
 */
package it.ccse.uscite.domain;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Table;

import it.ccse.uscite.domain.util.UsciteProperties;

/**
 * @author vcompagnone
 *
 */
@Entity
@Table(name="stato_fideiussione")
public class StatoFideiussione extends StatoPratica<StatoFideiussione.FideiussionePratica>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804279633895682240L;
	
	public static enum FideiussionePratica{
		UNDEFINED, PRESENTE, ASSENTE, DONT_CARE;
		
		/**
		 * 
		 * @param idComponenteTariffaria
		 * @return
		 */
		public FideiussionePratica getFideiussionePraticaByCT(BigInteger idComponenteTariffaria) {
			FideiussionePratica fideiussione = null;
			if(UsciteProperties.LISTA_COMPONENTI_TARIFFARIE_FIDEIUSSIONE.contains(idComponenteTariffaria.toString())){
				switch(this){
				case ASSENTE:
					fideiussione = FideiussionePratica.ASSENTE;
					break;
				case PRESENTE:
					fideiussione = FideiussionePratica.PRESENTE;
					break;
				case UNDEFINED:
					fideiussione = FideiussionePratica.UNDEFINED;
					break;
				default:
					break;
				}
			}else{
				fideiussione = FideiussionePratica.DONT_CARE;
			}
		
		return fideiussione;
		}
	}
	
	public StatoFideiussione(FideiussionePratica aut,Boolean bloccante) {
		setValore(aut);
		setBloccante(bloccante);
	}

	public StatoFideiussione(FideiussionePratica aut) {
		setValore(aut);
	}
	
	public StatoFideiussione() {
		this(FideiussionePratica.UNDEFINED,Boolean.FALSE);
	}
	

	public FideiussionePratica getFideiussione(){
		return getValore();
	}

}
