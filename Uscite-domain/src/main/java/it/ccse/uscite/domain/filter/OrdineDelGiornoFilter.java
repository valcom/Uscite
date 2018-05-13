/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;
import it.ccse.uscite.domain.OrdineDelGiorno_;
import it.ccse.uscite.domain.ProcessoErogazione_;

/**
 * @author vcompagnone
 *
 */
public class OrdineDelGiornoFilter extends PageableFilter<OrdineDelGiorno> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -887429734623457865L;
	private BigInteger idComitato;
	private Date dataComitatoDa;
	private Date dataComitatoA;
	private StatoComitato stato;

	@Override
	public Predicate toPredicate(Root<OrdineDelGiorno> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		root.fetch(OrdineDelGiorno_.processiErogazione).fetch(ProcessoErogazione_.praticheErogazione);
		if (dataComitatoA != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato), dataComitatoA));
		}
		if (dataComitatoDa != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato), dataComitatoDa));
		}
		if (idComitato != null) {
			predicates.add(cb.equal(root.get(OrdineDelGiorno_.id), idComitato));
		}
		if (stato != null) {
			predicates.add(cb.equal(root.get(OrdineDelGiorno_.stato), stato));
		}
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	/**
	 * @return the idComitato
	 */
	public BigInteger getIdComitato() {
		return idComitato;
	}

	/**
	 * @param idComitato
	 *            the idComitato to set
	 */
	public void setIdComitato(BigInteger idComitato) {
		this.idComitato = idComitato;
	}

	/**
	 * @return the dataComitatoDa
	 */
	public Date getDataComitatoDa() {
		return dataComitatoDa;
	}

	/**
	 * @param dataComitatoDa
	 *            the dataComitatoDa to set
	 */
	public void setDataComitatoDa(Date dataComitatoDa) {
		this.dataComitatoDa = dataComitatoDa;
	}

	/**
	 * @return the dataComitatoA
	 */
	public Date getDataComitatoA() {
		return dataComitatoA;
	}

	/**
	 * @param dataComitatoA
	 *            the dataComitatoA to set
	 */
	public void setDataComitatoA(Date dataComitatoA) {
		this.dataComitatoA = dataComitatoA;
	}

	/**
	 * @return the stato
	 */
	public StatoComitato getStato() {
		return stato;
	}

	/**
	 * @param stato
	 *            the stato to set
	 */
	public void setStato(StatoComitato stato) {
		this.stato = stato;
	}
}
