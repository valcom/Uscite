/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerEliminaComitato extends Assembler{
	
	public OrdineDelGiorno assemble(EliminaComitato_InDTO eliminaComitato_InDTO){
		 return getMapper().map(eliminaComitato_InDTO,OrdineDelGiorno.class);
	}

}
