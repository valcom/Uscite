/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerComitatoFullDTO.class)
public abstract class AssemblerAggiungiComitato {
	public abstract OrdineDelGiorno assemble(AggiungiComitato_InDTO aggiungiComitato_InDTO);

	public AggiungiComitato_OutDTO assemble(OrdineDelGiorno ordineDelGiorno){
		return map(new Container<OrdineDelGiorno>(ordineDelGiorno));
	}

	protected abstract AggiungiComitato_OutDTO map(Container<OrdineDelGiorno> ordineDelGiorno);
}
