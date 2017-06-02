/**
 * 
 */
package it.ccse.uscite.domain.filter;

import org.springframework.data.jpa.domain.Specification;


import it.ccse.uscite.domain.DomainObject;

/**
 * @author vcompagnone
 *
 */
public interface Filter<T extends DomainObject> {
	
	public Specification<T> getSpecification();
}
