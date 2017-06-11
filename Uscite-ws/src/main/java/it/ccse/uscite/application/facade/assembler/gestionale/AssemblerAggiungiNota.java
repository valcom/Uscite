/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAggiungiNota extends Assembler{
	public ProcessoErogazione assemble(AggiungiNota_InDTO aggiungiNota_InDTO){
		return getMapper().map(aggiungiNota_InDTO, ProcessoErogazione.class);
	}

	public AggiungiNota_OutDTO assemble(ProcessoErogazione processo){
		return getMapper().map(new Container<ProcessoErogazione>(processo),AggiungiNota_OutDTO.class);
	}
	

	
}
