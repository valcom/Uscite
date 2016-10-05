/**
 * 
 */
package it.ccse.uscite.domain.repository;

import it.ccse.uscite.domain.StatoFideiussione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author vcompagnone
 *
 */
public interface StatoFideiussioneRepository  extends JpaRepository<StatoFideiussione, String>,QueryDslPredicateExecutor<StatoFideiussione>{

}
