/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAggiornaNota extends Assembler {
	public ProcessoErogazione assemble(AggiornaNota_InDTO aggiornaNota_InDTO) {
		return getMapper().map(aggiornaNota_InDTO, ProcessoErogazione.class);
	}

	public AggiornaNota_OutDTO assemble(ProcessoErogazione processo) {
		return getMapper().map(new Container<ProcessoErogazione>(processo) {
		}, AggiornaNota_OutDTO.class);
	}
}
