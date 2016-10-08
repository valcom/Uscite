/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite;

import java.util.Collection;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerSettoreAttivitaDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.SettoreAttivita;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerSettoreAttivitaDTO.class,AssemblerPraticaErogazioneDTO.class})
public abstract class AssemblerAggiornaSemaforiAnagrafica {
	public Collection<SettoreAttivita> assemble(AggiornaSemaforiAnagrafica_InDTO inDTO){
		Container<Collection<SettoreAttivita>> container = mapToContainer(inDTO);
		return container!=null?container.getContent():null;
	}
	
	protected abstract Container<Collection<SettoreAttivita>> mapToContainer(AggiornaSemaforiAnagrafica_InDTO inDTO);
	
	public AggiornaSemaforiAnagrafica_OutDTO assemble(Collection<PraticaErogazione> pratiche){
		return map(new Container<Collection<PraticaErogazione>>(pratiche));
	}

	
	protected abstract AggiornaSemaforiAnagrafica_OutDTO map(Container<Collection<PraticaErogazione>> praticheContainer);
}
