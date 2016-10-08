/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.LavorazioneContabileDTO;
import it.ccse.uscite.domain.LavorazioneContabile;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerPraticaErogazioneDTO.class})
public interface AssemblerLavorazioneContabileDTO {
	
	public LavorazioneContabile map(LavorazioneContabileDTO lavorazioneDTO);

}
