/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite.impl.dozer;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;

/**
 * @author valer
 *
 */
@Component
public class AssemblerSearchPraticheDozer implements AssemblerSearchPratiche {

	@Autowired
	private Mapper mapper; 
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche#assemble(org.springframework.data.domain.Page)
	 */
	@Override
	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche) {
		SearchPratiche_OutDTO outDTO = mapper.map(pratiche, SearchPratiche_OutDTO.class);
		return outDTO;
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche#assemble(it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO)
	 */
	@Override
	public PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO) {
		return mapper.map(searchPratiche_InDTO, PraticaFilter.class);
	}

}
