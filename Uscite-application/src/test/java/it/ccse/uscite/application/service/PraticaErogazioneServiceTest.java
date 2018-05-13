/**
 * 
 */
package it.ccse.uscite.application.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

/**
 * @author vcompagnone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/application-context.xml", "classpath:/spring/infrastructure-context.xml", "classpath:spring/datasource-test.xml" })
@Transactional
public class PraticaErogazioneServiceTest {
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;

	@Test
	public void testLoadByID() {
		BigInteger id = BigInteger.valueOf(4733);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		assertNotNull(pratica);
		assertTrue(pratica.getId().equals(id));
	}

	@Test
	public void testDelete() {
		BigInteger id = BigInteger.valueOf(11037);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		praticaErogazioneService.delete(pratica);
		pratica = praticaErogazioneService.getById(id);
		assertNull(pratica);
	}

	@Test
	public void testInsert() {
		BigInteger id = BigInteger.valueOf(11037);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		praticaErogazioneService.delete(pratica);
		pratica.setLavorazioneContabile(StatoPratica.UNDEFINED);
		praticaErogazioneService.createPraticaErogazione(pratica);
		assertNotNull(pratica);
	}

	@Test
	public void testUpdate() {
		BigInteger id = BigInteger.valueOf(4733);
		PraticaErogazione pratica = praticaErogazioneService.getById(id);
		Integer annoDaInserire = 2013;
		pratica.setAnno(annoDaInserire);
		praticaErogazioneService.savePraticaErogazione(pratica);
		pratica = praticaErogazioneService.getById(id);
		boolean test = pratica.getAnno().equals(annoDaInserire);
		assertTrue(test);
	}

	@Test
	public void testGetByCodicePratica() {
		String codicePratica = "2013B0215212V11DICXX0GASDSTD01";
		PraticaErogazione pratica = praticaErogazioneService.getByCodicePratica(codicePratica);
		assertNotNull(pratica);
		assertTrue(pratica.getCodicePratica().equals(codicePratica));
	}

	@Test
	public void testSearchPraticheErogazione() {
		PraticaFilter filter = new PraticaFilter();
		filter.setPageNumber(0);
		filter.setPageSize(10);
		filter.setAnnoDa(2013);
		filter.setAnnoA(2014);
		// filter.setErogabile(true);
		Page<PraticaErogazione> pratiche = praticaErogazioneService.searchPraticheErogazione(filter);
		assertFalse(CollectionUtils.isEmpty(pratiche.getContent()));
	}
}
