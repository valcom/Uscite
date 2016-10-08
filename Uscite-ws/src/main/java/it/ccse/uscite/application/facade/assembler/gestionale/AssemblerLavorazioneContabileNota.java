/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerPraticaErogazioneDTO.class)
public interface AssemblerLavorazioneContabileNota {
	public ProcessoErogazione assemble(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO);
	
	public LavorazioneContabile_OutDTO assemble(LavorazioneContabile lavorazioneContabile);
}
