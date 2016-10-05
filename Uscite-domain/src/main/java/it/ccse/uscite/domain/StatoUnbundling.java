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
@Table(name="stato_unbundling")
public class StatoUnbundling extends StatoPratica<StatoUnbundling.UnbundlingPratica>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804279633895682240L;
	
	/**
	 * 
	 */	
	public static enum UnbundlingPratica{
		UNDEFINED,AUTORIZZATO,NON_AUTORIZZATO,DONT_CARE;
	}
	
	public StatoUnbundling(UnbundlingPratica aut,Boolean bloccante) {
		setUnbundling(aut);
		setBloccante(bloccante);
	}

	
	public StatoUnbundling() {
		this(UnbundlingPratica.UNDEFINED,Boolean.FALSE);
	}
	

	public UnbundlingPratica getUnbundling(){
		return getValore();
	}

	public void setUnbundling(UnbundlingPratica aut){
		setValore(aut);
	}

	
}
