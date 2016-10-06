/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import it.ccse.uscite.application.service.StatoLegaleService;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.repository.StatoLegaleRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author vcompagnone
 *
 */
@Service
@Transactional(readOnly=false)
public class StatoLegaleServiceImpl implements StatoLegaleService {

	@Autowired
	private StatoLegaleRepository repository;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.service.StatoLegaleService#getStatiLegali()
	 */
	@Transactional(readOnly=true)
	@Override
	public List<StatoLegale> getStatiLegali() {
		return repository.findAll();
	}

	@Override
	public StatoLegale getStatoLegaleIniziale() {
		return repository.findOne(AutorizzazioneLegale.UNDEFINED.name());
	}

}
