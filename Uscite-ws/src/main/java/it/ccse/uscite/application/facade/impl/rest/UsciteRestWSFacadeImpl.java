package it.ccse.uscite.application.facade.impl.rest;

import java.util.Collection;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerGetStatiLegali;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerGetTipiPeriodo;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerSearchComitati;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerSearchNote;
import it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetStatiLegali_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetTipiPeriodo_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.application.facade.rest.UsciteRestWSFacade;
import it.ccse.uscite.application.service.OrdineDelGiornoService;
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.application.service.ProcessoErogazioneService;
import it.ccse.uscite.application.service.StatoLegaleService;
import it.ccse.uscite.application.service.TipoPeriodoService;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.domain.filter.PraticaFilter;
import it.ccse.uscite.domain.filter.ProcessoFilter;

@Path("/")
@Service("usciteRestWSFacade")
@Transactional
public class UsciteRestWSFacadeImpl implements UsciteRestWSFacade{
	@Autowired
	@Qualifier("assemblerSearchPraticheDozer")
	private AssemblerSearchPratiche assemblerSearchPratiche;
	
	@Autowired
	private AssemblerSearchComitati assemblerSearchComitati;
	
	@Autowired
	private AssemblerSearchNote assemblerSearchNote;
	
	@Autowired
	private AssemblerGetStatiLegali assemblerGetStatiLegali;
	
	@Autowired
	private AssemblerGetTipiPeriodo assemblerGetTipiPeriodo;
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Autowired
	private OrdineDelGiornoService ordineDelGiornoService;
	
	@Autowired
	private ProcessoErogazioneService processoErogazioneService;
	
	@Autowired
	private TipoPeriodoService tipoPeriodoService;
	
	@Autowired
	private StatoLegaleService statoLegaleService;
	
	@GET
	@Path("/pratiche")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Override
	public SearchPratiche_OutDTO searchPratiche(@BeanParam SearchPratiche_InDTO searchPratiche_InDTO) {
		PraticaFilter filter = assemblerSearchPratiche.assemble(searchPratiche_InDTO);
		Page<PraticaErogazione> pratiche = praticaErogazioneService.searchPraticheErogazione(filter);
		return assemblerSearchPratiche.assemble(pratiche);
	}

	@GET
	@Path("/note")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Override
	public SearchNote_OutDTO searchNote(@BeanParam SearchNote_InDTO searchNote_InDTO) {
		ProcessoFilter req = assemblerSearchNote.assemble(searchNote_InDTO);
		return assemblerSearchNote.assemble(processoErogazioneService.searchProcessiErogazione(req));
	}

	@GET
	@Path("/comitati")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Override
	public SearchComitati_OutDTO searchComitati(@BeanParam SearchComitati_InDTO searchComitati_InDTO) {
		OrdineDelGiornoFilter req = assemblerSearchComitati.assemble(searchComitati_InDTO);
		return  assemblerSearchComitati.assemble(ordineDelGiornoService.searchComitati(req));
	}

	@GET
	@Path("/tipiPeriodo")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Override
	public GetTipiPeriodo_OutDTO getTipiPeriodo(@BeanParam GetTipiPeriodo_InDTO getTipiPeriodo_InDTO) {
		Collection<TipoPeriodo> tipiPeriodo = tipoPeriodoService.getTipiPeriodo();
		return assemblerGetTipiPeriodo.assemble(tipiPeriodo);
	}

	@GET
	@Path("/statiLegali")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Override
	public GetStatiLegali_OutDTO getStatiLegali(@BeanParam GetStatiLegali_InDTO getStatiLegali_InDTO) {
		Collection<StatoLegale> statiLegali = statoLegaleService.getStatiLegali();
		return assemblerGetStatiLegali.assemble(statiLegali);
	}

}
