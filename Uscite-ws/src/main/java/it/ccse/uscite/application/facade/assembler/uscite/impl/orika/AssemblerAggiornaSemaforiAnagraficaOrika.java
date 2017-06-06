/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite.impl.orika;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaSemaforiAnagrafica;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import ma.glasnost.orika.MapperFacade;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAggiornaSemaforiAnagraficaOrika implements AssemblerAggiornaSemaforiAnagrafica {

	@Autowired
	private MapperFacade mapper;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaSemaforiAnagrafica#assemble(it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO)
	 */
	@Override
	public Collection<SettoreAttivita> assemble(AggiornaSemaforiAnagrafica_InDTO inDTO) {
		Collection<SettoreAttivita> list = new ArrayList<SettoreAttivita>();
		mapper.map(inDTO.getContent(), list);
		return list;
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaSemaforiAnagrafica#assemble(java.util.Collection)
	 */
	@Override
	public AggiornaSemaforiAnagrafica_OutDTO assemble(Collection<PraticaErogazione> pratiche) {
		return mapper.map(new Container<>(pratiche), AggiornaSemaforiAnagrafica_OutDTO.class);
	}

}
