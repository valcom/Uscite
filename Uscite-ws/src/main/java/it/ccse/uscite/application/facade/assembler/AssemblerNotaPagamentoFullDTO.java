/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.NotaPagamentoFullDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerComitatoDTO.class,AssemblerPraticaErogazioneDTO.class})
public interface AssemblerNotaPagamentoFullDTO {

	public NotaPagamentoFullDTO map(ProcessoErogazione processoErogazione);

}
