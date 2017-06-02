/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;
import it.ccse.uscite.domain.OrdineDelGiorno_;

/**
 * @author vcompagnone
 *
 */
public class OrdineDelGiornoFilter extends PageableFilter<OrdineDelGiorno> {

	private BigInteger idComitato;
	private Date dataComitatoDa;
	private Date dataComitatoA;
	private StatoComitato stato;

	

	@Override
	public Specification<OrdineDelGiorno> getSpecification() {
		Specification<OrdineDelGiorno> hasDataComitatoA = (root,cq,cb)-> dataComitatoA !=null ?  cb.lessThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato),dataComitatoA):null;
		Specification<OrdineDelGiorno> hasDataComitatoDa = (root,cq,cb)->dataComitatoDa !=null ?  cb.greaterThanOrEqualTo(root.get(OrdineDelGiorno_.dataComitato),dataComitatoDa):null;
		Specification<OrdineDelGiorno> hasId = (root,cq,cb)->idComitato !=null ?  cb.equal(root.get(OrdineDelGiorno_.id),idComitato):null;
		Specification<OrdineDelGiorno> hasStato = (root,cq,cb)->stato !=null ? cb.equal(root.get(OrdineDelGiorno_.stato),stato):null;
		return Specifications.where(hasDataComitatoA).
				and(hasDataComitatoDa).
				and(hasId).
				and(hasStato);
	}

	/**
	 * @return the idComitato
	 */
	public BigInteger getIdComitato() {
		return idComitato;
	}

	/**
	 * @param idComitato the idComitato to set
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
	 * @param dataComitatoDa the dataComitatoDa to set
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
	 * @param dataComitatoA the dataComitatoA to set
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
	 * @param stato the stato to set
	 */
	public void setStato(StatoComitato stato) {
		this.stato = stato;
	}

	
	
}
