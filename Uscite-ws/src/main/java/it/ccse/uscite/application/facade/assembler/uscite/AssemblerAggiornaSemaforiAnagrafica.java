package it.ccse.uscite.application.facade.assembler.uscite;

import java.lang.reflect.Type;
import java.util.Collection;

import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.SettoreAttivita;

@Component
public class AssemblerAggiornaSemaforiAnagrafica extends Assembler {
	public Collection<SettoreAttivita> assemble(AggiornaSemaforiAnagrafica_InDTO inDTO) {
		Type type = new TypeToken<Collection<SettoreAttivita>>() {
		}.getType();
		return getMapper().map(inDTO.getContent(), type);
	}

	public AggiornaSemaforiAnagrafica_OutDTO assemble(Collection<PraticaErogazione> pratiche) {
		AggiornaSemaforiAnagrafica_OutDTO dto = getMapper().map(new Container<Collection<PraticaErogazione>>(pratiche) {
		}, AggiornaSemaforiAnagrafica_OutDTO.class);
		return dto;
	}
}