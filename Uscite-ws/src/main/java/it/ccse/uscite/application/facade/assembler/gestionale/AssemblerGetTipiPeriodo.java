/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.Collection;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerTipoPeriodoDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerTipoPeriodoDTO.class)
public abstract class AssemblerGetTipiPeriodo {
	
	public GetTipiPeriodo_OutDTO assemble(Collection<TipoPeriodo> tipiPeriodo){
		return mapToGetTipiPeriodo_OutDTO(new Container<Collection<TipoPeriodo>>(tipiPeriodo));
	}
	
	protected abstract GetTipiPeriodo_OutDTO mapToGetTipiPeriodo_OutDTO(Container<Collection<TipoPeriodo>> container);
}
