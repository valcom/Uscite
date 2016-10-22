/**
 * 
 */
package it.ccse.uscite.application.facade.dto;



/**
 * @author vcompagnone
 *
 */
public abstract class DomainDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
