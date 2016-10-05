/**
 * 
 */
package it.ccse.uscite.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class LavorazioneContabile extends DomainObject {
	
	private List<PraticaErogazione> praticheInSospeso = new ArrayList<PraticaErogazione>();
	
	private List<PraticaErogazione> praticheInErogazione = new ArrayList<PraticaErogazione>();

	/**
	 * @return the praticheInSospeso
	 */
	public List<PraticaErogazione> getPraticheInSospeso() {
		return praticheInSospeso;
	}

	/**
	 * @param praticheInSospeso the praticheInSospeso to set
	 */
	public void setPraticheInSospeso(List<PraticaErogazione> praticheInSospeso) {
		this.praticheInSospeso = praticheInSospeso;
	}

	/**
	 * @return the praticheInErogazione
	 */
	public List<PraticaErogazione> getPraticheInErogazione() {
		return praticheInErogazione;
	}

	/**
	 * @param praticheInErogazione the praticheInErogazione to set
	 */
	public void setPraticheInErogazione(List<PraticaErogazione> praticheInErogazione) {
		this.praticheInErogazione = praticheInErogazione;
	}
	
	public void addSospesi(PraticaErogazione pratica){
		praticheInSospeso.add(pratica);
	}
	
	public void addErogazioni(List<PraticaErogazione> pratiche){
		praticheInErogazione.addAll(pratiche);
	}
	
	public void addSospesi(List<PraticaErogazione> pratiche){
		praticheInSospeso.addAll(pratiche);
	}
	
	public void addErogazioni(PraticaErogazione pratica){
		praticheInErogazione.add(pratica);
	}

}
