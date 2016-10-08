/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerNotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerNotaPagamentoFullDTO.class)
public abstract class AssemblerChiudiNota {

	public abstract ProcessoErogazione assemble(ChiudiNota_InDTO chiudiNota_InDTO);
	
	
	public ChiudiNota_OutDTO assemble(ProcessoErogazione processoErogazione){
		return mapToChiudiNota_OutDTO(new Container<ProcessoErogazione>(processoErogazione));
	}

	
	protected abstract ChiudiNota_OutDTO mapToChiudiNota_OutDTO(Container<ProcessoErogazione> container);
}
