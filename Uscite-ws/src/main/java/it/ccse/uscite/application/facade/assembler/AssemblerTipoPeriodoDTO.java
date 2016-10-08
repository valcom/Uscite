/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.TipoPeriodoDTO;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerTipoPeriodoDTO {
	
	public TipoPeriodoDTO map(TipoPeriodo tipoPeriodo);

	public TipoPeriodo map(TipoPeriodoDTO tipoPeriodo); 
	
}
