/**
 * 
 */
package it.ccse.uscite.application.service;

import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author vcompagnone
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath:*spring/persistence-context-test.xml","classpath:/spring/application-context.xml"} )
@Transactional
public class PraticaErogazioneServiceTest {
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Test
	public void testLoadByID(){
		BigInteger id = BigInteger.valueOf(4733);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		Assert.notNull(pratica);
		boolean test = pratica.getId().equals(id);
		Assert.isTrue(test);
	}
	@Test
	public void testDelete(){
		BigInteger id = BigInteger.valueOf(11037);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		praticaErogazioneService.delete(pratica);
		pratica = praticaErogazioneService.getById(id);
		Assert.isNull(pratica);
	
	}
	
	@Test
	public void testInsert(){
		BigInteger id = BigInteger.valueOf(11037);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		praticaErogazioneService.delete(pratica);
		pratica.setLavorazioneContabile(StatoPratica.UNDEFINED);
		praticaErogazioneService.createPraticaErogazione(pratica);
		Assert.notNull(pratica);
	}
	
	@Test
	public void testUpdate(){
		BigInteger id = BigInteger.valueOf(4733);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		Integer annoDaInserire = 2013;
		pratica.setAnno(annoDaInserire);
		praticaErogazioneService.savePraticaErogazione(pratica);
		pratica = praticaErogazioneService.getById(id);
		boolean test = pratica.getAnno().equals(annoDaInserire);
		Assert.isTrue(test);
	}

	@Test
	public void testGetByCodicePratica(){
		String codicePratica = "2013B0215212V11DICXX0GASDSTD01";
		PraticaErogazione pratica = praticaErogazioneService.getByCodicePratica(codicePratica);
		Assert.notNull(pratica);
		Assert.isTrue(pratica.getCodicePratica().equals(codicePratica));
	}
	
	@Test
	public void testSearchPraticheErogazione(){
		PraticaFilter filter = new PraticaFilter();
		filter.setAnnoDa(2013);
		filter.setAnnoA(2014);
		filter.setErogabile(true);
		
		Page<PraticaErogazione> pratiche = praticaErogazioneService.searchPraticheErogazione(filter );
		Assert.notNull(pratiche);
	}
	
}
