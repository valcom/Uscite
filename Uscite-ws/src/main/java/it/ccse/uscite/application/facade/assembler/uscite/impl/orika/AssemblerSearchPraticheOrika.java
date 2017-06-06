package it.ccse.uscite.application.facade.assembler.uscite.impl.orika;

import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;
import ma.glasnost.orika.MapperFacade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssemblerSearchPraticheOrika implements AssemblerSearchPratiche {

	@Autowired
	private MapperFacade mapper;
	
	
	
	@Override
	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche) {
		return mapper.map(pratiche, SearchPratiche_OutDTO.class);
	}

	@Override
	public PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO) {
		return mapper.map(searchPratiche_InDTO,PraticaFilter.class);
	}

}
