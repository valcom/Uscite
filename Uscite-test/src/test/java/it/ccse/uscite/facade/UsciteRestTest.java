/**
 * 
 */
package it.ccse.uscite.facade;

import java.math.BigDecimal;
import java.util.Base64;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import it.ccse.uscite.usciteWS.Esito;
import it.ccse.uscite.usciteWS.SearchPraticheOutDTO;

/**
 * @author valer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath:spring/wsClient-context.xml"} )
public class UsciteRestTest {
	
	private HttpHeaders getHeaders(){
		String plainCreds = "restUser:ccse2014";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getUrlEncoder().encode(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + base64Creds);
		headers.add(HttpHeaders.ACCEPT, "application/json");
		return headers;
	}

	@Test
	public void testGetPratiche(){
		Integer annoDa = 2014,annoA =2014,pageNumber = 0,pageSize=10;
		BigDecimal importoA = new BigDecimal(500);
		Boolean erogabile = true;
		String url = "http://localhost:8080/uscite-ws/services/usciteRestWS/pratiche";
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
		uriBuilder.queryParam("annoDa", annoDa);
		uriBuilder.queryParam("annoA", annoA);
		uriBuilder.queryParam("erogabile", erogabile);
		uriBuilder.queryParam("pageNumber", pageNumber);
		uriBuilder.queryParam("pageSize", pageSize);
		uriBuilder.queryParam("importoA", importoA);

		
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<SearchPraticheOutDTO> response = new RestTemplate().exchange(uriBuilder.toUriString(), HttpMethod.GET, request, SearchPraticheOutDTO.class);

		
		SearchPraticheOutDTO output = response.getBody();
		Assert.assertTrue(output.getEsito() == Esito.SUCCESS);
		Assert.assertFalse(output.getContent().stream().filter(p->!p.getAnno().equals(annoA)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->!p.isErogabile().equals(erogabile)).findAny().isPresent());
		Assert.assertFalse(output.getContent().stream().filter(p->p.getImpegno().compareTo(importoA)>0).findAny().isPresent());

	}
	
}
