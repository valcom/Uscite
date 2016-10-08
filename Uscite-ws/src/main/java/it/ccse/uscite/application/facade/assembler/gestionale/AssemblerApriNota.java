/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerNotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerNotaPagamentoFullDTO.class)
public abstract class AssemblerApriNota {
	public abstract ProcessoErogazione assemble(ApriNota_InDTO apriNota_InDTO);
	
	public ApriNota_OutDTO assemble(ProcessoErogazione processo){
		return mapToApriNota_OutDTO(new Container<ProcessoErogazione>(processo));
	}
	
	protected abstract ApriNota_OutDTO mapToApriNota_OutDTO(Container<ProcessoErogazione> processo);
}
