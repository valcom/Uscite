/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerApriNota extends Assembler {
	public ProcessoErogazione assemble(ApriNota_InDTO apriNota_InDTO) {
		return getMapper().map(apriNota_InDTO, ProcessoErogazione.class);
	}

	public ApriNota_OutDTO assemble(ProcessoErogazione processo) {
		return getMapper().map(new Container<ProcessoErogazione>(processo) {
		}, ApriNota_OutDTO.class);
	}
}
