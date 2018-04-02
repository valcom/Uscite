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
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerDissociaPraticheDaNota extends Assembler {
	public List<PraticaErogazione> assembleListaPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO) {
		Type type = new TypeToken<Collection<PraticaErogazione>>() {
		}.getType();
		return getMapper().map(dissociaPraticheDaNota_InDTO.getContent(), type);
	}

	public ProcessoErogazione assembleProcessoErogazione(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO) {
		return getMapper().map(dissociaPraticheDaNota_InDTO, ProcessoErogazione.class);
	}
}
