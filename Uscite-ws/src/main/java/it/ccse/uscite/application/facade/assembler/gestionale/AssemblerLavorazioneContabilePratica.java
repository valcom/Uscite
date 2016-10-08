/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerPraticaErogazioneDTO.class)
public abstract class AssemblerLavorazioneContabilePratica {
	
	public List<PraticaErogazione> assemble(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO){
		Container<List<PraticaErogazione>> container = mapToContainer(lavorazioneContabilePratica_InDTO);
		return container!=null?container.getContent():null;
	}
	
	protected abstract Container<List<PraticaErogazione>> mapToContainer(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO);

	public abstract LavorazioneContabile_OutDTO assemble(LavorazioneContabile lavorazioneContabile);

}
