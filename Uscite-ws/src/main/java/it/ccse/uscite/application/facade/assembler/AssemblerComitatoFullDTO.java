/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.ComitatoFullDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerNotaPagamentoFullDTO.class)
public interface AssemblerComitatoFullDTO {
	public ComitatoFullDTO map(OrdineDelGiorno ordineDelGiorno);

}
