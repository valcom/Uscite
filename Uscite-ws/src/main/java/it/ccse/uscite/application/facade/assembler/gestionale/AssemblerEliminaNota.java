/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerEliminaNota extends Assembler{
	
	public ProcessoErogazione assemble(EliminaNota_InDTO eliminaNota_InDTO){
		return getMapper().map(eliminaNota_InDTO,ProcessoErogazione.class);
	}

}
