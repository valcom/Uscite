/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.ccse.uscite.application.service.OrdineDelGiornoService;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;
import it.ccse.uscite.domain.OrdineDelGiorno.TipologiaComitato;
import it.ccse.uscite.domain.exception.ApplicationException;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.domain.repository.OrdineDelGiornoRepository;

/**
 * @author vcompagnone
 *
 */
@Service
@Transactional(readOnly = false)
public class OrdineDelGiornoServiceImpl implements OrdineDelGiornoService {
	@Autowired
	private OrdineDelGiornoRepository ordineDelGiornoRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<OrdineDelGiorno> getOrdiniDelGiorno(Pageable p) {
		return ordineDelGiornoRepository.findAll(p);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrdineDelGiorno> getOrdiniDelGiorno() {
		return ordineDelGiornoRepository.findAll();
	}

	@Override
	public OrdineDelGiorno createOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		ordineDelGiorno.checkInserimento();
		Date dataComitato = ordineDelGiorno.getDataComitato();
		if (ordineDelGiornoRepository.findByDataComitato(dataComitato) != null) {
			throw new ApplicationException("error.comitato.data.duplicate.insert");
		}
		return ordineDelGiornoRepository.save(ordineDelGiorno);
	}

	@Override
	public OrdineDelGiorno apriOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		ordineDelGiorno = ordineDelGiornoRepository.getOne(ordineDelGiorno.getId());
		ordineDelGiorno.apri();
		return ordineDelGiornoRepository.save(ordineDelGiorno);
	}

	@Override
	public OrdineDelGiorno chiudiOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		ordineDelGiorno = ordineDelGiornoRepository.getOne(ordineDelGiorno.getId());
		ordineDelGiorno.chiudi();
		return ordineDelGiornoRepository.save(ordineDelGiorno);
	}

	@Override
	public OrdineDelGiorno updateOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		Date dataComitato = ordineDelGiorno.getDataComitato();
		String descrizione = ordineDelGiorno.getDescrizione();
		Integer numeroComitato = ordineDelGiorno.getNumeroComitato();
		TipologiaComitato tipologia = ordineDelGiorno.getTipologia();
		BigInteger idComitato = ordineDelGiorno.getId();
		ordineDelGiorno = ordineDelGiornoRepository.getOne(idComitato);
		if (ordineDelGiorno == null) {
			throw new RuntimeException("Comitato non trovato id:" + idComitato);
		}
		ordineDelGiorno.aggiorna(dataComitato, descrizione, numeroComitato, tipologia);
		return ordineDelGiornoRepository.save(ordineDelGiorno);
	}

	@Override
	public void eliminaOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		ordineDelGiornoRepository.delete(ordineDelGiorno);
	}

	@Override
	@Transactional(readOnly = true)
	public Set<OrdineDelGiorno> getOrdiniDelGiornoAutorizzabili() {
		Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
		return ordineDelGiornoRepository.findByDataComitatoLessThanEqualAndStato(today, StatoComitato.CHIUSO);
	}

	@Override
	public Page<OrdineDelGiorno> searchComitati(OrdineDelGiornoFilter req) {
		return ordineDelGiornoRepository.findAll(req, req.getPageable());
	}

	@Override
	public OrdineDelGiorno getOrdineDelGiorno(BigInteger idOrdineDelGiorno) {
		return ordineDelGiornoRepository.getOne(idOrdineDelGiorno);
	}
}
