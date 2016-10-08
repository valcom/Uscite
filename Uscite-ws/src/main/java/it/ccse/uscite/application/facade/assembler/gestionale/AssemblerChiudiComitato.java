/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerComitatoFullDTO.class)
public abstract class AssemblerChiudiComitato {
	
	public abstract OrdineDelGiorno assemble(ChiudiComitato_InDTO chiudiComitato_InDTO);
	
	public ChiudiComitato_OutDTO assemble(OrdineDelGiorno ordineDelGiorno){
		
		return mapToChiudiComitato_OutDTO(new Container<OrdineDelGiorno>(ordineDelGiorno));
	}
	
	protected abstract ChiudiComitato_OutDTO mapToChiudiComitato_OutDTO(Container<OrdineDelGiorno> container);


}
