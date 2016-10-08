/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerDirection;
import it.ccse.uscite.application.facade.assembler.util.PageWrapper;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.filter.ProcessoFilter;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerDirection.class,AssemblerDettaglioNotaPagamentoDTO.class})
public abstract class AssemblerSearchNote {
	public abstract ProcessoFilter assemble(SearchNote_InDTO searchNote_InDTO);
	
	public SearchNote_OutDTO assemble(Page<ProcessoErogazione> pageProcessiErogazione){
		return mapToSearchNote_OutDTO(new PageWrapper<ProcessoErogazione>(pageProcessiErogazione));
	}
	
	protected abstract SearchNote_OutDTO mapToSearchNote_OutDTO(PageWrapper<ProcessoErogazione> container);
	
}
