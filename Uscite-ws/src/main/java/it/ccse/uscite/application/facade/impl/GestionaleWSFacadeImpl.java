/**
 * 
 */
package it.ccse.uscite.application.facade.impl;

import java.util.Collection;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.ccse.uscite.application.facade.GestionaleWSFacade;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerAggiornaComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerAggiornaNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerAggiungiComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerAggiungiNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerApriComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerApriNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerAssociaPraticheANota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerAutorizzaComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerChiudiComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerChiudiNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerDissociaPraticheDaNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerEliminaComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerEliminaNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerGetStatiLegali;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerGetTipiPeriodo;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerLavorazioneContabileNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerLavorazioneContabilePratica;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerRifiutaAutorizzazioneComitato;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerRinviaNota;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerSearchComitati;
import it.ccse.uscite.application.facade.assembler.gestionale.AssemblerSearchNote;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetStatiLegali_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetTipiPeriodo_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AutorizzaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.DissociaPraticheDaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RifiutaAutorizzazioneComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.application.service.OrdineDelGiornoService;
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.application.service.ProcessoErogazioneService;
import it.ccse.uscite.application.service.StatoLegaleService;
import it.ccse.uscite.application.service.TipoPeriodoService;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.domain.filter.ProcessoFilter;

/**
 * @author vcompagnone
 *
 */

@Transactional
@WebService(endpointInterface="it.ccse.uscite.application.facade.GestionaleWSFacade")
public class GestionaleWSFacadeImpl implements GestionaleWSFacade {
	
	@Autowired
 	private AssemblerAggiungiComitato assemblerAggiungiComitato;
	@Autowired
	private AssemblerAggiornaComitato assemblerAggiornaComitato;
	@Autowired
	private AssemblerAggiornaNota assemblerAggiornaNota;
	@Autowired
	private AssemblerAggiungiNota assemblerAggiungiNota;
	@Autowired
	private AssemblerApriComitato assemblerApriComitato;
	@Autowired
	private AssemblerApriNota assemblerApriNota;
	@Autowired
	private AssemblerAssociaPraticheANota assemblerAssociaPraticheANota;
	@Autowired
	private AssemblerAutorizzaComitato assemblerAutorizzaComitato;
	@Autowired
	private AssemblerChiudiComitato assemblerChiudiComitato;
	@Autowired
	private AssemblerChiudiNota assemblerChiudiNota;
	@Autowired
	private AssemblerDissociaPraticheDaNota assemblerDissociaPraticheDaNota;
	@Autowired
	private AssemblerEliminaComitato assemblerEliminaComitato;
	@Autowired
	private AssemblerEliminaNota assemblerEliminaNota;
	@Autowired
	private AssemblerGetStatiLegali assemblerGetStatiLegali;
	@Autowired
	private AssemblerGetTipiPeriodo assemblerGetTipiPeriodo;
	@Autowired
	private AssemblerLavorazioneContabileNota assemblerLavorazioneContabileNota;
	@Autowired
	private AssemblerLavorazioneContabilePratica assemblerLavorazioneContabilePratica;
	@Autowired
	private AssemblerRifiutaAutorizzazioneComitato assemblerRifiutaAutorizzazioneComitato;
	@Autowired
	private AssemblerRinviaNota assemblerRinviaNota;
	@Autowired
	private AssemblerSearchComitati assemblerSearchComitati;
	@Autowired
	private AssemblerSearchNote assemblerSearchNote;
	
	@Autowired
	private OrdineDelGiornoService ordineDelGiornoService;
	
	@Autowired
	private ProcessoErogazioneService processoErogazioneService;
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Autowired
	private TipoPeriodoService tipoPeriodoService;
	
	@Autowired
	private StatoLegaleService statoLegaleService;
	
	@Override
	public AggiungiComitato_OutDTO aggiungiComitato(
			AggiungiComitato_InDTO comitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assemblerAggiungiComitato.assemble(comitato_InDTO);
		OrdineDelGiorno nuovoOrdineDelGiorno = ordineDelGiornoService.createOrdineDelGiorno(ordineDelGiorno);
		return assemblerAggiungiComitato.assemble(nuovoOrdineDelGiorno);
	}

