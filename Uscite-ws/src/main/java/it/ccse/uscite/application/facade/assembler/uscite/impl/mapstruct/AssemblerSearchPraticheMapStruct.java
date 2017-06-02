package it.ccse.uscite.application.facade.assembler.uscite.impl.mapstruct;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerDirection;
import it.ccse.uscite.application.facade.assembler.AssemblerTipoPeriodoDTO;
import it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche;
import it.ccse.uscite.application.facade.assembler.util.PageWrapper;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;

@Mapper(uses={AssemblerDettaglioPraticaErogazioneDTO.class,AssemblerDirection.class,AssemblerTipoPeriodoDTO.class})
public abstract class AssemblerSearchPraticheMapStruct implements AssemblerSearchPratiche {

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.impl.mapstruct.AssemblerAggiornaFideiussione#assemble(org.springframework.data.domain.Page)
	 */
	@Override
	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche){
		return map(new PageWrapper<PraticaErogazione>(pratiche));

	}

	protected abstract SearchPratiche_OutDTO map(PageWrapper<PraticaErogazione> wrapperPage)  ;

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.impl.mapstruct.AssemblerAggiornaFideiussione#assemble(it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO)
	 */
	@Override
	public abstract PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO);

}
