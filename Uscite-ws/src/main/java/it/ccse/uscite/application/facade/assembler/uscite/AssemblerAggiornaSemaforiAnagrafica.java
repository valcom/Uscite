package it.ccse.uscite.application.facade.assembler.uscite;

import java.util.Collection;

import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.SettoreAttivita;

public interface AssemblerAggiornaSemaforiAnagrafica {

	Collection<SettoreAttivita> assemble(AggiornaSemaforiAnagrafica_InDTO inDTO);

	AggiornaSemaforiAnagrafica_OutDTO assemble(Collection<PraticaErogazione> pratiche);

}