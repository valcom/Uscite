/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses = AssemblerPraticaErogazioneDTO.class)
public abstract class AssemblerRifiutaAutorizzazioneComitato {
	
	public List<PraticaErogazione> assemble(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitato_InDTO){
		Container<List<PraticaErogazione>> container = map(rifiutaAutorizzazioneComitato_InDTO);
		return container!=null ? container.getContent():null;
		
	}
	
	protected abstract Container<List<PraticaErogazione>> map(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitato_InDTO);

}
