/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerLavorazioneContabilePratica extends Assembler {
	public List<PraticaErogazione> assemble(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO) {
		Type type = new TypeToken<Collection<PraticaErogazione>>() {
		}.getType();
		return getMapper().map(lavorazioneContabilePratica_InDTO.getContent(), type);
	}

	public LavorazioneContabile_OutDTO assemble(LavorazioneContabile lavorazioneContabile) {
		return getMapper().map(lavorazioneContabile, LavorazioneContabile_OutDTO.class);
	}
}
