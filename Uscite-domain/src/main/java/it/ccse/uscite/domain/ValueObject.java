/**
 * 
 */
package it.ccse.uscite.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * @author vcompagnone
 *
 */
public abstract class ValueObject extends DomainObject{
		
	@Override
	public boolean equals(Object o){
		return EqualsBuilder.reflectionEquals(this,o); 
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
}
