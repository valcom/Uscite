/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAutorizzaComitato extends Assembler {
	public List<PraticaErogazione> assemble(AutorizzaComitato_InDTO autorizzaComitato_InDTO) {
		Container<List<PraticaErogazione>> c = new Container<List<PraticaErogazione>>() {
		};
		getMapper().map(autorizzaComitato_InDTO.getContent(), c);
		return c.getContent();
	}
}
