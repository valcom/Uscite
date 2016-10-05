/**
 * 
 */
package it.ccse.uscite.domain.repository;

import it.ccse.uscite.domain.TipoPeriodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author vcompagnone
 *
 */
public interface TipoPeriodoRepository extends JpaRepository<TipoPeriodo, String>,QueryDslPredicateExecutor<TipoPeriodo> {

}
