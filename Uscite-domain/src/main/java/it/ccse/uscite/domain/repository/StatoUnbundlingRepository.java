/**
 * 
 */
package it.ccse.uscite.domain.repository;

import it.ccse.uscite.domain.StatoUnbundling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author vcompagnone
 *
 */
public interface StatoUnbundlingRepository extends JpaRepository<StatoUnbundling, String>,QueryDslPredicateExecutor<StatoUnbundling> {

}
