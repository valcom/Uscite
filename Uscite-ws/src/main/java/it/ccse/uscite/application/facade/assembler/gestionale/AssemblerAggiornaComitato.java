package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;


@Mapper(uses=AssemblerComitatoFullDTO.class)
public abstract class AssemblerAggiornaComitato {
	public abstract OrdineDelGiorno assemble(AggiornaComitato_InDTO aggiornaComitato_InDTO);
	public AggiornaComitato_OutDTO assemble(OrdineDelGiorno ordineDelGiorno){
		
		return map(new Container<OrdineDelGiorno>(ordineDelGiorno));
		
	}
	
	protected abstract AggiornaComitato_OutDTO map(Container<OrdineDelGiorno> ordineDelGiorno);

}
