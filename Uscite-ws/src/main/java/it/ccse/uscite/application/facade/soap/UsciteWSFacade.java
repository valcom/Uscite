/**
 * 
 */
package it.ccse.uscite.application.facade.soap;

import javax.jws.WebService;

import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;

/**
 * @author vcompagnone
 *
 */
@WebService(name="UsciteWS",targetNamespace="it.ccse.uscite")
public interface UsciteWSFacade {
	
	/**
	 * @param searchPratiche_InDTO
	 * @return
	 */
	public SearchPratiche_OutDTO searchPratiche(SearchPratiche_InDTO searchPratiche_InDTO);
	
	/**
	 * @param aggiornaSemaforiAnagrafica_InDTO
	 * @return
	 */
	public AggiornaSemaforiAnagrafica_OutDTO aggiornaSemaforiAnagrafica(AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO);
	
	/**
	 * @param aggiornaFideiussione_InDTO
	 * @return
	 */
	public AggiornaFideiussione_OutDTO aggiornaFideiussione(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO);
}
