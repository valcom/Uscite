/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerApriComitato extends Assembler {
	public OrdineDelGiorno assemble(ApriComitato_InDTO apriComitato_InDTO) {
		return getMapper().map(apriComitato_InDTO, OrdineDelGiorno.class);
	}

	public ApriComitato_OutDTO assemble(OrdineDelGiorno OrdineDelGiorno) {
		return getMapper().map(new Container<OrdineDelGiorno>(OrdineDelGiorno) {
		}, ApriComitato_OutDTO.class);
	}
}
