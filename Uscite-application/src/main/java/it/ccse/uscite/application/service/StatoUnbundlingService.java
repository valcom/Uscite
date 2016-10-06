/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.List;

import it.ccse.uscite.domain.StatoUnbundling;

/**
 * @author vcompagnone
 *
 */
public interface StatoUnbundlingService {

	StatoUnbundling getStatoUnbundlingIniziale();

	List<StatoUnbundling> getStatiUnbundling();

}
