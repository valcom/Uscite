/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.Collection;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.domain.StatoLegale;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerGetStatiLegali extends Assembler{
	
	public GetStatiLegali_OutDTO assemble(Collection<StatoLegale> statiLegale){
		
		return getMapper().map(new Container<Collection<StatoLegale>>(statiLegale){}, GetStatiLegali_OutDTO.class);
	}
}
