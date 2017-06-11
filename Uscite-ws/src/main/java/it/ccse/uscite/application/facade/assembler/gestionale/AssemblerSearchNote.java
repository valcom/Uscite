/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.filter.ProcessoFilter;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerSearchNote extends Assembler{
	public ProcessoFilter assemble(SearchNote_InDTO searchNote_InDTO){
		return getMapper().map(searchNote_InDTO,ProcessoFilter.class);
	}
	
	public SearchNote_OutDTO assemble(Page<ProcessoErogazione> pageProcessiErogazione){
		return getMapper().map(pageProcessiErogazione,SearchNote_OutDTO.class);
	}
	
	
}