	@Override
	public AggiornaComitato_OutDTO aggiornaComitato(
			AggiornaComitato_InDTO updateComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assemblerAggiornaComitato.assemble(updateComitato_InDTO);
		AggiornaComitato_OutDTO outDTO = assemblerAggiornaComitato.assemble(ordineDelGiornoService.updateOrdineDelGiorno(ordineDelGiorno));
		return outDTO;
	}

	@Override
	public ApriComitato_OutDTO apriComitato(
			ApriComitato_InDTO apriComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assemblerApriComitato.assemble(apriComitato_InDTO);
		return assemblerApriComitato.assemble(ordineDelGiornoService.apriOrdineDelGiorno(ordineDelGiorno));
	}

	@Override
	public ChiudiComitato_OutDTO chiudiComitato(
			ChiudiComitato_InDTO chiudiComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assemblerChiudiComitato.assemble(chiudiComitato_InDTO);
		return assemblerChiudiComitato.assemble(ordineDelGiornoService.chiudiOrdineDelGiorno(ordineDelGiorno));
	}

	@Override
	public EliminaComitato_OutDTO deleteComitato(
			EliminaComitato_InDTO deleteComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assemblerEliminaComitato.assemble(deleteComitato_InDTO);
		ordineDelGiornoService.eliminaOrdineDelGiorno(ordineDelGiorno);
		return new EliminaComitato_OutDTO();
	}

	@Override
	public AggiungiNota_OutDTO aggiungiNota(
			AggiungiNota_InDTO aggiungiNotaDTO_InDTO) {
		ProcessoErogazione processo = assemblerAggiungiNota.assemble(aggiungiNotaDTO_InDTO);
		return assemblerAggiungiNota.assemble(processoErogazioneService.createProcessoErogazione(processo));
	}

	@Override
	public EliminaNota_OutDTO eliminaNota(EliminaNota_InDTO eliminaNota_InDTO) {
		ProcessoErogazione processo = assemblerEliminaNota.assemble(eliminaNota_InDTO);
		processoErogazioneService.eliminaProcessoErogazione(processo);
		return new EliminaNota_OutDTO();
	}

	@Override
	public AggiornaNota_OutDTO aggiornaNota(
			AggiornaNota_InDTO aggiornaNota_InDTO) {
		ProcessoErogazione processo = assemblerAggiornaNota.assemble(aggiornaNota_InDTO);
		return assemblerAggiornaNota.assemble(processoErogazioneService.aggiornaProcessoErogazione(processo));
	}

	@Override
	public ApriNota_OutDTO apriNota(ApriNota_InDTO apriNotaInDTO) {
		ProcessoErogazione processo = assemblerApriNota.assemble(apriNotaInDTO);
		return assemblerApriNota.assemble(processoErogazioneService.apriProcessoErogazione(processo));
	}

	@Override
	public ChiudiNota_OutDTO chiudiNota(ChiudiNota_InDTO chiudiNotaInDTO) {
		ProcessoErogazione processo = assemblerChiudiNota.assemble(chiudiNotaInDTO);
		return assemblerChiudiNota.assemble(processoErogazioneService.chiudiProcessoErogazione(processo));
	}

	@Override
	public RinviaNota_OutDTO rinviaNota(RinviaNota_InDTO rinviaNota_InDTO) {
		OrdineDelGiorno ordine = assemblerRinviaNota.assembleOrdineDelGiorno(rinviaNota_InDTO);
		ProcessoErogazione processo = assemblerRinviaNota.assembleProcessoErogazione(rinviaNota_InDTO);
		return assemblerRinviaNota.assemble(processoErogazioneService.rinviaProcessoErogazione(processo, ordine));
	}

