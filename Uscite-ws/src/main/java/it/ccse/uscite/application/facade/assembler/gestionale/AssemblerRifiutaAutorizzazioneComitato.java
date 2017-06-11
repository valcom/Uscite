/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerRifiutaAutorizzazioneComitato extends Assembler{
	
	public List<PraticaErogazione> assemble(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitato_InDTO){
		
		return getMapper().mapAsList(rifiutaAutorizzazioneComitato_InDTO.getContent(), PraticaErogazione.class);
		
	}
	

}
