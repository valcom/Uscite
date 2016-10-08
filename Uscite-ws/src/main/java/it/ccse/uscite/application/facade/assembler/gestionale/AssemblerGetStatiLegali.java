/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.Collection;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerStatoLegaleDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.domain.StatoLegale;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerStatoLegaleDTO.class)
public abstract class AssemblerGetStatiLegali {

	protected abstract GetStatiLegali_OutDTO mapToGetStatiLegali_OutDTO(Container<Collection<StatoLegale>> container);
	
	public GetStatiLegali_OutDTO assemble(Collection<StatoLegale> statiLegale){
		
		return mapToGetStatiLegali_OutDTO(new Container<Collection<StatoLegale>>(statiLegale));
	}
}
