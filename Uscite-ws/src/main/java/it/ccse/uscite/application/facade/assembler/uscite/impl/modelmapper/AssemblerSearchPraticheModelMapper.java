/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite.impl.modelmapper;

import org.modelmapper.ModelMapper;
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
public class AssemblerSearchPraticheModelMapper implements AssemblerSearchPratiche {

	@Autowired
	private ModelMapper modelMapper;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche#assemble(org.springframework.data.domain.Page)
	 */
	@Override
	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche) {
		// TODO Auto-generated method stub
		return modelMapper.map(pratiche, SearchPratiche_OutDTO.class);
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche#assemble(it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO)
	 */
	@Override
	public PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO) {
		// TODO Auto-generated method stub
		return modelMapper.map(searchPratiche_InDTO, PraticaFilter.class);
	}

}
