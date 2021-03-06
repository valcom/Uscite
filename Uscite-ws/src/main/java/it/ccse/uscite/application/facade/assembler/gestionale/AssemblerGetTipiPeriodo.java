/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.Collection;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerGetTipiPeriodo extends Assembler{
	
	public GetTipiPeriodo_OutDTO assemble(Collection<TipoPeriodo> tipiPeriodo){
		return getMapper().map(new Container<Collection<TipoPeriodo>>(tipiPeriodo){},GetTipiPeriodo_OutDTO.class);
	}
	
}
