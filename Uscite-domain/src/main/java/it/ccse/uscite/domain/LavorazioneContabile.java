/**
 * 
 */
package it.ccse.uscite.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

/**
 * @author vcompagnone
 *
 */
public class LavorazioneContabile extends DomainObject {
	
	private List<PraticaErogazione> praticheLavorate = new ArrayList<PraticaErogazione>();
	
	private List<ProcessoErogazione> processiLavorati = new ArrayList<ProcessoErogazione>();

	/**
	 * @return the praticheInSospeso
	 */
	public List<PraticaErogazione> getPraticheInSospeso() {
		return praticheLavorate.stream().filter(PraticaErogazione.IS_IN_SOSPESO).collect(Collectors.toList());
	}

	/**
	 * @return the praticheInErogazione
	 */
	public List<PraticaErogazione> getPraticheInErogazione() {
		return praticheLavorate.stream().filter(PraticaErogazione.IS_IN_EROGAZIONE).collect(Collectors.toList());
	}

	public List<PraticaErogazione> getPraticheLavorate() {
		return praticheLavorate;
	}

	public void eseguiLavorazione(List<PraticaErogazione> pratiche){
		if(!CollectionUtils.isEmpty(pratiche)){
			pratiche.stream().forEach(PraticaErogazione::lavorazioneContabile);
			Set<ProcessoErogazione> processi = pratiche.stream().map(p->p.getProcessoErogazione()).collect(Collectors.toSet());
			processi.stream().forEach(ProcessoErogazione::lavorazioneContabile);
			processiLavorati.addAll(processi);
		}
	}

	public List<ProcessoErogazione> getProcessiLavorati() {
		return processiLavorati;
	}

	public void eseguiLavorazione(ProcessoErogazione processo) {
		eseguiLavorazione(processo.getPraticheLavorabili());
	}
	
}
