/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ccse.uscite.application.service.StatoUnbundlingService;
import it.ccse.uscite.domain.StatoUnbundling;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;
import it.ccse.uscite.domain.repository.StatoUnbundlingRepository;

/**
 * @author vcompagnone
 *
 */
@Service
public class StatoUnbundlingServiceImpl implements StatoUnbundlingService {

	@Autowired
	private StatoUnbundlingRepository repository;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.service.StatoUnbundlingService#getStatoUnbundlingIniziale()
	 */
	@Override
	public StatoUnbundling getStatoUnbundlingIniziale() {
		return repository.findOne(UnbundlingPratica.UNDEFINED.name());
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.service.StatoUnbundlingService#getStatiUnbundling()
	 */
	@Override
	public List<StatoUnbundling> getStatiUnbundling() {
		return repository.findAll();
	}

}
