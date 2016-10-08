/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerPraticaErogazioneDTO.class)
public abstract class AssemblerAutorizzaComitato {
	
	public abstract Container<List<PraticaErogazione>> mapToContainer(AutorizzaComitato_InDTO autorizzaComitato_InDTO);

	public List<PraticaErogazione> assemble(AutorizzaComitato_InDTO autorizzaComitato_InDTO){
		Container<List<PraticaErogazione>> container = mapToContainer(autorizzaComitato_InDTO);
		
		return container!=null?container.getContent():null;
		
	}
	
}