	@Override
	public LavorazioneContabile_OutDTO lavorazioneContabileNota(
			LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO) {
		ProcessoErogazione processo = assemblerLavorazioneContabileNota.assemble(lavorazioneContabileNota_InDTO);
		LavorazioneContabile lavorazioneContabile = processoErogazioneService.lavorazioneContabile(processo);
		return assemblerLavorazioneContabileNota.assemble(lavorazioneContabile);
	}

	@Override
	public LavorazioneContabile_OutDTO lavorazioneContabilePratiche(
			LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO) {
		List<PraticaErogazione> pratiche = assemblerLavorazioneContabilePratica.assemble(lavorazioneContabilePratica_InDTO);
		LavorazioneContabile lavorazione = praticaErogazioneService.lavorazioneContabile(pratiche);
		return assemblerLavorazioneContabilePratica.assemble(lavorazione);
	}

	@Override
	public AutorizzaComitato_OutDTO autorizzaComitato(
			AutorizzaComitato_InDTO autorizzaComitatoIn_DTO) {
		List<PraticaErogazione> pratiche = assemblerAutorizzaComitato.assemble(autorizzaComitatoIn_DTO);
		praticaErogazioneService.autorizzaComitato(pratiche);
		return new AutorizzaComitato_OutDTO();
	}

	@Override
	public RifiutaAutorizzazioneComitato_OutDTO rifiutaAutorizzazioneComitato(
			RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitatoIn_DTO) {
		List<PraticaErogazione> pratiche = assemblerRifiutaAutorizzazioneComitato.assemble(rifiutaAutorizzazioneComitatoIn_DTO);
		praticaErogazioneService.rifiutaAutorizzazioneComitato(pratiche);
		return new RifiutaAutorizzazioneComitato_OutDTO();
	}
	
	@Override
	public SearchNote_OutDTO searchNote(SearchNote_InDTO searchNote_InDTO) {
		ProcessoFilter req = assemblerSearchNote.assemble(searchNote_InDTO);
		return assemblerSearchNote.assemble(processoErogazioneService.searchProcessiErogazione(req));
	}

	@Override
	public SearchComitati_OutDTO searchComitati(
			SearchComitati_InDTO searchComitati_InDTO) {
		OrdineDelGiornoFilter req = assemblerSearchComitati.assemble(searchComitati_InDTO);
		return  assemblerSearchComitati.assemble(ordineDelGiornoService.searchComitati(req));
	}

	@Override
	public GetTipiPeriodo_OutDTO getTipiPeriodo(
			GetTipiPeriodo_InDTO getTipiPeriodo_InDTO) {	
		Collection<TipoPeriodo> tipiPeriodo = tipoPeriodoService.getTipiPeriodo();
		return assemblerGetTipiPeriodo.assemble(tipiPeriodo);
	}

	@Override
	public AssociaPraticheANota_OutDTO associaPraticheANota(
			AssociaPraticheANota_InDTO associaPraticheANota_InDTO) {
		List<PraticaErogazione> pratiche = assemblerAssociaPraticheANota.assembleListaPratiche(associaPraticheANota_InDTO);
		ProcessoErogazione processo = assemblerAssociaPraticheANota.assembleProcessoErogazione(associaPraticheANota_InDTO);
		processo = praticaErogazioneService.associaPraticheANota(pratiche,processo);
		return assemblerAssociaPraticheANota.assemble(processo);
	}

	@Override
	public DissociaPraticheDaNota_OutDTO dissociaPraticheDaNota(
			DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO) {
		List<PraticaErogazione> pratiche = assemblerDissociaPraticheDaNota.assembleListaPratiche(dissociaPraticheDaNota_InDTO);
		praticaErogazioneService.dissociaPraticheDaNota(pratiche);
		return new DissociaPraticheDaNota_OutDTO();
	}
	@Override
	public GetStatiLegali_OutDTO getStatiLegali(
			GetStatiLegali_InDTO getStatiLegali_InDTO) {
		Collection<StatoLegale> statiLegali = statoLegaleService.getStatiLegali();
		return assemblerGetStatiLegali.assemble(statiLegali);
	}
	
}
