/**
 * 
 */
package it.ccse.uscite.application.facade.rest;

import it.ccse.uscite.application.facade.dto.input.gestionale.GetStatiLegali_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetTipiPeriodo_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;

/**
 * @author valer
 *
 */
public interface UsciteRestWSFacade {

	/**
	 * @param searchPratiche_InDTO
	 * @return
	 */
	public SearchPratiche_OutDTO searchPratiche(SearchPratiche_InDTO searchPratiche_InDTO);
	
	/**
	 * @param searchNote_InDTO
	 * @return
	 */
	public SearchNote_OutDTO searchNote(SearchNote_InDTO searchNote_InDTO);
	
	/**
	 * @param searchComitati_InDTO
	 * @return
	 */
	public SearchComitati_OutDTO searchComitati(SearchComitati_InDTO searchComitati_InDTO);

	/**
	 * @param getTipiPeriodo_InDTO
	 * @return
	 */
	public GetTipiPeriodo_OutDTO getTipiPeriodo(GetTipiPeriodo_InDTO getTipiPeriodo_InDTO);
	
	/**
	 * @param getStatiLegali_InDTO
	 * @return
	 */
	public GetStatiLegali_OutDTO getStatiLegali(GetStatiLegali_InDTO getStatiLegali_InDTO);
}
