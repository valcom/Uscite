/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerNotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerNotaPagamentoFullDTO.class)
public abstract class  AssemblerRinviaNota {
	public abstract OrdineDelGiorno assembleOrdineDelGiorno(RinviaNota_InDTO rinviaNota_InDTO);
	public abstract ProcessoErogazione assembleProcessoErogazione(RinviaNota_InDTO rinviaNota_InDTO);
	
	protected abstract RinviaNota_OutDTO mapToRinviaNota_OutDTO(Container<ProcessoErogazione> container);
	
	public RinviaNota_OutDTO assemble(ProcessoErogazione processoErogazione){
		return mapToRinviaNota_OutDTO(new Container<ProcessoErogazione>(processoErogazione));
	}
	
}
