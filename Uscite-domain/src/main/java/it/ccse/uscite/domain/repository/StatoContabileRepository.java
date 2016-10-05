/**
 * 
 */
package it.ccse.uscite.domain.repository;

import it.ccse.uscite.domain.StatoContabile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author vcompagnone
 *
 */
public interface StatoContabileRepository extends JpaRepository<StatoContabile, String>,QueryDslPredicateExecutor<StatoContabile>{

}
