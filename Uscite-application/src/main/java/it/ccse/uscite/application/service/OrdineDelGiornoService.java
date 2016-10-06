/**
 * 
 */
package it.ccse.uscite.application.service;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author vcompagnone
 *
 */
public interface OrdineDelGiornoService {
	public Page<OrdineDelGiorno> getOrdiniDelGiorno(Pageable p);
	
	public List<OrdineDelGiorno> getOrdiniDelGiorno();
	
	public Set<OrdineDelGiorno> getOrdiniDelGiornoAutorizzabili();
	
	public OrdineDelGiorno createOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public OrdineDelGiorno updateOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public OrdineDelGiorno apriOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public OrdineDelGiorno chiudiOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public void eliminaOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);

	public Page<OrdineDelGiorno> searchComitati(OrdineDelGiornoFilter req);
	
	public OrdineDelGiorno getOrdineDelGiorno(BigInteger idOrdineDelGiorno);

}
