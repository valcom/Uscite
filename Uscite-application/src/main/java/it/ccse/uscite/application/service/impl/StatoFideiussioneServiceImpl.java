/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ccse.uscite.application.service.StatoFideiussioneService;
import it.ccse.uscite.domain.StatoFideiussione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.repository.StatoFideiussioneRepository;

/**
 * @author vcompagnone
 *
 */
@Service
public class StatoFideiussioneServiceImpl implements StatoFideiussioneService {
	@Autowired
	private StatoFideiussioneRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoFideiussioneService#
	 * getStatoFideiussioneIniziale()
	 */
	@Override
	public StatoFideiussione getStatoFideiussioneIniziale() {
		return repository.getOne(FideiussionePratica.ASSENTE.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.ccse.uscite.application.service.StatoFideiussioneService#
	 * getStatiFideiussione()
	 */
	@Override
	public List<StatoFideiussione> getStatiFideiussione() {
		return repository.findAll();
	}
}
