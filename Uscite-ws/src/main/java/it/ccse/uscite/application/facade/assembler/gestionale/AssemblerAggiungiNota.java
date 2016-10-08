/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerComitatoDTO.class,AssemblerDettaglioNotaPagamentoDTO.class})
public abstract class AssemblerAggiungiNota {
	public abstract ProcessoErogazione assemble(AggiungiNota_InDTO aggiungiNota_InDTO);

	public AggiungiNota_OutDTO assemble(ProcessoErogazione processo){
		return mapToAggiungiNota_OutDTO(new Container<ProcessoErogazione>(processo));
	}
	
	protected abstract AggiungiNota_OutDTO mapToAggiungiNota_OutDTO(Container<ProcessoErogazione> processo);

	
}
