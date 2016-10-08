package it.ccse.uscite.application.facade.assembler.uscite;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerDirection;
import it.ccse.uscite.application.facade.assembler.AssemblerTipoPeriodoDTO;
import it.ccse.uscite.application.facade.assembler.util.PageWrapper;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;

@Mapper(uses={AssemblerDettaglioPraticaErogazioneDTO.class,AssemblerDirection.class,AssemblerTipoPeriodoDTO.class})
public abstract class AssemblerSearchPratiche {

	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche){
		return map(new PageWrapper<PraticaErogazione>(pratiche));

	}

	protected abstract SearchPratiche_OutDTO map(PageWrapper<PraticaErogazione> wrapperPage)  ;

	public abstract PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO);

}
