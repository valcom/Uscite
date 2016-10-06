/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.List;

import it.ccse.uscite.domain.StatoFideiussione;

/**
 * @author vcompagnone
 *
 */
public interface StatoFideiussioneService {

	StatoFideiussione getStatoFideiussioneIniziale();

	List<StatoFideiussione> getStatiFideiussione();

}
