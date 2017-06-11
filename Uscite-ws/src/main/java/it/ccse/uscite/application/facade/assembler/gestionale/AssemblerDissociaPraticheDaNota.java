/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerDissociaPraticheDaNota extends Assembler{

	public List<PraticaErogazione> assembleListaPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO){	
		return getMapper().mapAsList(dissociaPraticheDaNota_InDTO.getContent(), PraticaErogazione.class);
	}
	
	public ProcessoErogazione assembleProcessoErogazione(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO){
		return getMapper().map(dissociaPraticheDaNota_InDTO,ProcessoErogazione.class);
	}
	
}
