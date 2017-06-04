/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite.impl.modelmapper;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaFideiussione;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.AggiornaFideiussioneDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;

/**
 * @author Valerio
 *
 */
@Component
public class AssemblerAggiornaFideiussioneModelMapper implements AssemblerAggiornaFideiussione {

	@Autowired
	private ModelMapper mapper;
	
	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaFideiussione#assemble(java.util.Collection)
	 */
	@Override
	public AggiornaFideiussione_OutDTO assemble(Collection<PraticaErogazione> pratiche) {
		return mapper.map(new Container<>(pratiche), AggiornaFideiussione_OutDTO.class);
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaFideiussione#assemble(it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO)
	 */
	@Override
	public Map<String, FideiussionePratica> assemble(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		Map<String, FideiussionePratica> map = null;
		if(aggiornaFideiussione_InDTO!=null && aggiornaFideiussione_InDTO.getContent()!=null){
			map = aggiornaFideiussione_InDTO.getContent().stream().collect(Collectors.toMap(AggiornaFideiussioneDTO::getCodicePratica, AggiornaFideiussioneDTO::getFideiussione));
		}
		return map;
	}

}
