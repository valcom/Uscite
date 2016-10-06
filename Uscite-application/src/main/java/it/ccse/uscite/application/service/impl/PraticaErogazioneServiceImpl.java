/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import it.ccse.uscite.application.service.MailService;
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.application.service.StatoComitatoService;
import it.ccse.uscite.application.service.StatoContabileService;
import it.ccse.uscite.application.service.StatoFideiussioneService;
import it.ccse.uscite.application.service.StatoLegaleService;
import it.ccse.uscite.application.service.StatoUnbundlingService;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.SettoreAttivita.Unbundling;
import it.ccse.uscite.domain.StatoComitato;
import it.ccse.uscite.domain.StatoContabile;
import it.ccse.uscite.domain.StatoFideiussione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoUnbundling;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;
import it.ccse.uscite.domain.filter.PraticaFilter;
import it.ccse.uscite.domain.repository.PraticaErogazioneRepository;
import it.ccse.uscite.domain.repository.ProcessoErogazioneRepository;
import it.ccse.uscite.domain.util.UsciteProperties;
import it.ccse.uscite.exception.ApplicationException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author vcompagnone
 *
 */
@Service
@Transactional(readOnly=false)
public class PraticaErogazioneServiceImpl implements PraticaErogazioneService {

	@Autowired
	private PraticaErogazioneRepository praticaErogazioneRepository;
	@Autowired
	private ProcessoErogazioneRepository processoErogazioneRepository;
	@Autowired
	private StatoLegaleService statoLegaleService;
	@Autowired
	private StatoContabileService statoContabileService;
	@Autowired
	private StatoComitatoService statoComitatoService;
	@Autowired
	private StatoUnbundlingService statoUnbundlingService;
	@Autowired
	private StatoFideiussioneService statoFideiussioneService;
	
	@Autowired
	private MailService mailService;


