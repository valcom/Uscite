/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;


/**
 * @author vcompagnone
 *
 */
public class Container<T>{
	
	protected T content;
	
	public Container() {
		super();
	}

	public Container(T content) {
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public T getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(T content) {
		this.content = content;
	}

}
