/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.uscite;

import it.ccse.uscite.application.facade.dto.TipoPeriodoDTO;
import it.ccse.uscite.application.facade.dto.input.PageableDTO;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class SearchPratiche_InDTO extends PageableDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BigInteger> listaIdSettoriAttivita;
	
	private Date dataComitatoDa;
	
	private Date dataComitatoA;
	
	private Integer numeroNota;
	
	private BigDecimal importoDa;
	
	private BigDecimal importoA;
		
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
	
	private TipoPeriodoDTO tipoPeriodo;
	
	private Integer periodo;
	
	private FideiussionePratica fideiussione;
	
	private UnbundlingPratica unbundling;
	
	private BigInteger idComponenteTariffaria;
	
	private BigInteger idNota;
	
	private Boolean erogabile;
	
	private List<String> codiciPratica;
	
	private Date dataFideiussioneDa;
	
	private Date dataFideiussioneA;

	
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
	 * @return the autorizzazioneComitato
	 */
	public AutorizzazioneComitato getAutorizzazioneComitato() {
		return autorizzazioneComitato;
	}

	/**
	 * @param autorizzazioneComitato the autorizzazioneComitato to set
	 */
	public void setAutorizzazioneComitato(
			AutorizzazioneComitato autorizzazioneComitato) {
		this.autorizzazioneComitato = autorizzazioneComitato;
	}

	/**
	 * @return the autorizzazioneContabile
	 */
	public AutorizzazioneContabile getAutorizzazioneContabile() {
		return autorizzazioneContabile;
	}

	/**
	 * @param autorizzazioneContabile the autorizzazioneContabile to set
	 */
	public void setAutorizzazioneContabile(
			AutorizzazioneContabile autorizzazioneContabile) {
		this.autorizzazioneContabile = autorizzazioneContabile;
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
	public TipoPeriodoDTO getTipoPeriodo() {
		return tipoPeriodo;
	}

	/**
	 * @param tipoPeriodo the tipoPeriodo to set
	 */
	public void setTipoPeriodo(TipoPeriodoDTO tipoPeriodo) {
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
	 * @return the fideiussione
	 */
	public FideiussionePratica getFideiussione() {
		return fideiussione;
	}

	/**
	 * @param fideiussione the fideiussione to set
	 */
	public void setFideiussione(FideiussionePratica fideiussione) {
		this.fideiussione = fideiussione;
	}

	/**
	 * @return the unbundling
	 */
	public UnbundlingPratica getUnbundling() {
		return unbundling;
	}

	/**
	 * @param unbundling the unbundling to set
	 */
	public void setUnbundling(UnbundlingPratica unbundling) {
		this.unbundling = unbundling;
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

	public BigInteger getIdProcessoErogazione(){
		return idNota;
	}

	

	/**
	 * @return the listaIdSettoriAttivita
	 */
	public List<BigInteger> getListaIdSettoriAttivita() {
		return listaIdSettoriAttivita;
	}

	/**
	 * @param listaIdSettoriAttivita the listaIdSettoriAttivita to set
	 */
	public void setListaIdSettoriAttivita(List<BigInteger> listaIdSettoriAttivita) {
		this.listaIdSettoriAttivita = listaIdSettoriAttivita;
	}

	/**
	 * @return the listaValoriAutorizzazioneLegale
	 */
	public List<AutorizzazioneLegale> getListaValoriAutorizzazioneLegale() {
		return listaValoriAutorizzazioneLegale;
	}

	/**
	 * @param listaValoriAutorizzazioneLegale the listaValoriAutorizzazioneLegale to set
	 */
	public void setListaValoriAutorizzazioneLegale(
			List<AutorizzazioneLegale> listaValoriAutorizzazioneLegale) {
		this.listaValoriAutorizzazioneLegale = listaValoriAutorizzazioneLegale;
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
	
	

}
