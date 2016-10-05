/**
 * 
 */
package it.ccse.uscite.domain.filter;

import org.springframework.data.jpa.domain.Specification;

import com.querydsl.core.types.Predicate;

import it.ccse.uscite.domain.DomainObject;

/**
 * @author vcompagnone
 *
 */
public interface Filter<T extends DomainObject> {

	public Predicate getPredicate();
	
	public Specification<T> getSpecification();
}
