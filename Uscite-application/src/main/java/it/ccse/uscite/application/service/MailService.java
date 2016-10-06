/**
 * 
 */
package it.ccse.uscite.application.service;

import it.ccse.uscite.domain.PraticaErogazione;

import java.util.List;

/**
 * @author vcompagnone
 *
 */
public interface MailService {
	
	void sendMailAutorizzazioneComitato(List<PraticaErogazione> pratiche);
	
	void sendMailSbloccoAnagraficaPratiche(List<PraticaErogazione> pratiche);
	
}
