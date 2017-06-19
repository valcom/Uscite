/**
 * 
 */
package it.ccse.uscite.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.ccse.uscite.usciteWS.AggiornaFideiussioneDTO;
import it.ccse.uscite.usciteWS.AggiornaFideiussioneInDTO;
import it.ccse.uscite.usciteWS.AggiornaFideiussioneOutDTO;
import it.ccse.uscite.usciteWS.AggiornaSemaforiAnagraficaInDTO;
import it.ccse.uscite.usciteWS.AggiornaSemaforiAnagraficaOutDTO;
import it.ccse.uscite.usciteWS.Esito;
import it.ccse.uscite.usciteWS.FideiussionePratica;
import it.ccse.uscite.usciteWS.SearchPraticheInDTO;
import it.ccse.uscite.usciteWS.SearchPraticheOutDTO;
import it.ccse.uscite.usciteWS.SettoreAttivitaDTO;
import it.ccse.uscite.usciteWS.StatoAntimafia;
import it.ccse.uscite.usciteWS.Unbundling;
import it.ccse.uscite.usciteWS.UsciteWS;

/**
 * @author vcompagnone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath:spring/wsClient-context.xml"} )
public class WS_UsciteTest {
	
	@Autowired
	private UsciteWS usciteWS;
	
	@Test
	public void testSearchPratiche() throws DatatypeConfigurationException{
		SearchPraticheInDTO searchPratiche_InDTO = new SearchPraticheInDTO();
		Integer annoDa = 2014,annoA =2014;
		Boolean erogabile = true;
		searchPratiche_InDTO.setAnnoDa(annoDa);
		searchPratiche_InDTO.setAnnoA(annoA);
		searchPratiche_InDTO.setErogabile(true);
		BigDecimal importoA = new BigDecimal(500);

		GregorianCalendar gc = new GregorianCalendar(2014,3,22);
		Date dataComitatoA = gc.getTime();
		searchPratiche_InDTO.setDataComitatoA(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
//		List<Integer> listaIdSettoreAttivita = new ArrayList<Integer>();
//		listaIdSettoreAttivita.add(1261);
//		listaIdSettoreAttivita.add(1264);
//		listaIdSettoreAttivita.add(1401);
		searchPratiche_InDTO.setPageSize(100);
		searchPratiche_InDTO.setPageNumber(5);
		searchPratiche_InDTO.setImportoA(importoA);
		//searchPratiche_InDTO.setListaIdSettoreAttivita(listaIdSettoreAttivita );;
		
		SearchPraticheOutDTO output = usciteWS.searchPratiche(searchPratiche_InDTO);
		
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS);
		
		Assert.assertFalse(output.getContent().stream().filter(p->!p.getAnno().equals(annoA)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->!p.isErogabile().equals(erogabile)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->p.getNota().getOrdineDelGiorno().getDataComitato().toGregorianCalendar().getTime().after(dataComitatoA)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->p.getImpegno().compareTo(importoA)>0).findAny().isPresent());

	}
	
	@Test
	public void testAggiornaSemaforiAnagrafica(){
		
		AggiornaSemaforiAnagraficaInDTO aggiornaSemaforiAnagrafica_InDTO = new AggiornaSemaforiAnagraficaInDTO();
		aggiornaSemaforiAnagrafica_InDTO.setUsername("topolino");
		List<SettoreAttivitaDTO> content = new ArrayList<SettoreAttivitaDTO>();
		
		SettoreAttivitaDTO settore1 = new SettoreAttivitaDTO();
		settore1.setId(1074);
		settore1.setStatoAntimafia(StatoAntimafia.CERTIFICATO_VALIDO );
		settore1.setUnbundling(Unbundling.BLOCCATA);
		content.add(settore1);
		SettoreAttivitaDTO settore2 = new SettoreAttivitaDTO();
		settore2.setId(173);
		settore2.setStatoAntimafia(StatoAntimafia.ATTESA_DOCUMENTAZIONE );

		settore2.setUnbundling(Unbundling.BLOCCATA);
		content.add(settore2);
		aggiornaSemaforiAnagrafica_InDTO.getContent().addAll(content);
		
		AggiornaSemaforiAnagraficaOutDTO output = usciteWS.aggiornaSemaforiAnagrafica(aggiornaSemaforiAnagrafica_InDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		

	}
	
	@Test
	public void testAggiornaFideiussione(){
		
		AggiornaFideiussioneInDTO inDTO = new AggiornaFideiussioneInDTO();
		inDTO.setUsername("valerio");
		
		 AggiornaFideiussioneDTO aggFidDTO = new AggiornaFideiussioneDTO();
		 aggFidDTO.setCodicePratica("2013B000663NV44DIC100AXEDSTD01");
		 aggFidDTO.setFideiussione(FideiussionePratica.PRESENTE);
		 inDTO.getContent().add(aggFidDTO);

		 AggiornaFideiussioneDTO aggFidDTO2 = new AggiornaFideiussioneDTO();
		 aggFidDTO2.setCodicePratica("2013B001957NV44DIC100AXEDSTD01");
		 aggFidDTO2.setFideiussione(FideiussionePratica.ASSENTE);
		 inDTO.getContent().add(aggFidDTO2);
		 
		 AggiornaFideiussioneDTO aggFidDTO3 = new AggiornaFideiussioneDTO();
		 aggFidDTO3.setCodicePratica("2013B000485NV44DICZ03AXEDSTD01");
		 aggFidDTO3.setFideiussione(FideiussionePratica.PRESENTE);
		 inDTO.getContent().add(aggFidDTO3);
		
		AggiornaFideiussioneOutDTO output = usciteWS.aggiornaFideiussione(inDTO);
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS || output.getEsito() == Esito.APPLICATION_ERROR);		

	}
	
}
