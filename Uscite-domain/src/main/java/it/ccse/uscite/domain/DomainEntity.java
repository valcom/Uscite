/**
 * 
 */
package it.ccse.uscite.domain;

import javax.persistence.Cacheable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.envers.Audited;

/**
 * @author vcompagnone
 *
 */
@MappedSuperclass
@Cacheable
@Audited
public abstract class DomainEntity<ID> extends DomainObject{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private ID id;
	
	
	private String username;
	
	public void setId(ID id){
		this.id = id;
	} 

	public ID getId(){
		return id;
	} 
	
	public boolean IsTransient() {
		return this.getId() == null;
	}

	public void clearIdentity() {
		this.setId(null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainEntity<?> other = (DomainEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
