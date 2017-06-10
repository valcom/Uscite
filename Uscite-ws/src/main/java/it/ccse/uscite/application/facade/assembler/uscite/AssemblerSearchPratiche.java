/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;

/**
 * @author valer
 *
 */
@Component
public class AssemblerSearchPratiche extends Assembler{

	
	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche) {
		return getMapper().map(pratiche, SearchPratiche_OutDTO.class);
	}

	
	public PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO) {
		return getMapper().map(searchPratiche_InDTO,PraticaFilter.class);
	}

}
