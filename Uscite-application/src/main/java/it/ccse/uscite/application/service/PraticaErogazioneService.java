/**
 * 
 */
package it.ccse.uscite.application.service;

import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

/**
 * @author vcompagnone
 *
 */
public interface PraticaErogazioneService {
	
	public PraticaErogazione getById(BigInteger id) ;
	
	public void createPraticaErogazione(PraticaErogazione praticaErogazione);
	
	public void savePraticaErogazione(PraticaErogazione praticaErogazione);
	
	public void delete(PraticaErogazione praticaErogazione);

	public Page<PraticaErogazione> searchPraticheErogazione(PraticaFilter filter);
	
	public PraticaErogazione getByCodicePratica(String codicePratica);
	
	public List<PraticaErogazione> getPraticheByProcessoErogazione(ProcessoErogazione processo);
	
	public List<PraticaErogazione> getPraticheLavorabili(ProcessoErogazione processo);
	
	public ProcessoErogazione associaPraticheANota(List<PraticaErogazione> pratiche, ProcessoErogazione processo);
	
	public void dissociaPraticheDaNota(List<PraticaErogazione> pratiche);

	public void delete(List<PraticaErogazione> pratiche);
	
	public List<PraticaErogazione> getPraticheAutorizzabiliComitato(ProcessoErogazione processo);
	
	public LavorazioneContabile lavorazioneContabile(List<PraticaErogazione> pratiche);
	
	public List<PraticaErogazione> aggiornaSemaforiAnagrafica(Collection<SettoreAttivita> settoriAttivita);
	
	public Page<PraticaErogazione> searchPraticheInSospeso(PraticaFilter filter);
	
	public void autorizzaComitato(List<PraticaErogazione> pratiche);
	
	public void rifiutaAutorizzazioneComitato(List<PraticaErogazione> pratiche);
	
	public List<PraticaErogazione> aggiornaFideiussione(Map<String,FideiussionePratica> mappaCodiciPraticaFideiussioni);

	public void rinvia(PraticaErogazione pratica, ProcessoErogazione processo);

}
