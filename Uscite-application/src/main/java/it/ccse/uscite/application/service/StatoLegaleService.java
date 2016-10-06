/**
 * 
 */
package it.ccse.uscite.application.service;

import it.ccse.uscite.domain.StatoLegale;

import java.util.List;

/**
 * @author vcompagnone
 *
 */
public interface StatoLegaleService {
	public List<StatoLegale> getStatiLegali();

	public StatoLegale getStatoLegaleIniziale();
	
}
