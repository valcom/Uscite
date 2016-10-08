/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.domain.SettoreAttivita;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerSettoreAttivitaDTO {
	public SettoreAttivitaDTO map(SettoreAttivita settoreAttivita);
	
	public SettoreAttivita map(SettoreAttivitaDTO settoreAttivitaDTO);


}
