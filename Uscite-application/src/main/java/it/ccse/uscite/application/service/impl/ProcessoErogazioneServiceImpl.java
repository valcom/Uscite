/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import java.math.BigInteger;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.ccse.uscite.application.service.ProcessoErogazioneService;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.exception.ApplicationException;
import it.ccse.uscite.domain.filter.ProcessoFilter;
import it.ccse.uscite.domain.repository.OrdineDelGiornoRepository;
import it.ccse.uscite.domain.repository.PraticaErogazioneRepository;
import it.ccse.uscite.domain.repository.ProcessoErogazioneRepository;

/**
 * @author vcompagnone
 *
 */
@Service
@Transactional(readOnly=false)
public class ProcessoErogazioneServiceImpl implements ProcessoErogazioneService{

	@Autowired
	private ProcessoErogazioneRepository processoErogazioneRepository;
	
	@Autowired
	private OrdineDelGiornoRepository ordineDelGiornoRepository;
	
	@Autowired
	private PraticaErogazioneRepository praticaErogazioneRepository;
	
	@Override
	public ProcessoErogazione createProcessoErogazione(
			ProcessoErogazione processo) {
		OrdineDelGiorno ordineDelGiorno = ordineDelGiornoRepository.findOne(processo.getOrdineDelGiorno().getId());
		ordineDelGiorno.aggiungiProcessoErogazione(processo);
		return processoErogazioneRepository.save(processo);
	}

	@Override
	public void eliminaProcessoErogazione(ProcessoErogazione processo) {
		processo.checkCancellazione();
		processoErogazioneRepository.delete(processo);
	}

	@Override
	public ProcessoErogazione aggiornaProcessoErogazione(
			ProcessoErogazione processo) {
		BigInteger idProcesso = processo.getId();
	    Integer numeroNota = processo.getNumeroNota();
		String causale = processo.getCausale();
		String owner = processo.getOwner();
		processo = processoErogazioneRepository.findOne(idProcesso);
		processo.aggiorna(numeroNota,causale,owner);
		return processoErogazioneRepository.save(processo);
	}

	@Override
	public ProcessoErogazione apriProcessoErogazione(ProcessoErogazione processo) {
		processo = processoErogazioneRepository.findOne(processo.getId());
		processo.apri();
		return processoErogazioneRepository.save(processo);
	}

	@Override
	public ProcessoErogazione chiudiProcessoErogazione(
			ProcessoErogazione processo) {
		processo = processoErogazioneRepository.findOne(processo.getId());
		processo.chiudi();
		return processoErogazioneRepository.save(processo);
	}

	@Override
	@Transactional(readOnly=true)
	public Set<ProcessoErogazione> getProcessiErogazioneByOrdineDelGiorno(
			OrdineDelGiorno ordine) {
		return processoErogazioneRepository.findByOrdineDelGiorno(ordine);
	}

	@Override
	public ProcessoErogazione rinviaProcessoErogazione(ProcessoErogazione processo,OrdineDelGiorno ordine) {
		BigInteger idProcesso = processo.getId();
		BigInteger idOrdine = ordine.getId();
		processo = processoErogazioneRepository.findOne(idProcesso);
		ordine = ordineDelGiornoRepository.findOne(idOrdine);
		if(processo == null){
			throw new ApplicationException("Processo non trovato per id "+idProcesso);
		}
		if(ordine == null){
			throw new ApplicationException("Ordine non trovato per id "+idOrdine);
		}
		processo.rinvia(ordine);
		return processoErogazioneRepository.save(processo);
	}

	@Override
	@Transactional(readOnly=true)
	public Set<ProcessoErogazione> getProcessiErogazioneInLavorazione(OrdineDelGiorno ordine) {
		return processoErogazioneRepository.findByOrdineDelGiornoAndLavorazioneContabileIn(ordine,StatoLavorazioneContabile.LAVORABILE,StatoLavorazioneContabile.IN_INSERIMENTO);
	}

	@Override
	@Transactional(readOnly=true)
	public Set<ProcessoErogazione> getProcessiErogazioneLavorati(OrdineDelGiorno ordine) {
		return processoErogazioneRepository.findByOrdineDelGiornoAndLavorazioneContabileIn(ordine,StatoLavorazioneContabile.LAVORATO);
	}

	@Override
	@Transactional(readOnly=true)
	public Set<ProcessoErogazione> getProcessiErogazioneLavorabili(OrdineDelGiorno ordine) {
		return processoErogazioneRepository.findByOrdineDelGiornoAndLavorazioneContabileIn(ordine,StatoLavorazioneContabile.LAVORABILE);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<ProcessoErogazione> searchProcessiErogazione(ProcessoFilter req) {
		return 	processoErogazioneRepository.findAll(req.getSpecification(),req.getPageable());
	}

	@Override
	public LavorazioneContabile lavorazioneContabile(ProcessoErogazione processo) {
		processo = processoErogazioneRepository.findOne(processo.getId());
		LavorazioneContabile lavorazioneContabile = new LavorazioneContabile();
		lavorazioneContabile.eseguiLavorazione(processo);
		praticaErogazioneRepository.save(lavorazioneContabile.getPraticheLavorate());
		processoErogazioneRepository.save(lavorazioneContabile.getProcessiLavorati());
		return lavorazioneContabile;
	}

}
