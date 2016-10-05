/**
 * 
 */
package it.ccse.uscite.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author vcompagnone
 *
 */
public abstract class DomainObject {
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
