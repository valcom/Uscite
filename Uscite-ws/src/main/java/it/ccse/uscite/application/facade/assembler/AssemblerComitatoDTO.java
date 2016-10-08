/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerComitatoDTO {
	public ComitatoDTO map(OrdineDelGiorno ordineDelGiorno);

	public OrdineDelGiorno map(ComitatoDTO comitatoDTO);

}
