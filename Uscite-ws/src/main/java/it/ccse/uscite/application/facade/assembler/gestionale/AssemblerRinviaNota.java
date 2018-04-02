/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerRinviaNota extends Assembler {
	public OrdineDelGiorno assembleOrdineDelGiorno(RinviaNota_InDTO rinviaNota_InDTO) {
		return getMapper().map(rinviaNota_InDTO, OrdineDelGiorno.class);
	}

	public ProcessoErogazione assembleProcessoErogazione(RinviaNota_InDTO rinviaNota_InDTO) {
		return getMapper().map(rinviaNota_InDTO, ProcessoErogazione.class);
	}

	public RinviaNota_OutDTO assemble(ProcessoErogazione processoErogazione) {
		return getMapper().map(new Container<ProcessoErogazione>(processoErogazione) {
		}, RinviaNota_OutDTO.class);
	}
}
