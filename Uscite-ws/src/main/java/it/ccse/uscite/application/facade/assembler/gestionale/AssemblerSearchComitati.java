/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerSearchComitati extends Assembler{
	public OrdineDelGiornoFilter assemble(SearchComitati_InDTO searchComitati_InDTO){
		return getMapper().map(searchComitati_InDTO, OrdineDelGiornoFilter.class);
	}
	
	public SearchComitati_OutDTO assemble(Page<OrdineDelGiorno> ordineDelGiornoPage){
		return getMapper().map(ordineDelGiornoPage,SearchComitati_OutDTO.class);

	}

	
}
