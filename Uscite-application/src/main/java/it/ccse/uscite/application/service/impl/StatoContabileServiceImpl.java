/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ccse.uscite.application.service.StatoContabileService;
import it.ccse.uscite.domain.StatoContabile;
import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;
import it.ccse.uscite.domain.repository.StatoContabileRepository;

/**
 * @author vcompagnone
 *
 */
@Service
public class StatoContabileServiceImpl implements StatoContabileService {

	@Autowired
	private StatoContabileRepository repository;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.service.StatoContabileService#getStatoContabileIniziale()
	 */
	@Override
	public StatoContabile getStatoContabileIniziale() {
		return repository.findOne(AutorizzazioneContabile.UNDEFINED.name());
	}

}
