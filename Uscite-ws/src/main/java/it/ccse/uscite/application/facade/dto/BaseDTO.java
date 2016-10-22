/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author vcompagnone
 *
 */

public abstract class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
