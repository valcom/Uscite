/**
 * 
 */
package it.ccse.uscite.domain.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;

/**
 * @author vcompagnone
 *
 */
public interface OrdineDelGiornoRepository extends JpaRepository<OrdineDelGiorno, BigInteger>, JpaSpecificationExecutor<OrdineDelGiorno> {
	public OrdineDelGiorno findByDataComitato(Date dataComitato);

	public Set<OrdineDelGiorno> findByDataComitatoLessThanEqualAndStato(Date today, StatoComitato chiuso);
}
