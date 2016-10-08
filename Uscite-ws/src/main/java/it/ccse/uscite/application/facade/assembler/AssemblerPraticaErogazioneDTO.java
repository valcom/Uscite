/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerTipoPeriodoDTO.class)
public interface AssemblerPraticaErogazioneDTO {

	public PraticaErogazioneDTO map(PraticaErogazione pratica);

	public PraticaErogazione map(PraticaErogazioneDTO pratica);

}
