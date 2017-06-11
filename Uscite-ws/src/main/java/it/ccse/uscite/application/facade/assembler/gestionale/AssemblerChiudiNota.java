/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerChiudiNota extends Assembler{

	public ProcessoErogazione assemble(ChiudiNota_InDTO chiudiNota_InDTO){
		return getMapper().map(chiudiNota_InDTO,ProcessoErogazione.class);
	}
	
	
	public ChiudiNota_OutDTO assemble(ProcessoErogazione processoErogazione){
		return getMapper().map(new Container<ProcessoErogazione>(processoErogazione),ChiudiNota_OutDTO.class);
	}

	
}
