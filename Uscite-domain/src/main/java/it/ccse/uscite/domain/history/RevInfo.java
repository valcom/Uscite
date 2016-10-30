/**
 * 
 */
package it.ccse.uscite.domain.history;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import it.ccse.uscite.domain.DomainEntity;

/**
 * @author valer
 *
 */
@Entity
@Table(name="revinfo")
@RevisionEntity
public class RevInfo extends DomainEntity<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3124661066755335128L;

	@RevisionTimestamp
	private long timestamp;

	@RevisionNumber
	public Integer getId() {
		return super.getId();
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	
	
	
}
