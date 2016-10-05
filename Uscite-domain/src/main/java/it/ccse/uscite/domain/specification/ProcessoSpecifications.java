/**
 * 
 */
package it.ccse.uscite.domain.specification;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;
import it.ccse.uscite.domain.ProcessoErogazione_;

/**
 * @author valer
 *
 */
public class ProcessoSpecifications {
		

	/**
	 * 
	 * @param owner
	 * @return
	 */
	public static Specification<ProcessoErogazione> hasOwner(String owner) {
	    return new Specification<ProcessoErogazione>() {

			@Override
			public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return owner !=null ? cb.equal(root.get(ProcessoErogazione_.owner),owner):null;
			}
	     
	    };
	  }
	
	/**
	 * 
	 * @param ordineDelGiorno
	 * @return
	 */
	public static Specification<ProcessoErogazione> hasOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
	    return new Specification<ProcessoErogazione>() {

			@Override
			public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return ordineDelGiorno !=null ? cb.equal(root.get(ProcessoErogazione_.ordineDelGiorno),ordineDelGiorno):null;
			}
	     
	    };
	  }
	
	/**
	 * 
	 * @param numeroNota
	 * @return
	 */
	public static Specification<ProcessoErogazione> hasNumeroNota(Integer numeroNota) {
	    return new Specification<ProcessoErogazione>() {

			@Override
			public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return numeroNota !=null ? cb.equal(root.get(ProcessoErogazione_.numeroNota),numeroNota):null;
			}
	     
	    };
	  }
	
	/**
	 * 
	 * @param idNota
	 * @return
	 */
	public static Specification<ProcessoErogazione> hasId(BigInteger idNota) {
	    return new Specification<ProcessoErogazione>() {

			@Override
			public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return idNota !=null ? cb.equal(root.get(ProcessoErogazione_.id),idNota):null;
			}
	     
	    };
	  }
	
	/**
	 * 
	 * @param statiLavorazioneContabile
	 * @return
	 */
	public static Specification<ProcessoErogazione> hasStatoLavorazioneContabile(List<StatoLavorazioneContabile> statiLavorazioneContabile) {
	    return new Specification<ProcessoErogazione>() {

			@Override
			public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return statiLavorazioneContabile !=null ? root.get(ProcessoErogazione_.lavorazioneContabile).in(statiLavorazioneContabile):null;
			}
	     
	    };
	  }
	
	
	/**
	 * 
	 * @param stati
	 * @return
	 */
	public static Specification<ProcessoErogazione> hasStato(List<StatoProcesso> stati) {
	    return new Specification<ProcessoErogazione>() {

			@Override
			public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				        return stati !=null ? root.get(ProcessoErogazione_.stato).in(stati):null;
			}
	     
	    };
	  }
}
