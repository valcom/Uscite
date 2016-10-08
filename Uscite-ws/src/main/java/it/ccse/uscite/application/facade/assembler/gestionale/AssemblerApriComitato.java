/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerComitatoFullDTO.class)
public abstract class AssemblerApriComitato {
	public abstract OrdineDelGiorno assemble(ApriComitato_InDTO apriComitato_InDTO);
	
	public ApriComitato_OutDTO assemble(OrdineDelGiorno OrdineDelGiorno){
		return mapToApriComitato_OutDTO(new Container<OrdineDelGiorno>(OrdineDelGiorno));
	}
	
	protected abstract ApriComitato_OutDTO mapToApriComitato_OutDTO(Container<OrdineDelGiorno> processo);
}
