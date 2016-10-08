/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerNotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerNotaPagamentoFullDTO.class)
public abstract class AssemblerAggiornaNota {
	public abstract ProcessoErogazione assemble(AggiornaNota_InDTO aggiornaNota_InDTO);

	public AggiornaNota_OutDTO assemble(ProcessoErogazione processo){
		return mapToAggiornaNota_OutDTO(new Container<ProcessoErogazione>(processo));
	}
	
	protected abstract AggiornaNota_OutDTO mapToAggiornaNota_OutDTO(Container<ProcessoErogazione> processo);
	
	
}
