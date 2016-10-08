/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioComitatoDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerDirection;
import it.ccse.uscite.application.facade.assembler.util.PageWrapper;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerDirection.class,AssemblerDettaglioComitatoDTO.class})
public abstract class AssemblerSearchComitati {
	public abstract OrdineDelGiornoFilter assemble(SearchComitati_InDTO searchComitati_InDTO);
	
	public SearchComitati_OutDTO assemble(Page<OrdineDelGiorno> ordineDelGiornoPage){
		return map(new PageWrapper<OrdineDelGiorno>(ordineDelGiornoPage));

	}

	protected abstract SearchComitati_OutDTO map(PageWrapper<OrdineDelGiorno> wrapperPage)  ;
	
}
