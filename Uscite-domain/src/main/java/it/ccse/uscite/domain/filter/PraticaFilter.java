/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.util.CollectionUtils;

import it.ccse.uscite.domain.OrdineDelGiorno_;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.PraticaErogazione_;
import it.ccse.uscite.domain.ProcessoErogazione_;
import it.ccse.uscite.domain.SettoreAttivita_;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.domain.StatoComitato_;
import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;
import it.ccse.uscite.domain.StatoContabile_;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoFideiussione_;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoLegale_;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;
import it.ccse.uscite.domain.StatoUnbundling_;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author vcompagnone
 *
 */
public class PraticaFilter extends PageableFilter<PraticaErogazione>{
	
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
	
	private AutorizzazioneContabile autorizzazioneContabile ;
	
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


	/**
	 * @return the importoDa
	 */
	public BigDecimal getImportoDa() {
		return importoDa;
	}


	/**
	 * @param importoDa the importoDa to set
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
	 * @param importoA the importoA to set
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
	 * @param idComponenteTariffaria the idComponenteTariffaria to set
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
	 * @param idPosizioneFinanziaria the idPosizioneFinanziaria to set
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
	 * @param statiPratica the statiPratica to set
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
	 * @param annoDa the annoDa to set
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
	 * @param annoA the annoA to set
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
	 * @param tipoPeriodo the tipoPeriodo to set
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
	 * @param periodo the periodo to set
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
	 * @param erogabile the erogabile to set
	 */
	public void setErogabile(Boolean erogabile) {
		this.erogabile = erogabile;
	}
	
	
	
	public void setIdNota(BigInteger idNota){
		idProcessoErogazione = idNota;
	}
	
	public void setListaIdSettoriAttivita(List<BigInteger> listaIdSettoriAttivita){
		this.listaIdSettoriAttivita=listaIdSettoriAttivita;
	}
	
	public List<BigInteger> getListaIdSettoriAttivita(){
		return listaIdSettoriAttivita;
	}


