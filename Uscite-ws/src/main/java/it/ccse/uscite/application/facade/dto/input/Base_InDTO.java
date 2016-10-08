/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input;

import it.ccse.uscite.application.facade.dto.BaseDTO;


/**
 * @author vcompagnone
 *
 */
public abstract class Base_InDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
