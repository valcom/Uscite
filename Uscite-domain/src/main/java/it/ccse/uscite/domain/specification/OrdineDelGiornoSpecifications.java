/**
 * 
 */
package it.ccse.uscite.domain.specification;

import java.math.BigInteger;
import java.util.Date;

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
	    return (root,cq,cb)->stato !=null ? cb.equal(root.get(OrdineDelGiorno_.stato),stato):null;
	  }
	
	/**
	 * @param idComitato
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasId(BigInteger idComitato) {
		return  (root,cq,cb)->idComitato !=null ?  cb.equal(root.get(OrdineDelGiorno_.id),idComitato):null;
	  }
	
	/**
	 * 
	 * @param dataComitatoDa
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasDataComitatoDa(Date dataComitatoDa) {
	    return (root,cq,cb)->dataComitatoDa !=null ?  cb.greaterThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato),dataComitatoDa):null;
	  }
	
	/**
	 * 
	 * @param dataComitatoA
	 * @return
	 */
	public static Specification<OrdineDelGiorno> hasDataComitatoA(Date dataComitatoA) {
	   return  (root,cq,cb)-> dataComitatoA !=null ?  cb.lessThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato),dataComitatoA):null;
	  }
}
