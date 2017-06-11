/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerLavorazioneContabileNota extends Assembler{
	public ProcessoErogazione assemble(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO){
		return getMapper().map(lavorazioneContabileNota_InDTO,ProcessoErogazione.class);
	}
	
	public LavorazioneContabile_OutDTO assemble(LavorazioneContabile lavorazioneContabile){
		return getMapper().map(lavorazioneContabile,LavorazioneContabile_OutDTO.class);
	}
}
