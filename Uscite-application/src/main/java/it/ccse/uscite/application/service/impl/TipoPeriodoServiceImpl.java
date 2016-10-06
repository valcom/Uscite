/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.ccse.uscite.application.service.TipoPeriodoService;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.repository.TipoPeriodoRepository;

/**
 * @author vcompagnone
 *
 */
@Service
public class TipoPeriodoServiceImpl implements TipoPeriodoService {

	@Autowired
	private TipoPeriodoRepository tipoPeriodoRepository;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.service.TipoPeriodoService#getTipiPeriodo()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<TipoPeriodo> getTipiPeriodo() {
		return tipoPeriodoRepository.findAll();
	}

}
