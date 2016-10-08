/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerEliminaNota {
	
	public ProcessoErogazione assemble(EliminaNota_InDTO eliminaNota_InDTO);

}
