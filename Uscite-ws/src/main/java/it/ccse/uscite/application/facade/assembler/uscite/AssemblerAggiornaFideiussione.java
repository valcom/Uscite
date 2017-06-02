package it.ccse.uscite.application.facade.assembler.uscite;

import java.util.Collection;
import java.util.Map;

import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;

public interface AssemblerAggiornaFideiussione {

	AggiornaFideiussione_OutDTO assemble(Collection<PraticaErogazione> pratiche);

	Map<String, FideiussionePratica> assemble(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO);

}