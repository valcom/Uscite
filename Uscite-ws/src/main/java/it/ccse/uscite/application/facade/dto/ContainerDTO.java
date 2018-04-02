/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

/**
 * @author vcompagnone
 *
 */
public interface ContainerDTO<T> {
	/**
	 * @return the content
	 */
	public T getContent();

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(T content);
}
