/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerEliminaComitato {
	
	public OrdineDelGiorno assemble(EliminaComitato_InDTO eliminaComitato_InDTO);

}
