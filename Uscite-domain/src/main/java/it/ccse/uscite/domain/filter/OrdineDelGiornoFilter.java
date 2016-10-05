/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;
import it.ccse.uscite.domain.QOrdineDelGiorno;
import it.ccse.uscite.domain.specification.OrdineDelGiornoSpecifications;

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
	public Predicate getPredicate() {
		QOrdineDelGiorno odg = QOrdineDelGiorno.ordineDelGiorno;
		BooleanExpression hasId = idComitato != null ? odg.id.eq(idComitato):null;
		BooleanExpression hasDataComitatoDa = dataComitatoDa!=null ? odg.dataComitato.goe(dataComitatoDa):null;
		BooleanExpression hasDataComitatoA = dataComitatoA!=null ? odg.dataComitato.loe(dataComitatoA):null;
		BooleanExpression hasStato = stato != null ? odg.stato.eq(stato):null;
		return new BooleanBuilder().orAllOf(hasId,hasDataComitatoDa,hasDataComitatoA,hasStato);
	}

	@Override
	public Specification<OrdineDelGiorno> getSpecification() {
		return Specifications.where(OrdineDelGiornoSpecifications.hasDataComitatoA(getDataComitatoA())).
				and(OrdineDelGiornoSpecifications.hasDataComitatoDa(getDataComitatoDa())).
				and(OrdineDelGiornoSpecifications.hasId(getIdComitato())).
				and(OrdineDelGiornoSpecifications.hasStato(getStato()));
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
