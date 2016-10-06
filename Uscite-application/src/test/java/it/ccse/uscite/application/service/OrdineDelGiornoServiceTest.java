/**
 * 
 */
package it.ccse.uscite.application.service;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author valer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath:/spring/application-context.xml","classpath:/spring/datasource.xml"} )

@Transactional
public class OrdineDelGiornoServiceTest {

	@Autowired
	private OrdineDelGiornoService ordineDelGiornoService;
	
	@Test
	public void testLoadByID(){
		BigInteger id = BigInteger.valueOf(33);
		OrdineDelGiorno o = ordineDelGiornoService.getOrdineDelGiorno(id);
		Assert.notNull(o);
		Assert.isTrue(o.getId().equals(id));
	}
}
