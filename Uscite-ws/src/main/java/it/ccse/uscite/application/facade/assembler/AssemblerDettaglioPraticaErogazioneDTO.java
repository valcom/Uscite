/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerDettaglioNotaPagamentoDTO.class,AssemblerTipoPeriodoDTO.class,AssemblerSettoreAttivitaDTO.class})
public interface AssemblerDettaglioPraticaErogazioneDTO {
	public DettaglioPraticaErogazioneDTO map(PraticaErogazione p);
	
	public PraticaErogazione map(DettaglioPraticaErogazioneDTO p);


}
