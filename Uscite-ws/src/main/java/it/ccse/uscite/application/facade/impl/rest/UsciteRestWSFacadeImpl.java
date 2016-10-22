package it.ccse.uscite.application.facade.impl.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

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
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;

public class UsciteRestWSFacadeImpl implements UsciteRestWSFacade{
	@Autowired
	private AssemblerSearchPratiche assemblerSearchPratiche;
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@GET
	@Path("/pratiche")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Override
	public SearchPratiche_OutDTO searchPratiche(SearchPratiche_InDTO searchPratiche_InDTO) {
		PraticaFilter filter = assemblerSearchPratiche.assemble(searchPratiche_InDTO);
		Page<PraticaErogazione> pratiche = praticaErogazioneService.searchPraticheErogazione(filter);
		return assemblerSearchPratiche.assemble(pratiche);
	}

	@Override
	public SearchNote_OutDTO searchNote(SearchNote_InDTO searchNote_InDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchComitati_OutDTO searchComitati(SearchComitati_InDTO searchComitati_InDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetTipiPeriodo_OutDTO getTipiPeriodo(GetTipiPeriodo_InDTO getTipiPeriodo_InDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetStatiLegali_OutDTO getStatiLegali(GetStatiLegali_InDTO getStatiLegali_InDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
