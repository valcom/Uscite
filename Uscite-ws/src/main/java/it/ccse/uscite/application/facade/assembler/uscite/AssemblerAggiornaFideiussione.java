package it.ccse.uscite.application.facade.assembler.uscite;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.AggiornaFideiussioneDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;

@Component
public class AssemblerAggiornaFideiussione extends Assembler {
	public AggiornaFideiussione_OutDTO assemble(Collection<PraticaErogazione> pratiche) {
		return getMapper().map(new Container<Collection<PraticaErogazione>>(pratiche) {
		}, AggiornaFideiussione_OutDTO.class);
	}

	public Map<String, FideiussionePratica> assemble(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		Map<String, FideiussionePratica> map = null;
		if (aggiornaFideiussione_InDTO != null && aggiornaFideiussione_InDTO.getContent() != null) {
			map = aggiornaFideiussione_InDTO.getContent().stream().collect(Collectors.toMap(AggiornaFideiussioneDTO::getCodicePratica, AggiornaFideiussioneDTO::getFideiussione));
		}
		return map;
	}
}