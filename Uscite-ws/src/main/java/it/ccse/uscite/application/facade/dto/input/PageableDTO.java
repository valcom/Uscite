/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input;

import javax.ws.rs.QueryParam;

/**
 * @author vcompagnone
 *
 */
public class PageableDTO extends Base_InDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@QueryParam("pageNumber")
	private Integer pageNumber;
	@QueryParam("pageSize")
	private Integer pageSize;
	@QueryParam("orderProperty")
	private String orderProperty = "id";
	@QueryParam("orderDirection")
	private Direction orderDirection = Direction.ASC;

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public enum Direction {
		ASC, DESC;
	}

	/**
	 * @return the orderProperty
	 */
	public String getOrderProperty() {
		return orderProperty;
	}

	/**
	 * @param orderProperty
	 *            the orderProperty to set
	 */
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}

	/**
	 * @return the orderDirection
	 */
	public Direction getOrderDirection() {
		return orderDirection;
	}

	/**
	 * @param orderDirection
	 *            the orderDirection to set
	 */
	public void setOrderDirection(Direction orderDirection) {
		this.orderDirection = orderDirection;
	}
}
