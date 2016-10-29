/**
 * 
 */
package it.ccse.uscite.domain.history;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

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
	
	private String username;
	/**
	 * 
	 */
	public String getUsername(){
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@PrePersist
	public void setUsername(){
		username = (String) (RequestContextHolder.currentRequestAttributes().getAttribute("username",RequestAttributes.SCOPE_REQUEST));
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId();
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RevInfo other = (RevInfo) obj;
		if (getId() != other.getId())
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
