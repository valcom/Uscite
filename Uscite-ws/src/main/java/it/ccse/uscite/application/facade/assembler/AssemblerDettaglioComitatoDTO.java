/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioComitatoDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerDettaglioComitatoDTO{
	
	public DettaglioComitatoDTO map(OrdineDelGiorno ordineDelGiorno);
	
}
