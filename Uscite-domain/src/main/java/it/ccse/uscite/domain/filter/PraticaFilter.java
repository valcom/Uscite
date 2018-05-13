/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.CollectionUtils;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.OrdineDelGiorno_;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.PraticaErogazione_;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione_;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.SettoreAttivita_;
import it.ccse.uscite.domain.StatoComitato;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.domain.StatoComitato_;
import it.ccse.uscite.domain.StatoContabile;
import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;
import it.ccse.uscite.domain.StatoContabile_;
import it.ccse.uscite.domain.StatoFideiussione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoFideiussione_;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoLegale_;
import it.ccse.uscite.domain.StatoUnbundling;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;
import it.ccse.uscite.domain.StatoUnbundling_;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author vcompagnone
 *
 */
public class PraticaFilter extends PageableFilter<PraticaErogazione> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5871703177906919843L;
	private List<BigInteger> listaIdSettoriAttivita;
	private Date dataComitatoDa;
	private Date dataComitatoA;
	private Integer numeroNota;
	private BigDecimal importoDa;
	private BigDecimal importoA;
	private BigInteger idComponenteTariffaria;
	private BigInteger idPosizioneFinanziaria;
	private List<AutorizzazioneLegale> listaValoriAutorizzazioneLegale;
	private AutorizzazioneComitato autorizzazioneComitato;
	private AutorizzazioneContabile autorizzazioneContabile;
	private Date dataScadenzaDa;
	private Date dataScadenzaA;
	private Date dataInteressiDa;
	private Date dataInteressiA;
	private List<StatoPratica> statiPratica;
	private Integer annoDa;
	private Integer annoA;
	private TipoPeriodo tipoPeriodo;
	private Integer periodo;
	private Boolean erogabile;
	private FideiussionePratica fideiussione;
	private UnbundlingPratica unbundling;
	private BigInteger idProcessoErogazione;
	private List<String> codiciPratica;
	private Date dataFideiussioneDa;
	private Date dataFideiussioneA;

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

	/**
	 * @return the importoDa
	 */
	public BigDecimal getImportoDa() {
		return importoDa;
	}

	/**
	 * @param importoDa
	 *            the importoDa to set
	 */
	public void setImportoDa(BigDecimal importoDa) {
		this.importoDa = importoDa;
	}

	/**
	 * @return the importoA
	 */
	public BigDecimal getImportoA() {
		return importoA;
	}

	/**
	 * @param importoA
	 *            the importoA to set
	 */
	public void setImportoA(BigDecimal importoA) {
		this.importoA = importoA;
	}

	/**
	 * @return the idComponenteTariffaria
	 */
	public BigInteger getIdComponenteTariffaria() {
		return idComponenteTariffaria;
	}

	/**
	 * @param idComponenteTariffaria
	 *            the idComponenteTariffaria to set
	 */
	public void setIdComponenteTariffaria(BigInteger idComponenteTariffaria) {
		this.idComponenteTariffaria = idComponenteTariffaria;
	}

	/**
	 * @return the idPosizioneFinanziaria
	 */
	public BigInteger getIdPosizioneFinanziaria() {
		return idPosizioneFinanziaria;
	}

	/**
	 * @param idPosizioneFinanziaria
	 *            the idPosizioneFinanziaria to set
	 */
	public void setIdPosizioneFinanziaria(BigInteger idPosizioneFinanziaria) {
		this.idPosizioneFinanziaria = idPosizioneFinanziaria;
	}

	/**
	 * @return the statiPratica
	 */
	public List<StatoPratica> getStatiPratica() {
		return statiPratica;
	}

	/**
	 * @param statiPratica
	 *            the statiPratica to set
	 */
	public void setStatiPratica(List<StatoPratica> statiPratica) {
		this.statiPratica = statiPratica;
	}

	/**
	 * @return the annoDa
	 */
	public Integer getAnnoDa() {
		return annoDa;
	}

	/**
	 * @param annoDa
	 *            the annoDa to set
	 */
	public void setAnnoDa(Integer annoDa) {
		this.annoDa = annoDa;
	}

	/**
	 * @return the annoA
	 */
	public Integer getAnnoA() {
		return annoA;
	}

	/**
	 * @param annoA
	 *            the annoA to set
	 */
	public void setAnnoA(Integer annoA) {
		this.annoA = annoA;
	}

	/**
	 * @return the tipoPeriodo
	 */
	public TipoPeriodo getTipoPeriodo() {
		return tipoPeriodo;
	}

	/**
	 * @param tipoPeriodo
	 *            the tipoPeriodo to set
	 */
	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	/**
	 * @return the periodo
	 */
	public Integer getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the erogabile
	 */
	public Boolean getErogabile() {
		return erogabile;
	}

	/**
	 * @param erogabile
	 *            the erogabile to set
	 */
	public void setErogabile(Boolean erogabile) {
		this.erogabile = erogabile;
	}

	public void setIdNota(BigInteger idNota) {
		idProcessoErogazione = idNota;
	}

	public void setListaIdSettoriAttivita(List<BigInteger> listaIdSettoriAttivita) {
		this.listaIdSettoriAttivita = listaIdSettoriAttivita;
	}

	public List<BigInteger> getListaIdSettoriAttivita() {
		return listaIdSettoriAttivita;
	}

	@Override
	public Predicate toPredicate(Root<PraticaErogazione> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		Join<PraticaErogazione, ProcessoErogazione> joinNota = root.join(PraticaErogazione_.processoErogazione);
		Join<ProcessoErogazione, OrdineDelGiorno> joinComitato = joinNota.join(ProcessoErogazione_.ordineDelGiorno);
		root.fetch(PraticaErogazione_.processoErogazione).fetch(ProcessoErogazione_.ordineDelGiorno);
		root.fetch(PraticaErogazione_.statoComitato);
		root.fetch(PraticaErogazione_.statoContabile);
		root.fetch(PraticaErogazione_.statoLegale);
		root.fetch(PraticaErogazione_.statoFideiussione);
		root.fetch(PraticaErogazione_.settoreAttivita);
		root.fetch(PraticaErogazione_.tipoPeriodo);
		root.fetch(PraticaErogazione_.statoUnbundling);
		if (annoA != null) {
			predicates.add(cb.le(root.get(PraticaErogazione_.anno), annoA));
		}
		if (annoDa != null) {
			predicates.add(cb.ge(root.get(PraticaErogazione_.anno), annoDa));
		}
		if (autorizzazioneComitato != null) {
			Join<PraticaErogazione, StatoComitato> joinStatoComitato = root.join(PraticaErogazione_.statoComitato);
			predicates.add(cb.equal(joinStatoComitato.get(StatoComitato_.valore), autorizzazioneComitato));
		}
		if (autorizzazioneContabile != null) {
			Join<PraticaErogazione, StatoContabile> joinStatoContabile = root.join(PraticaErogazione_.statoContabile);
			predicates.add(cb.equal(joinStatoContabile.get(StatoContabile_.valore), autorizzazioneContabile));
		}
		if (!CollectionUtils.isEmpty(listaValoriAutorizzazioneLegale)) {
			Join<PraticaErogazione, StatoLegale> joinStatoLegale = root.join(PraticaErogazione_.statoLegale);
			predicates.add(joinStatoLegale.get(StatoLegale_.valore).in(listaValoriAutorizzazioneLegale));
		}
		if (!CollectionUtils.isEmpty(codiciPratica)) {
			predicates.add(root.get(PraticaErogazione_.codicePratica).in(codiciPratica));
		}
		if (idComponenteTariffaria != null) {
			predicates.add(cb.equal(root.get(PraticaErogazione_.idComponenteTariffariaAc), idComponenteTariffaria));
		}
		if (dataComitatoA != null) {
			predicates.add(cb.lessThanOrEqualTo(joinComitato.get(OrdineDelGiorno_.dataComitato), dataComitatoA));
		}
		if (dataFideiussioneA != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi), dataFideiussioneA));
		}
		if (dataComitatoDa != null) {
			predicates.add(cb.greaterThanOrEqualTo(joinComitato.get(OrdineDelGiorno_.dataComitato), dataComitatoDa));
		}
		if (dataFideiussioneDa != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataFideiussione), dataFideiussioneDa));
		}
		if (dataInteressiA != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi), dataInteressiA));
		}
		if (dataInteressiDa != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi), dataInteressiDa));
		}
		if (dataScadenzaA != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataScadenza), dataScadenzaA));
		}
		if (dataScadenzaDa != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataScadenza), dataScadenzaDa));
		}
		if (fideiussione != null) {
			Join<PraticaErogazione, StatoFideiussione> joinStatoFideiussione = root.join(PraticaErogazione_.statoFideiussione);
			predicates.add(cb.equal(joinStatoFideiussione.get(StatoFideiussione_.valore), fideiussione));
		}
		if (importoA != null) {
			predicates.add(cb.le(root.get(PraticaErogazione_.impegno), importoA));
		}
		if (importoDa != null) {
			predicates.add(cb.ge(root.get(PraticaErogazione_.impegno), importoDa));
		}
		if (numeroNota != null) {
			predicates.add(cb.equal(joinNota.get(ProcessoErogazione_.numeroNota), numeroNota));
		}
		if (idPosizioneFinanziaria != null) {
			predicates.add(cb.equal(root.get(PraticaErogazione_.idPosizioneFinanziariaAc), idPosizioneFinanziaria));
		}
		if (idProcessoErogazione != null) {
			predicates.add(cb.equal(joinNota.get(ProcessoErogazione_.id), idProcessoErogazione));
		}
		if (!CollectionUtils.isEmpty(listaIdSettoriAttivita)) {
			Join<PraticaErogazione, SettoreAttivita> joinSettoreAttivita = root.join(PraticaErogazione_.settoreAttivita);
			predicates.add(joinSettoreAttivita.get(SettoreAttivita_.id).in(listaIdSettoriAttivita));
		}
		if (!CollectionUtils.isEmpty(statiPratica)) {
			predicates.add(root.get(PraticaErogazione_.lavorazioneContabile).in(statiPratica));
		}
		if (tipoPeriodo != null) {
			Join<PraticaErogazione, TipoPeriodo> joinTipoPeriodo = root.join(PraticaErogazione_.tipoPeriodo);
			predicates.add(cb.equal(joinTipoPeriodo, tipoPeriodo));
		}
		if (unbundling != null) {
			Join<PraticaErogazione, StatoUnbundling> joinUnbundling = root.join(PraticaErogazione_.statoUnbundling);
			predicates.add(cb.equal(joinUnbundling.get(StatoUnbundling_.valore), unbundling));
		}
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	/**
	 * @return the idProcessoErogazione
	 */
	public BigInteger getIdProcessoErogazione() {
		return idProcessoErogazione;
	}

	/**
	 * @param idProcessoErogazione
	 *            the idProcessoErogazione to set
	 */
	public void setIdProcessoErogazione(BigInteger idProcessoErogazione) {
		this.idProcessoErogazione = idProcessoErogazione;
	}

	public List<String> getCodiciPratica() {
		return codiciPratica;
	}

	public void setCodiciPratica(List<String> codiciPratica) {
		this.codiciPratica = codiciPratica;
	}

	public Date getDataScadenzaDa() {
		return dataScadenzaDa;
	}

	public void setDataScadenzaDa(Date dataScadenzaDa) {
		this.dataScadenzaDa = dataScadenzaDa;
	}

	public Date getDataScadenzaA() {
		return dataScadenzaA;
	}

	public void setDataScadenzaA(Date dataScadenzaA) {
		this.dataScadenzaA = dataScadenzaA;
	}

	public Date getDataInteressiDa() {
		return dataInteressiDa;
	}

	public void setDataInteressiDa(Date dataInteressiDa) {
		this.dataInteressiDa = dataInteressiDa;
	}

	public Date getDataInteressiA() {
		return dataInteressiA;
	}

	public void setDataInteressiA(Date dataInteressiA) {
		this.dataInteressiA = dataInteressiA;
	}

	public Date getDataFideiussioneDa() {
		return dataFideiussioneDa;
	}

	public void setDataFideiussioneDa(Date dataFideiussioneDa) {
		this.dataFideiussioneDa = dataFideiussioneDa;
	}

	public Date getDataFideiussioneA() {
		return dataFideiussioneA;
	}

	public void setDataFideiussioneA(Date dataFideiussioneA) {
		this.dataFideiussioneA = dataFideiussioneA;
	}

	public FideiussionePratica getFideiussione() {
		return fideiussione;
	}

	public void setFideiussione(FideiussionePratica fideiussione) {
		this.fideiussione = fideiussione;
	}

	public List<AutorizzazioneLegale> getListaValoriAutorizzazioneLegale() {
		return listaValoriAutorizzazioneLegale;
	}

	public void setListaValoriAutorizzazioneLegale(List<AutorizzazioneLegale> listaValoriAutorizzazioneLegale) {
		this.listaValoriAutorizzazioneLegale = listaValoriAutorizzazioneLegale;
	}

	public AutorizzazioneComitato getAutorizzazioneComitato() {
		return autorizzazioneComitato;
	}

	public void setAutorizzazioneComitato(AutorizzazioneComitato autorizzazioneComitato) {
		this.autorizzazioneComitato = autorizzazioneComitato;
	}

	public AutorizzazioneContabile getAutorizzazioneContabile() {
		return autorizzazioneContabile;
	}

	public void setAutorizzazioneContabile(AutorizzazioneContabile autorizzazioneContabile) {
		this.autorizzazioneContabile = autorizzazioneContabile;
	}

	public UnbundlingPratica getUnbundling() {
		return unbundling;
	}

	public void setUnbundling(UnbundlingPratica unbundling) {
		this.unbundling = unbundling;
	}
}
