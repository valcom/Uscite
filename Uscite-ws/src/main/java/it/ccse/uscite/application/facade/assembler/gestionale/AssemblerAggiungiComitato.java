/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAggiungiComitato extends Assembler {
	public OrdineDelGiorno assemble(AggiungiComitato_InDTO aggiungiComitato_InDTO) {
		return getMapper().map(aggiungiComitato_InDTO, OrdineDelGiorno.class);
	}

	public AggiungiComitato_OutDTO assemble(OrdineDelGiorno ordineDelGiorno) {
		return getMapper().map(new Container<OrdineDelGiorno>(ordineDelGiorno) {
		}, AggiungiComitato_OutDTO.class);
	}
}
