/**
 * 
 */
package it.ccse.uscite.facade;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import it.ccse.uscite.application.facade.GestionaleWSFacade;
import it.ccse.uscite.application.facade.UsciteWSFacade;
import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.application.facade.dto.DettaglioComitatoDTO;
import it.ccse.uscite.application.facade.dto.DettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetStatiLegali_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetTipiPeriodo_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO.Esito;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno.TipologiaComitato;
import it.ccse.uscite.domain.SettoreAttivita.StatoAntimafia;
import it.ccse.uscite.domain.SettoreAttivita.Unbundling;

/**
 * @author vcompagnone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations =  {"classpath:/spring/web-application-context.xml","classpath:/spring/persistence-context.xml"} )
@Transactional
public class WS_UsciteTest {
	
	@Autowired
	private UsciteWSFacade usciteWS;
	
	@Autowired
	private GestionaleWSFacade gestionaleWS;
	
	@Test
	public void testSearchPratiche(){
		SearchPratiche_InDTO searchPratiche_InDTO = new SearchPratiche_InDTO();
		Integer annoDa = 2014,annoA =2014;
		Boolean erogabile = true;
		searchPratiche_InDTO.setAnnoDa(annoDa);
		searchPratiche_InDTO.setAnnoA(annoA);
		searchPratiche_InDTO.setErogabile(true);
		Date dataComitatoA = new GregorianCalendar(2014,3,22).getTime();
		searchPratiche_InDTO.setDataComitatoA(dataComitatoA );
//		List<Integer> listaIdSettoreAttivita = new ArrayList<Integer>();
//		listaIdSettoreAttivita.add(1261);
//		listaIdSettoreAttivita.add(1264);
//		listaIdSettoreAttivita.add(1401);
		searchPratiche_InDTO.setPageSize(100);
		searchPratiche_InDTO.setPageNumber(5);
		//searchPratiche_InDTO.setListaIdSettoreAttivita(listaIdSettoreAttivita );;
		
		SearchPratiche_OutDTO output = usciteWS.searchPratiche(searchPratiche_InDTO);
		
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS);
		
		Assert.assertFalse(output.getContent().stream().filter(p->!p.getAnno().equals(annoA)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->!p.getErogabile().equals(erogabile)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->p.getNota().getOrdineDelGiorno().getDataComitato().after(dataComitatoA)).findAny().isPresent());

		
	}
	@Test
	public void testGetOrdiniDelGiorno(){
		SearchComitati_InDTO inputDTO = new SearchComitati_InDTO();
		SearchComitati_OutDTO output = gestionaleWS.searchComitati(inputDTO );
		List<DettaglioComitatoDTO> listaComitati = output.getContent();
		Assert.assertNotNull(listaComitati);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS);
	}
	
	@Test
	public void testAddOrdineDelGiorno(){
		String descrizione = "prova";
		Integer numeroComitato = 1;
		TipologiaComitato tipologia = TipologiaComitato.ORDINARIO;
		Date dataComitato = DateUtils.truncate(DateUtils.addDays(new Date(),100),Calendar.DAY_OF_MONTH);
		AggiungiComitato_InDTO ordineDelGiorno_InDTO = new AggiungiComitato_InDTO();
		ordineDelGiorno_InDTO.setDataComitato(dataComitato);
		ordineDelGiorno_InDTO.setDescrizione(descrizione);
		ordineDelGiorno_InDTO.setNumeroComitato(numeroComitato);
		ordineDelGiorno_InDTO.setTipologia(tipologia);
		ComitatoDTO ordine = gestionaleWS.aggiungiComitato(ordineDelGiorno_InDTO).getContent();
		Assert.assertNotNull(ordine);
		Assert.assertEquals(dataComitato,ordine.getDataComitato());
		Assert.assertEquals(numeroComitato,ordine.getNumeroComitato());
		Assert.assertEquals(tipologia,ordine.getTipologia());
		Assert.assertEquals(descrizione,ordine.getDescrizione());
	}
	
	@Test
	public void testDeleteOrdineDelGiorno(){
		EliminaComitato_InDTO deleteOrdineDelGiorno_InDTO = new EliminaComitato_InDTO();
		SearchComitati_InDTO inputDTO = new SearchComitati_InDTO();
		List<DettaglioComitatoDTO> listaComitati =  gestionaleWS.searchComitati(inputDTO ).getContent();
		deleteOrdineDelGiorno_InDTO.setIdOrdineDelGiorno(listaComitati.get(0).getId());
		EliminaComitato_OutDTO output = gestionaleWS.deleteComitato(deleteOrdineDelGiorno_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS);
	}
	
	@Test
	public void testApriOrdineDelGiorno(){
		ApriComitato_InDTO apriOrdineDelGiorno_InDTO = new ApriComitato_InDTO();
		SearchComitati_InDTO inputDTO = new SearchComitati_InDTO();
		List<DettaglioComitatoDTO> listaComitati =  gestionaleWS.searchComitati(inputDTO ).getContent();
		apriOrdineDelGiorno_InDTO.setIdOrdineDelGiorno(listaComitati.get(0).getId());
		ApriComitato_OutDTO output = gestionaleWS.apriComitato(apriOrdineDelGiorno_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);
	}
	
	@Test
	public void testChiudiOrdineDelGiorno(){
		ChiudiComitato_InDTO chiudiOrdineDelGiorno_InDTO = new ChiudiComitato_InDTO();
		SearchComitati_InDTO inputDTO = new SearchComitati_InDTO();
		List<DettaglioComitatoDTO> listaComitati =  gestionaleWS.searchComitati(inputDTO ).getContent();
		chiudiOrdineDelGiorno_InDTO.setIdOrdineDelGiorno(listaComitati.get(0).getId());
		ChiudiComitato_OutDTO output = gestionaleWS.chiudiComitato(chiudiOrdineDelGiorno_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);
	}
	
	@Test
	public void testUpdateOrdineDelGiorno(){
		String descrizione = "pippo";
		Date dataComitato = DateUtils.addDays(new Date(), 2);
		AggiornaComitato_InDTO updateOrdineDelGiorno_InDTO = new AggiornaComitato_InDTO();
		SearchComitati_InDTO inputDTO = new SearchComitati_InDTO();
		List<DettaglioComitatoDTO> listaComitati =  gestionaleWS.searchComitati(inputDTO ).getContent();
		updateOrdineDelGiorno_InDTO.setIdOrdineDelGiorno(listaComitati.get(0).getId());
		updateOrdineDelGiorno_InDTO.setDataComitato(dataComitato);
		
		updateOrdineDelGiorno_InDTO.setDescrizione(descrizione);
		AggiornaComitato_OutDTO output = gestionaleWS.aggiornaComitato(updateOrdineDelGiorno_InDTO);
		//ComitatoDTO ordine = output.getContent();
	//	Assert.assertNotNull(ordine);
		//Assert.assertEquals(descrizione, ordine.getDescrizione());
		//Assert.assertEquals(dataComitato, ordine.getDataComitato());
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);
	}
	
	@Test
	public void testAggiungiNota(){
		String causale = "pippo";
		Integer numeroNota = 2;
		BigInteger idOrdine = gestionaleWS.searchComitati(new SearchComitati_InDTO()).getContent().get(0).getId();
		String idUnita = "PC";
		String username = "topogigio";
		ComitatoDTO ordine = new ComitatoDTO(); 
		ordine.setId(idOrdine);
		
		AggiungiNota_InDTO aggiungiNotaDTO_InDTO = new AggiungiNota_InDTO();
		
		aggiungiNotaDTO_InDTO.setCausale(causale);
		aggiungiNotaDTO_InDTO.setNumeroNota(numeroNota);
		aggiungiNotaDTO_InDTO.setUsername(username);
		aggiungiNotaDTO_InDTO.setOwner(idUnita);
		
		aggiungiNotaDTO_InDTO.setOrdineDelGiorno(ordine);
		AggiungiNota_OutDTO output = gestionaleWS.aggiungiNota(aggiungiNotaDTO_InDTO);
		DettaglioNotaPagamentoDTO nota = output.getContent();
		Assert.assertNotNull(nota);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS);
		Assert.assertEquals(causale,nota.getCausale());
		Assert.assertEquals(numeroNota,nota.getNumeroNota());
		Assert.assertEquals(idOrdine,nota.getOrdineDelGiorno().getId());
		Assert.assertEquals(idUnita,nota.getOwner());
		Assert.assertEquals(username,RequestContextHolder.currentRequestAttributes().getAttribute("username",RequestAttributes.SCOPE_REQUEST));
	}

	@Test
	public void testEliminaNota(){
		EliminaNota_InDTO eliminaNota_InDTO = new EliminaNota_InDTO();
		BigInteger id = BigInteger.valueOf(35);
		eliminaNota_InDTO.setIdProcessoErogazione(id);
		EliminaNota_OutDTO output = gestionaleWS.eliminaNota(eliminaNota_InDTO);
		
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);
	}
	
	@Test
	public void testAggiornaNota(){
		String causale = "pippo";
		Integer numeroNota = 32;
		Integer id = 414;
		AggiornaNota_InDTO aggiornaNota_InDTO = new AggiornaNota_InDTO();
		aggiornaNota_InDTO.setIdNota(id);
		aggiornaNota_InDTO.setCausale(causale);
		aggiornaNota_InDTO.setNumeroNota(numeroNota);
		AggiornaNota_OutDTO output = gestionaleWS.aggiornaNota(aggiornaNota_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);
		
	}
	
	@Test
	public void testApriNota(){
		Integer id = 414;
		ApriNota_InDTO apriNotaInDTO = new ApriNota_InDTO();
		apriNotaInDTO.setIdProcessoErogazione(id);
		ApriNota_OutDTO output = gestionaleWS.apriNota(apriNotaInDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);

	}
	
	@Test
	public void testChiudiNota(){
		BigInteger id = BigInteger.valueOf(414); 
		ChiudiNota_InDTO chiudiNotaInDTO = new ChiudiNota_InDTO();
		chiudiNotaInDTO.setIdProcessoErogazione(id);
		ChiudiNota_OutDTO output = gestionaleWS.chiudiNota(chiudiNotaInDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);

	}
	
	@Test
	public void testRinviaNota(){
		RinviaNota_InDTO rinviaNota_InDTO = new RinviaNota_InDTO();
		String username = "pippo";
		BigInteger idComitato = BigInteger.valueOf(49);
		BigInteger idNota = BigInteger.valueOf(413);
		rinviaNota_InDTO.setIdComitato(idComitato);
		rinviaNota_InDTO.setIdNota(idNota);
		rinviaNota_InDTO.setUsername(username);
		RinviaNota_OutDTO output = gestionaleWS.rinviaNota(rinviaNota_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);
	}
	
	
	
	
	
	@Test
	public void testLavorazioneContabileNota(){
		LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO = new LavorazioneContabileNota_InDTO();
		BigInteger idNota = BigInteger.valueOf(390);
		lavorazioneContabileNota_InDTO.setIdNota(idNota);
		LavorazioneContabile_OutDTO output = gestionaleWS.lavorazioneContabileNota(lavorazioneContabileNota_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		
	}
	
	
	@Test
	public void testLavorazioneContabilePratiche(){
		LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO = new LavorazioneContabilePratica_InDTO();
		List<PraticaErogazioneDTO> content = new ArrayList<PraticaErogazioneDTO>();
		PraticaErogazioneDTO pratica1 = new PraticaErogazioneDTO();
		pratica1.setId(BigInteger.valueOf(2410));
		PraticaErogazioneDTO pratica2 = new PraticaErogazioneDTO();
		pratica2.setId(BigInteger.valueOf(2411));
		PraticaErogazioneDTO pratica3 = new PraticaErogazioneDTO();
		pratica3.setId(BigInteger.valueOf(2412));
		PraticaErogazioneDTO pratica4 = new PraticaErogazioneDTO();
		pratica4.setId(BigInteger.valueOf(4383));
		PraticaErogazioneDTO pratica5 = new PraticaErogazioneDTO();
		pratica5.setId(BigInteger.valueOf(12734));	
		content.add(pratica1);
		content.add(pratica2);
		content.add(pratica3);
		content.add(pratica4);
		content.add(pratica5);
		lavorazioneContabilePratica_InDTO.setContent(content);
		LavorazioneContabile_OutDTO output = gestionaleWS.lavorazioneContabilePratiche(lavorazioneContabilePratica_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		
	}
	
	@Test
	public void testAggiornaSemaforiAnagrafica(){
		
		AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO = new AggiornaSemaforiAnagrafica_InDTO();
		
		List<SettoreAttivitaDTO> content = new ArrayList<SettoreAttivitaDTO>();
		
		SettoreAttivitaDTO settore1 = new SettoreAttivitaDTO();
		settore1.setId(1074);
		settore1.setStatoAntimafia(StatoAntimafia.CERTIFICATO_VALIDO );
		settore1.setUnbundling(Unbundling.BLOCCATA);
		content.add(settore1);
		SettoreAttivitaDTO settore2 = new SettoreAttivitaDTO();
		settore2.setId(173);
		settore2.setStatoAntimafia(StatoAntimafia.ATTESA_DOCUMENTAZIONE );

		settore2.setUnbundling(Unbundling.SBLOCCATA);
		content.add(settore2);
		aggiornaSemaforiAnagrafica_InDTO.setContent(content );
		
		AggiornaSemaforiAnagrafica_OutDTO output = usciteWS.aggiornaSemaforiAnagrafica(aggiornaSemaforiAnagrafica_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		

	}
	
	@Test
	public void testAssociaPraticheANota(){
		
		AssociaPraticheANota_InDTO inDTO = new AssociaPraticheANota_InDTO();
		inDTO.setUsername("pippo");
		inDTO.setIdNota(BigInteger.valueOf(585));
		List<DettaglioPraticaErogazioneDTO> content = new ArrayList<DettaglioPraticaErogazioneDTO>();
		DettaglioPraticaErogazioneDTO praticaDTO = new DettaglioPraticaErogazioneDTO();
		praticaDTO.setAnno(2014);
		//praticaDTO.set
		//content.add(praticaDTO );
		inDTO.setContent(content );
		
		AssociaPraticheANota_OutDTO output = gestionaleWS.associaPraticheANota(inDTO);
		
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		
		
	}
	
	@Test
	public void testDissociaPraticheDaNota(){
		
	}
	
	@Test
	public void testGetTipiPeriodo(){
		GetTipiPeriodo_InDTO getTipiPeriodo_InDTO = new GetTipiPeriodo_InDTO();
		GetTipiPeriodo_OutDTO output = gestionaleWS.getTipiPeriodo(getTipiPeriodo_InDTO);
		
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		

	}
	
	@Test
	public void testGetStatiLegali(){
		GetStatiLegali_InDTO getStatiLegali_InDTO = new GetStatiLegali_InDTO();
		GetStatiLegali_OutDTO output = gestionaleWS.getStatiLegali(getStatiLegali_InDTO);
		
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		

	}
}
