/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output;

import java.util.List;

import it.ccse.uscite.application.facade.dto.ContainerDTO;


/**
 * @author vcompagnone
 *
 */
public abstract class PageDTO<T> extends Base_OutDTO implements ContainerDTO<List<T>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long totalElements; 
	private Integer	totalPages; 
	
	private Integer number; 
	private Integer	numberOfElements; 
	private Integer	size;
	/**
	 * @return the totalElements
	 */
	public Long getTotalElements() {
		return totalElements;
	}
	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * @return the numberOfElements
	 */
	public Integer getNumberOfElements() {
		return numberOfElements;
	}
	/**
	 * @param numberOfElements the numberOfElements to set
	 */
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	
}
