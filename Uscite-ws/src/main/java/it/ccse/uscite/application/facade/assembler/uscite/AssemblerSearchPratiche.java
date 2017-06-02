/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite;

import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;

/**
 * @author valer
 *
 */
public interface AssemblerSearchPratiche {

	SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche);

	PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO);

}
