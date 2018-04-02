package it.ccse.uscite.application.facade.assembler.gestionale;

import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

@Component
public class AssemblerAggiornaComitato extends Assembler {
	public OrdineDelGiorno assemble(AggiornaComitato_InDTO aggiornaComitato_InDTO) {
		return getMapper().map(aggiornaComitato_InDTO, OrdineDelGiorno.class);
	}

	public AggiornaComitato_OutDTO assemble(OrdineDelGiorno ordineDelGiorno) {
		return getMapper().map(new Container<OrdineDelGiorno>(ordineDelGiorno) {
		}, AggiornaComitato_OutDTO.class);
	}
}
