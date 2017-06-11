/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerChiudiComitato extends Assembler{
	
	public OrdineDelGiorno assemble(ChiudiComitato_InDTO chiudiComitato_InDTO){
		return getMapper().map(chiudiComitato_InDTO,OrdineDelGiorno.class);
	}
	
	public ChiudiComitato_OutDTO assemble(OrdineDelGiorno ordineDelGiorno){
		
		return getMapper().map(new Container<OrdineDelGiorno>(ordineDelGiorno),ChiudiComitato_OutDTO.class);
	}

}
