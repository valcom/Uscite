/**
 * 
 */
package it.ccse.uscite.domain.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;


/**
 * @author vcompagnone
 *
 */
public interface OrdineDelGiornoRepository extends JpaRepository<OrdineDelGiorno, BigInteger>,QueryDslPredicateExecutor<OrdineDelGiorno>{
	
	public OrdineDelGiorno findByDataComitato(Date dataComitato);

	public Set<OrdineDelGiorno> findByDataComitatoLessThanEqualAndStato(Date today, StatoComitato chiuso);

	@EntityGraph(value="ordine.processi.pratiche")
	public OrdineDelGiorno findOne(BigInteger arg0);

}
