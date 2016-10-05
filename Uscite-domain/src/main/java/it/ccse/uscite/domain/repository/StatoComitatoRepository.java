/**
 * 
 */
package it.ccse.uscite.domain.repository;

import it.ccse.uscite.domain.StatoComitato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author vcompagnone
 *
 */
public interface StatoComitatoRepository extends JpaRepository<StatoComitato, String>,QueryDslPredicateExecutor<StatoComitato>{
}
