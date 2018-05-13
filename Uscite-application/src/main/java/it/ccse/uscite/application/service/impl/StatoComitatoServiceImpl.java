/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ccse.uscite.application.service.StatoComitatoService;
import it.ccse.uscite.domain.StatoComitato;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.domain.repository.StatoComitatoRepository;

/**
 * @author vcompagnone
 *
 */
@Service
public class StatoComitatoServiceImpl implements StatoComitatoService {
	@Autowired
	private StatoComitatoRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoComitatoService#
	 * getStatoComitatoIniziale()
	 */
	@Override
	public StatoComitato getStatoComitatoIniziale() {
		return repository.getOne(AutorizzazioneComitato.UNDEFINED.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoComitatoService#
	 * findByAutorizzazioneComitato(it.ccse.uscite.domain.StatoComitato.
	 * AutorizzazioneComitato)
	 */
	@Override
	public StatoComitato findByAutorizzazioneComitato(AutorizzazioneComitato aut) {
		return repository.getOne(aut.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoComitatoService#
	 * getStatoAutorizzazioneComitato()
	 */
	@Override
	public StatoComitato getStatoAutorizzazioneComitato() {
		return repository.getOne(AutorizzazioneComitato.AUTORIZZATO.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoComitatoService#
	 * getStatoRinvioComitato()
	 */
	@Override
	public StatoComitato getStatoRinvioComitato() {
		return repository.getOne(AutorizzazioneComitato.RINVIATA.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoComitatoService#
	 * getStatoRifiutoComitato()
	 */
	@Override
	public StatoComitato getStatoRifiutoComitato() {
		return repository.getOne(AutorizzazioneComitato.NON_AUTORIZZATO.name());
	}
}
