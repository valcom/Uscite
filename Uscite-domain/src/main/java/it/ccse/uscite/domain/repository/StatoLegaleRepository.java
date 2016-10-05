/**
 * 
 */
package it.ccse.uscite.domain.repository;

import it.ccse.uscite.domain.StatoLegale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author vcompagnone
 *
 */
public interface StatoLegaleRepository  extends JpaRepository<StatoLegale, String>,QueryDslPredicateExecutor<StatoLegale>{
}
