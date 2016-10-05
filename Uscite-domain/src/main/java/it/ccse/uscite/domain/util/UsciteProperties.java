/**
 * 
 */
package it.ccse.uscite.domain.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author vcompagnone
 *
 */
public class UsciteProperties {
	public final static List<String> LISTA_ARTICOLI_UNBUNDLING;
	
	public final static List<String> LISTA_COMPONENTI_TARIFFARIE_FIDEIUSSIONE;
	
	public final static Integer SOGLIA_GIORNI_SBLOCCO_DATA_REGOLAZIONE;
	
	public final static List<String> LISTA_COMPONENTI_TARIFFARIE_SOGGETTE_BLOCCO_UNBUNDLING;
	
	static{
		Properties prop = new Properties();
		InputStream in = UsciteProperties.class.getClassLoader().getResourceAsStream("properties/uscite.properties");
		
		try {
			prop.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e); 
		}
		
		String[] arrayUnb = prop.getProperty("unbundling.idArticolo.list").split(",");
		String[] arrayFid = prop.getProperty("fideiussione.componentiTariffarie.list").split(",");
		String sogliaGiorniSbloccoDataRegolazione = prop.getProperty("sogliaGiorniSbloccoDataRegolazione");
		String[] listaComponentiTariffarieSoggetteBlocco= prop.getProperty("unbundling.listaComponentiTariffarieSoggetteBlocco").split(",");
		
		
		LISTA_ARTICOLI_UNBUNDLING = Arrays.asList(arrayUnb);
		LISTA_COMPONENTI_TARIFFARIE_FIDEIUSSIONE = Arrays.asList(arrayFid);
		SOGLIA_GIORNI_SBLOCCO_DATA_REGOLAZIONE = Integer.valueOf(sogliaGiorniSbloccoDataRegolazione);
		LISTA_COMPONENTI_TARIFFARIE_SOGGETTE_BLOCCO_UNBUNDLING =  Arrays.asList(listaComponentiTariffarieSoggetteBlocco);
	}
}