	@Override
	public Specification<PraticaErogazione> getSpecification() {
		Specification<PraticaErogazione> hasAnnoA =  (root,cq,cb)->  annoA !=null ? cb.le(root.get(PraticaErogazione_.anno),annoA):null;
		Specification<PraticaErogazione> hasAnnoDa = (root,cq,cb) ->  annoDa!=null ? cb.ge(root.get(PraticaErogazione_.anno),annoDa):null;
		Specification<PraticaErogazione> hasAutorizzazioneComitato = (root,cq,cb)-> autorizzazioneComitato !=null ? cb.equal(root.get(PraticaErogazione_.statoComitato).get(StatoComitato_.valore),autorizzazioneComitato):null;
		Specification<PraticaErogazione> hasAutorizzazioneContabile =  (root,cq,cb)-> autorizzazioneContabile !=null ? cb.equal(root.get(PraticaErogazione_.statoContabile).get(StatoContabile_.valore),autorizzazioneContabile):null;
		Specification<PraticaErogazione> hasAutorizzazioneLegale = (root,cq,cb)-> !CollectionUtils.isEmpty(listaValoriAutorizzazioneLegale) ? root.get(PraticaErogazione_.statoLegale).get(StatoLegale_.valore).in(listaValoriAutorizzazioneLegale):null;
		Specification<PraticaErogazione> hasCodicePratica = (root,cq,cb)->  !CollectionUtils.isEmpty(codiciPratica) ? root.get(PraticaErogazione_.codicePratica).in(codiciPratica):null;
		Specification<PraticaErogazione> hasComponenteTariffaria = (root,cq,cb)-> idComponenteTariffaria !=null ? cb.equal(root.get(PraticaErogazione_.idComponenteTariffariaAc),idComponenteTariffaria):null;
		Specification<PraticaErogazione> hasDataComitatoA = (root,cq,cb)-> dataComitatoA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.ordineDelGiorno).get(OrdineDelGiorno_.dataComitato),dataComitatoA):null;
		Specification<PraticaErogazione> hasDataFideiussioneA = (root,cq,cb)->  dataFideiussioneA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi),dataFideiussioneA):null;
		Specification<PraticaErogazione> hasDataComitatoDa = (root,cq,cb)-> dataComitatoDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.ordineDelGiorno).get(OrdineDelGiorno_.dataComitato),dataComitatoDa):null;	
		Specification<PraticaErogazione> hasDataFideiussioneDa = (root,cq,cb)->  dataFideiussioneDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataFideiussione),dataFideiussioneDa):null;
		Specification<PraticaErogazione> hasDataInteressiA = (root,cq,cb)->  dataInteressiA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi),dataInteressiA):null;
		Specification<PraticaErogazione> hasDataInteressiDa = (root,cq,cb)->  dataInteressiDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi),dataInteressiDa):null;
		Specification<PraticaErogazione> hasDataScadenzaA = (root,cq,cb)-> dataScadenzaA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataScadenza),dataScadenzaA):null;
		Specification<PraticaErogazione> hasDataScadenzaDa = (root,cq,cb)-> dataScadenzaDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataScadenza),dataScadenzaDa):null;
		Specification<PraticaErogazione> hasFideiussione = (root,cq,cb)-> fideiussione !=null ? cb.equal(root.get(PraticaErogazione_.statoFideiussione).get(StatoFideiussione_.valore),fideiussione):null;
		Specification<PraticaErogazione> hasImportoA = (root,cq,cb)-> importoA !=null ? cb.le(root.get(PraticaErogazione_.impegno),importoA):null;
		Specification<PraticaErogazione> hasImportoDa = (root,cq,cb)-> importoDa!=null ? cb.ge(root.get(PraticaErogazione_.impegno),importoDa):null;
		Specification<PraticaErogazione> hasNumeroNota = (root,cq,cb)-> numeroNota !=null ? cb.equal(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.numeroNota),numeroNota):null;
		Specification<PraticaErogazione> hasPeriodo =  (root,cq,cb)->  periodo !=null ? cb.equal(root.get(PraticaErogazione_.periodo),periodo):null;
		Specification<PraticaErogazione> hasPosizioneFinanziaria =  (root,cq,cb)-> idPosizioneFinanziaria !=null ? cb.equal(root.get(PraticaErogazione_.idPosizioneFinanziariaAc),idPosizioneFinanziaria):null;
		Specification<PraticaErogazione> hasProcessoErogazione = (root,cq,cb)->  idProcessoErogazione !=null ? cb.equal(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.id),idProcessoErogazione):null;
		Specification<PraticaErogazione> hasSettoreAttivita = (root,cq,cb)->!CollectionUtils.isEmpty(listaIdSettoriAttivita) ? root.get(PraticaErogazione_.settoreAttivita).get(SettoreAttivita_.id).in(listaIdSettoriAttivita):null;
		Specification<PraticaErogazione> hasStatoPratica = (root,cq,cb)->  !CollectionUtils.isEmpty(statiPratica) ? root.get(PraticaErogazione_.lavorazioneContabile).in(statiPratica):null;
		Specification<PraticaErogazione> hasTipoPeriodo = (root,cq,cb)->  tipoPeriodo !=null ? cb.equal(root.get(PraticaErogazione_.tipoPeriodo),tipoPeriodo):null;
		Specification<PraticaErogazione> hasUnbundling = (root,cq,cb)->  unbundling !=null ? cb.equal(root.get(PraticaErogazione_.statoUnbundling).get(StatoUnbundling_.valore),unbundling):null;
	
		
		return Specifications.where(hasAnnoA)
				.and(hasAnnoDa)
				.and(hasAutorizzazioneComitato)
				.and(hasAutorizzazioneContabile)
				.and(hasAutorizzazioneLegale)
				.and(hasCodicePratica)
				.and(hasComponenteTariffaria)
				.and(hasDataComitatoA)
				.and(hasDataComitatoDa)
				.and(hasDataFideiussioneA)
				.and(hasDataFideiussioneDa)
				.and(hasDataInteressiA)
				.and(hasDataInteressiDa)
				.and(hasDataScadenzaA)
				.and(hasDataScadenzaDa)
				.and(hasFideiussione)
				.and(hasImportoA)
				.and(hasImportoDa)
				.and(hasNumeroNota)
				.and(hasPeriodo)
				.and(hasPosizioneFinanziaria)
				.and(hasProcessoErogazione)
				.and(hasSettoreAttivita)
				.and(hasStatoPratica)
				.and(hasTipoPeriodo)
				.and(hasUnbundling);
	}

	
	/**
	 * @return the idProcessoErogazione
	 */
	public BigInteger getIdProcessoErogazione() {
		return idProcessoErogazione;
	}

	/**
	 * @param idProcessoErogazione the idProcessoErogazione to set
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
