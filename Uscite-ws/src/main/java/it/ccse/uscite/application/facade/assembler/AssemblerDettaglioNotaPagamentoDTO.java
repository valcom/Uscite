/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioNotaPagamentoDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerComitatoDTO.class})
public interface AssemblerDettaglioNotaPagamentoDTO {
	
	public DettaglioNotaPagamentoDTO map(ProcessoErogazione p);

}
