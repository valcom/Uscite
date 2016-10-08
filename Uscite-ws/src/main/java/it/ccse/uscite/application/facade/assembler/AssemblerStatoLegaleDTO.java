/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.StatoLegaleDTO;
import it.ccse.uscite.domain.StatoLegale;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerStatoLegaleDTO {
	StatoLegaleDTO map(StatoLegale statoLegale);
	
	StatoLegale map(StatoLegaleDTO statoLegaleDTO);

}