	/* (non-Javadoc)
	 * @see it.ccse.dbuscite.application.service.PraticaErogazioneService#getById(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=true)
	public PraticaErogazione getById(BigInteger id) {
		return praticaErogazioneRepository.findOne(id);
	}

	@Override
	public void createPraticaErogazione(PraticaErogazione praticaErogazione) {
		praticaErogazione.init();
		//ProcessoErogazione processo = processoErogazioneRepository.findOne(praticaErogazione.getProcessoErogazione().getId());
		//praticaErogazione.setProcessoErogazione(processo);

	}

	@Override
	public void savePraticaErogazione(PraticaErogazione praticaErogazione) {
		praticaErogazioneRepository.save(praticaErogazione);
	}

	@Override
	public void delete(PraticaErogazione praticaErogazione) {
		praticaErogazioneRepository.delete(praticaErogazione);
		praticaErogazione.setId(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<PraticaErogazione> searchPraticheErogazione(PraticaFilter filter) {
		Page<PraticaErogazione> pratiche = null;
		Pageable pageable = filter.getPageable();
		if(filter.getErogabile()==null){
			pratiche = praticaErogazioneRepository.findAll(filter.getPredicate(),pageable);
		}else{
			List<PraticaErogazione> listaPraticheErogabili = praticaErogazioneRepository.findAll(filter.getSpecification()).stream().filter(p->p.isErogabile().equals(filter.getErogabile())).collect(Collectors.toList());
			pratiche = new PageImpl<PraticaErogazione>(listaPraticheErogabili,pageable,listaPraticheErogabili.size());
		}
		
		return pratiche ;
	}

	@Override
	@Transactional(readOnly=true)
	public PraticaErogazione getByCodicePratica(String codicePratica) {
		return praticaErogazioneRepository.findByCodicePratica(codicePratica);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PraticaErogazione> getPraticheByProcessoErogazione(
			ProcessoErogazione processo) {
		return praticaErogazioneRepository.findByProcessoErogazione(processo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PraticaErogazione> getPraticheLavorabili(ProcessoErogazione processo) {
		PraticaFilter filter = new PraticaFilter();
		filter.setIdProcessoErogazione(processo.getId());
		filter.setStatiPratica(Arrays.asList(StatoPratica.LAVORABILE));
		Page<PraticaErogazione> pratiche =  searchPraticheErogazione(filter);
		return pratiche != null ? pratiche.getContent() : null;
	}

	@Override
	public ProcessoErogazione associaPraticheANota(
			List<PraticaErogazione> pratiche, ProcessoErogazione processo) {
		BigInteger idProcesso = processo.getId();
		processo = processoErogazioneRepository.findOne(idProcesso);
		if(processo == null){
			throw new ApplicationException("error.nota.notFound.associazionePraticaNota");
		}
		if(pratiche!=null&&!pratiche.isEmpty()){
			List<PraticaErogazione> praticheNuove = pratiche;
			List<String> codiciPratica = pratiche.stream().map(PraticaErogazione::getCodicePratica).collect(Collectors.toList());
			List<PraticaErogazione> praticheEsistenti = praticaErogazioneRepository.findByCodicePraticaIn(codiciPratica);
			praticheEsistenti.stream().forEach(PraticaErogazione::checkModificabilita);
			if(praticheEsistenti!=null&&!praticheEsistenti.isEmpty()){
				List<String> codiciPraticaEsistenti = praticheEsistenti.stream().map(PraticaErogazione::getCodicePratica).collect(Collectors.toList());
				praticheNuove = pratiche.stream().filter(p->!codiciPraticaEsistenti.contains(p.getCodicePratica())).collect(Collectors.toList());
				for(PraticaErogazione praticaEsistente:praticheEsistenti){
					PraticaErogazione pratica = pratiche.stream().filter(p->p.getCodicePratica().equals(praticaEsistente.getCodicePratica())).findFirst().get();
					pratica.setId(praticaEsistente.getId());
					pratica.setLavorazioneContabile(praticaEsistente.getLavorazioneContabile());
					pratica.setStatoComitato(praticaEsistente.getStatoComitato());
					pratica.setStatoFideiussione(praticaEsistente.getStatoFideiussione());
					pratica.setStatoContabile(praticaEsistente.getStatoContabile());
					pratica.setStatoUnbundling(praticaEsistente.getStatoUnbundling());
					pratica.setStatoLegale(praticaEsistente.getStatoLegale());
				}
			}
			StatoLegale statoLegaleIniziale = statoLegaleService.getStatoLegaleIniziale();
			StatoContabile statoContabile = statoContabileService.getStatoContabileIniziale();
			StatoComitato statoComitato = statoComitatoService.getStatoComitatoIniziale();
			StatoUnbundling statoUnbundlingIniziale = statoUnbundlingService.getStatoUnbundlingIniziale();
			StatoFideiussione statoFideiussioneIniziale = statoFideiussioneService.getStatoFideiussioneIniziale();
			if(praticheNuove!=null){
				praticheNuove.stream().forEach(p->{p.checkInit();p.init(statoLegaleIniziale,statoContabile, statoComitato, statoUnbundlingIniziale, statoFideiussioneIniziale);});
			}
			
			List<StatoLegale> statiLegale = statoLegaleService.getStatiLegali();
			List<StatoUnbundling> statiUnbundling = statoUnbundlingService.getStatiUnbundling();
			List<StatoFideiussione> statiFideiussione = statoFideiussioneService.getStatiFideiussione();
			for(PraticaErogazione pratica:pratiche){
				StatoLegale statoLegale = statiLegale.stream().filter(sl->sl.getAutorizzazioneLegale().equals(pratica.getSettoreAttivita().getStatoAntimafia().getAutorizzazioneLegale())).findFirst().orElseThrow(()->new RuntimeException("stato legale non valido per la pratica "+pratica.getCodicePratica()));
				StatoUnbundling statoUnbundling = statiUnbundling.stream().filter(su->su.getUnbundling().equals(calcolaUnbundlingPratica(pratica.getSettoreAttivita().getUnbundling(),pratica.getIdComponenteTariffariaAc()))).findFirst().orElseThrow(()->new RuntimeException("stato unbundling non valido per la pratica "+pratica.getCodicePratica()));
				pratica.setStatoFideiussione(statiFideiussione.stream().filter(sf->sf.equals(statoFideiussioneIniziale.getFideiussione().getFideiussionePraticaByCT(pratica.getIdComponenteTariffariaAc()))).findFirst().orElseThrow(()->new RuntimeException("stato fideiussione non valido per la pratica "+pratica.getCodicePratica())));
				pratica.setStatoLegale(statoLegale);
				pratica.setStatoUnbundling(statoUnbundling);
				pratica.associaANota(processo);
			}
			
			praticaErogazioneRepository.save(pratiche);
			}
		return processo;
	}

	@Override
	public void dissociaPraticheDaNota(
			List<PraticaErogazione> pratiche) {	
		int nPratiche = pratiche.size();
		List<BigInteger> ids = pratiche.stream().map(PraticaErogazione::getIdPraticaErogazione).collect(Collectors.toList());
		pratiche = praticaErogazioneRepository.findAll(ids);
		if(pratiche==null || pratiche.size()<nPratiche){
			throw new ApplicationException("error.pratica.notFound.dissociazionePraticaNota");
		}
		pratiche.parallelStream().forEach(PraticaErogazione::dissociaDaNota);
		delete(pratiche);
	}

	@Override
	public void delete(List<PraticaErogazione> pratiche) {
		praticaErogazioneRepository.delete(pratiche);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<PraticaErogazione> getPraticheAutorizzabiliComitato(ProcessoErogazione processo) {
		PraticaFilter filter = new PraticaFilter();
		filter.setStatiPratica(Arrays.asList(StatoPratica.ASSEGNATO));
		filter.setIdProcessoErogazione(processo.getId());
		Page<PraticaErogazione> pratiche = searchPraticheErogazione(filter);
		return pratiche!= null ? pratiche.getContent() : null;
	}

	@Override
	public LavorazioneContabile lavorazioneContabile(List<PraticaErogazione> pratiche) {
		LavorazioneContabile lavorazioneContabile = new LavorazioneContabile();
		
		List<BigInteger> ids = pratiche.stream().map(PraticaErogazione::getIdPraticaErogazione).collect(Collectors.toList());
		pratiche = praticaErogazioneRepository.findAll(ids);
		pratiche.stream().forEach(PraticaErogazione::lavorazioneContabile);
		lavorazioneContabile.addErogazioni(pratiche.stream().filter(PraticaErogazione.IS_IN_EROGAZIONE).collect(Collectors.toList()));
		lavorazioneContabile.addSospesi(pratiche.stream().filter(PraticaErogazione.IS_IN_SOSPESO).collect(Collectors.toList()));

		Set<ProcessoErogazione> processi = pratiche.stream().map(p->p.getProcessoErogazione()).collect(Collectors.toSet());
		processi.stream().forEach(ProcessoErogazione::lavorazioneContabile);

		praticaErogazioneRepository.save(pratiche);
		processoErogazioneRepository.save(processi);
		return lavorazioneContabile;
	}

	@Override
	public List<PraticaErogazione> aggiornaSemaforiAnagrafica(Collection<SettoreAttivita> settoriAttivita) {
		
		List<PraticaErogazione> pratiche = new ArrayList<PraticaErogazione>();
		List<StatoLegale> statiLegale = statoLegaleService.getStatiLegali();
		List<StatoUnbundling> statiUnbundling = statoUnbundlingService.getStatiUnbundling();

		for(SettoreAttivita settoreAttivita:settoriAttivita){
			PraticaFilter filter = new PraticaFilter();
			filter.setListaIdSettoriAttivita(Arrays.asList(settoreAttivita.getId()));
			filter.setStatiPratica(StatoPratica.STATI_PRATICA_MODIFICABILE);
			Page<PraticaErogazione> pagePratiche = searchPraticheErogazione(filter);
			if(pagePratiche!=null){
				List<PraticaErogazione> praticheBySettore = pagePratiche.getContent();
				for(PraticaErogazione pratica:praticheBySettore){
					pratica.setSettoreAttivita(settoreAttivita);
					AutorizzazioneLegale autorizzazioneLegale = pratica.getAutorizzazioneLegale();
					UnbundlingPratica unbundlingPratica = pratica.getUnbundling();
					StatoLegale statoLegale = statiLegale.stream().filter(sl->sl.getAutorizzazioneLegale().equals(settoreAttivita.getStatoAntimafia().getAutorizzazioneLegale())).findFirst().orElse(null);
					StatoUnbundling statoUnbundling = statiUnbundling.stream().filter(sb->sb.getUnbundling().equals(calcolaUnbundlingPratica(settoreAttivita.getUnbundling(),pratica.getIdComponenteTariffariaAc()))).findFirst().orElse(null); 
					if(statoLegale!=null){
						pratica.setStatoLegale(statoLegale);
					}
					if(statoUnbundling!=null){
						pratica.setStatoUnbundling(statoUnbundling);
					}
					AutorizzazioneLegale nuovaAntimafia = pratica.getAutorizzazioneLegale();
					UnbundlingPratica nuovoUnbundling = pratica.getUnbundling();
					if(autorizzazioneLegale != nuovaAntimafia  || unbundlingPratica != nuovoUnbundling){
						pratiche.add(pratica);
					}
				}
			}
		}

		List<PraticaErogazione> praticheErogabili = pratiche.stream().filter(PraticaErogazione::isErogabile).collect(Collectors.toList());
		if(!praticheErogabili.isEmpty()){
			mailService.sendMailSbloccoAnagraficaPratiche(praticheErogabili);
		}
		return praticaErogazioneRepository.save(pratiche);
	}
	
	private static UnbundlingPratica calcolaUnbundlingPratica(Unbundling unbundlingSettoreAttivita,BigInteger idComponenteTariffaria) {
			UnbundlingPratica unbundlingPratica = null;
			if(unbundlingSettoreAttivita!=null){
				if(UsciteProperties.LISTA_COMPONENTI_TARIFFARIE_SOGGETTE_BLOCCO_UNBUNDLING.contains(idComponenteTariffaria.toString())){
					switch(unbundlingSettoreAttivita){
					case BLOCCATA:
						unbundlingPratica = UnbundlingPratica.NON_AUTORIZZATO;
						break;
					case SBLOCCATA:
						unbundlingPratica = UnbundlingPratica.AUTORIZZATO;
						break;
					default:
						break;
					}
				}else{
					unbundlingPratica = UnbundlingPratica.DONT_CARE;
				}
			}
			return unbundlingPratica;
		}		
	

	
	

	@Override
	@Transactional(readOnly=true)
	public Page<PraticaErogazione> searchPraticheInSospeso(PraticaFilter filter) {
		filter.setStatiPratica(Arrays.asList(StatoPratica.IN_SOSPESO));
		return searchPraticheErogazione(filter);
	}

	@Override
	public void autorizzaComitato(List<PraticaErogazione> pratiche) {

		if(pratiche != null && !pratiche.isEmpty()){
			List<BigInteger> ids = pratiche.parallelStream().map(PraticaErogazione::getId).collect(Collectors.toList());
			pratiche = praticaErogazioneRepository.findAll(ids);
			StatoComitato statoComitato = statoComitatoService.getStatoAutorizzazioneComitato();
			pratiche.stream().forEach(p->p.aggiornaAutorizzazioneComitato(statoComitato));
			praticaErogazioneRepository.save(pratiche);
			mailService.sendMailAutorizzazioneComitato(pratiche);
		}
	}

	@Override
	public void rifiutaAutorizzazioneComitato(List<PraticaErogazione> pratiche) {
		if(pratiche != null && !pratiche.isEmpty()){
			List<BigInteger> ids = pratiche.stream().map(PraticaErogazione::getIdPraticaErogazione).collect(Collectors.toList());
			pratiche = praticaErogazioneRepository.findAll(ids);
			StatoComitato statoComitato = statoComitatoService.getStatoRifiutoComitato();
			pratiche.stream().forEach(p->p.aggiornaAutorizzazioneComitato(statoComitato));
			praticaErogazioneRepository.save(pratiche);
		}
	}

	@Override
	public List<PraticaErogazione> aggiornaFideiussione(Map<String,FideiussionePratica> mappaCodiciPraticaFideiussioni) {
		List<PraticaErogazione> praticheModificate = null;
		if(mappaCodiciPraticaFideiussioni!=null){
			praticheModificate = new ArrayList<PraticaErogazione>();
			List<String> codiciPratica = new ArrayList<String>(mappaCodiciPraticaFideiussioni.keySet());
			PraticaFilter filter = new PraticaFilter();
			filter.setCodiciPratica(codiciPratica);
			filter.setStatiPratica(StatoPratica.STATI_PRATICA_MODIFICABILE);
			Page<PraticaErogazione> page = searchPraticheErogazione(filter);
			if(page!=null){
				List<PraticaErogazione> praticheEsistenti = page.getContent();
				List<StatoFideiussione> statiFideiussione = statoFideiussioneService.getStatiFideiussione();

				for(PraticaErogazione pratica:praticheEsistenti){
					StatoFideiussione fideiussioneEsistente = pratica.getStatoFideiussione();
					FideiussionePratica nuovaFideiussione = mappaCodiciPraticaFideiussioni.get(pratica.getCodicePratica());
					StatoFideiussione nuovoStatoFideiussione = statiFideiussione.stream().filter(sf->sf.getFideiussione().equals(nuovaFideiussione.getFideiussionePraticaByCT(pratica.getIdComponenteTariffariaAc()))).findFirst().get(); 
					pratica.setStatoFideiussione(nuovoStatoFideiussione );
					if(!fideiussioneEsistente.equals(nuovoStatoFideiussione)){
						praticheModificate.add(pratica);
					}
				}
			}
		}
		return praticaErogazioneRepository.save(praticheModificate);
	}

	
	

	@Override
	public void rinvia(PraticaErogazione pratica,ProcessoErogazione processo){
		pratica.checkModificabilita();
		processo.getOrdineDelGiorno().checkRinvioComitato();
		StatoComitato stato = statoComitatoService.getStatoRinvioComitato();
		pratica.setStatoComitato(stato);
		pratica.setProcessoErogazione(processo);
	}
	
	

}
