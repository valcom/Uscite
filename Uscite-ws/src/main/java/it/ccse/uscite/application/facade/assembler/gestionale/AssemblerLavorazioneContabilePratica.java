/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

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
public class AssemblerLavorazioneContabilePratica extends Assembler{
	
	public List<PraticaErogazione> assemble(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO){
		return getMapper().mapAsList(lavorazioneContabilePratica_InDTO.getContent(), PraticaErogazione.class);
	}
	

	public LavorazioneContabile_OutDTO assemble(LavorazioneContabile lavorazioneContabile){
		return getMapper().map(lavorazioneContabile,LavorazioneContabile_OutDTO.class);
	}

}
