/**
 * 
 */
package it.ccse.uscite.domain.specification;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;
import it.ccse.uscite.domain.OrdineDelGiorno_;

/**
 * @author valer
 *
 */
public class OrdineDelGiornoSpecifications {
	
	/**
	 * @param stato
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasStato(StatoComitato stato) {
	    return new Specification<OrdineDelGiorno>() {

			@Override
			public Predicate toPredicate(Root<OrdineDelGiorno> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return stato !=null ? cb.equal(root.get(OrdineDelGiorno_.stato),stato):null;
			}
	     
	    };
	  }
	
	/**
	 * @param idComitato
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasId(BigInteger idComitato) {
	    return new Specification<OrdineDelGiorno>() {

			@Override
			public Predicate toPredicate(Root<OrdineDelGiorno> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return idComitato !=null ?  cb.equal(root.get(OrdineDelGiorno_.id),idComitato):null;
			}
	     
	    };
	  }
	
	/**
	 * 
	 * @param dataComitatoDa
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasDataComitatoDa(Date dataComitatoDa) {
	    return new Specification<OrdineDelGiorno>() {

			@Override
			public Predicate toPredicate(Root<OrdineDelGiorno> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return dataComitatoDa !=null ?  cb.greaterThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato),dataComitatoDa):null;
			}
	     
	    };
	  }
	
	/**
	 * 
	 * @param dataComitatoA
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasDataComitatoA(Date dataComitatoA) {
	    return new Specification<OrdineDelGiorno>() {

			@Override
			public Predicate toPredicate(Root<OrdineDelGiorno> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return dataComitatoA !=null ?  cb.lessThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato),dataComitatoA):null;
			}
	     
	    };
	  }
}
