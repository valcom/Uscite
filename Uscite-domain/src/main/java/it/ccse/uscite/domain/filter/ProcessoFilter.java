/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;
import it.ccse.uscite.domain.QProcessoErogazione;
import it.ccse.uscite.domain.specification.ProcessoSpecifications;

/**
 * @author vcompagnone
 *
 */
public class ProcessoFilter extends PageableFilter<ProcessoErogazione> {

	private String owner;
	
	private OrdineDelGiorno ordineDelGiorno;
	
	private Integer numeroNota;
	
	private BigInteger idNota;
	
	private List<StatoLavorazioneContabile> statiLavorazioneContabile;
	
	private List<StatoProcesso> stati; 
	
	@Override
	public Predicate getPredicate() {
		QProcessoErogazione processo = QProcessoErogazione.processoErogazione;
		BooleanExpression hasOwner = getOwner() !=null ? processo.owner.eq(getOwner()):null; 
		BooleanExpression hasOrdineDelGiorno = getOrdineDelGiorno() != null ? processo.ordineDelGiorno.eq(getOrdineDelGiorno()):null;
		BooleanExpression hasNumeroNota = getNumeroNota() != null ? processo.numeroNota.eq(getNumeroNota()):null;
		BooleanExpression hasStatoLavorazioneContabileIn = getStatiLavorazioneContabile() !=null ? processo.lavorazioneContabile.in(getStatiLavorazioneContabile()):null;
		BooleanExpression hasStato = getStati() !=null ? processo.stato.in(getStati()):null;
		BooleanExpression hasId = getIdNota() != null ? processo.id.eq(getIdNota()):null;
		return new BooleanBuilder().orAllOf(hasId,hasOwner,hasOrdineDelGiorno,hasNumeroNota,hasStatoLavorazioneContabileIn,hasStato);
	}

	@Override
	public Specification<ProcessoErogazione> getSpecification() {
		return Specifications.where(ProcessoSpecifications.hasId(getIdNota())).
				and(ProcessoSpecifications.hasNumeroNota(getNumeroNota())).
				and(ProcessoSpecifications.hasOrdineDelGiorno(getOrdineDelGiorno())).
				and(ProcessoSpecifications.hasOwner(getOwner())).
				and(ProcessoSpecifications.hasStato(getStati())).
				and(ProcessoSpecifications.hasStatoLavorazioneContabile(getStatiLavorazioneContabile()));
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the ordineDelGiorno
	 */
	public OrdineDelGiorno getOrdineDelGiorno() {
		return ordineDelGiorno;
	}

	/**
	 * @param ordineDelGiorno the ordineDelGiorno to set
	 */
	public void setOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		this.ordineDelGiorno = ordineDelGiorno;
	}

	/**
	 * @return the numeroNota
	 */
	public Integer getNumeroNota() {
		return numeroNota;
	}

	/**
	 * @param numeroNota the numeroNota to set
	 */
	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	
	
	public void setIdOrdineDelGiorno(BigInteger idOrdineDelGiorno){
		if(idOrdineDelGiorno!=null){
			ordineDelGiorno = new OrdineDelGiorno();
			ordineDelGiorno.setId(idOrdineDelGiorno);
		}
	}
	
	public void setIdComitato(BigInteger idOrdineDelGiorno){
		setIdOrdineDelGiorno(idOrdineDelGiorno);
	}

	/**
	 * @return the idNota
	 */
	public BigInteger getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(BigInteger idNota) {
		this.idNota = idNota;
	}

	/**
	 * @return the statiLavorazioneContabile
	 */
	public List<StatoLavorazioneContabile> getStatiLavorazioneContabile() {
		return statiLavorazioneContabile;
	}

	/**
	 * @param statiLavorazioneContabile the statiLavorazioneContabile to set
	 */
	public void setStatiLavorazioneContabile(List<StatoLavorazioneContabile> statiLavorazioneContabile) {
		this.statiLavorazioneContabile = statiLavorazioneContabile;
	}

	/**
	 * @return the stati
	 */
	public List<StatoProcesso> getStati() {
		return stati;
	}

	/**
	 * @param stati the stati to set
	 */
	public void setStati(List<StatoProcesso> stati) {
		this.stati = stati;
	}

}
