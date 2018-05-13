/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;
import it.ccse.uscite.domain.ProcessoErogazione_;

/**
 * @author vcompagnone
 *
 */
public class ProcessoFilter extends PageableFilter<ProcessoErogazione> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2509416689556743068L;
	private String owner;
	private OrdineDelGiorno ordineDelGiorno;
	private Integer numeroNota;
	private BigInteger idNota;
	private List<StatoLavorazioneContabile> statiLavorazioneContabile;
	private List<StatoProcesso> stati;

	@Override
	public Predicate toPredicate(Root<ProcessoErogazione> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (idNota != null) {
			predicates.add(cb.equal(root.get(ProcessoErogazione_.id), idNota));
		}
		if (numeroNota != null) {
			predicates.add(cb.equal(root.get(ProcessoErogazione_.numeroNota), numeroNota));
		}
		if (ordineDelGiorno != null) {
			predicates.add(cb.equal(root.get(ProcessoErogazione_.ordineDelGiorno), ordineDelGiorno));
		}
		if (owner != null) {
			predicates.add(cb.equal(root.get(ProcessoErogazione_.owner), owner));
		}
		if (idNota != null) {
			predicates.add(cb.equal(root.get(ProcessoErogazione_.id), idNota));
		}
		if (stati != null) {
			predicates.add(root.get(ProcessoErogazione_.stato).in(stati));
		}
		if (statiLavorazioneContabile != null) {
			predicates.add(root.get(ProcessoErogazione_.lavorazioneContabile).in(statiLavorazioneContabile));
		}
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
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
	 * @param ordineDelGiorno
	 *            the ordineDelGiorno to set
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
	 * @param numeroNota
	 *            the numeroNota to set
	 */
	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	public void setIdOrdineDelGiorno(BigInteger idOrdineDelGiorno) {
		if (idOrdineDelGiorno != null) {
			ordineDelGiorno = new OrdineDelGiorno();
			ordineDelGiorno.setId(idOrdineDelGiorno);
		}
	}

	public void setIdComitato(BigInteger idOrdineDelGiorno) {
		setIdOrdineDelGiorno(idOrdineDelGiorno);
	}

	/**
	 * @return the idNota
	 */
	public BigInteger getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota
	 *            the idNota to set
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
	 * @param statiLavorazioneContabile
	 *            the statiLavorazioneContabile to set
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
	 * @param stati
	 *            the stati to set
	 */
	public void setStati(List<StatoProcesso> stati) {
		this.stati = stati;
	}
}
