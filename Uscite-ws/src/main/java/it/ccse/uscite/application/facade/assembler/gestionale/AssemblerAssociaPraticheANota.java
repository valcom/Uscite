/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeBuilder;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAssociaPraticheANota extends Assembler{
	
	public ProcessoErogazione assembleProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO){
		return getMapper().map(associaPraticheANota_InDTO, ProcessoErogazione.class);
	}

	public List<PraticaErogazione> assembleListaPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO){
		Type<Container<List<PraticaErogazione>>> targetType   = new TypeBuilder<Container<List<PraticaErogazione>>>(){}.build();
		Type<AssociaPraticheANota_InDTO> sourceType  = new TypeBuilder<AssociaPraticheANota_InDTO>(){}.build();
		return getMapper().map(associaPraticheANota_InDTO,sourceType,targetType).getContent();
	}

	
	public AssociaPraticheANota_OutDTO assemble(ProcessoErogazione processo){
		return getMapper().map(new Container<ProcessoErogazione>(processo),AssociaPraticheANota_OutDTO.class);
	}
	
	
}
