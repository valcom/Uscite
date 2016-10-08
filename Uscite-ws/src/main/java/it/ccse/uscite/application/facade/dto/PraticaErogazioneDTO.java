/**
 * 
 */
package it.ccse.uscite.application.facade.dto;


import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author vcompagnone
 *
 */
public class PraticaErogazioneDTO extends DomainDTO{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private BigInteger idPraticaErogazione;

	private Integer anno;

	private String autorizzazioneAutorizzante;

	private AutorizzazioneComitato autorizzazioneComitato;

	private AutorizzazioneContabile autorizzazioneContabile;

	private AutorizzazioneLegale autorizzazioneLegale;
	
	private FideiussionePratica fideiussione;
	
	private UnbundlingPratica unbundling;
	
	private Boolean bloccoComitato;
	
	private Boolean bloccoContabile;
	
	private Boolean bloccoLegale;
	
	private Boolean bloccoFideiussione;
	
	private Boolean bloccoUnbundling;

	private String bimestre;

	private String codicePratica;

	private Date dataAutorizzazioneComitato;

	private Date dataContabilizzazione;

	private Date dataErogazione;

	private Date dataInteressi;

	private Date dataLavorazione;

	private Date dataScadenza;
		
	private Date dataCompetenzaEconomica;	
	
	private String descrizione;

	private BigInteger idArticoloAc;

	private String idAutorizzante;

	private BigInteger idCapitoloAc;

	private String idCentroCosto;

	private String idCentroResponsabilita;

	private BigInteger idComponenteTariffariaAc;

	private BigInteger idContoCorrenteAc;

	private BigInteger idContoGestioneAc;

	private String idLavorante;

	private BigInteger idPosizioneFinanziariaAc;

	private Integer idPraticaErogazioneDifferenza;

	private Integer idPraticaErogazioneOriginale;

	private Integer idPraticaErogazioneRettifica;

	private String idProponente;

	private Integer idSettoreAttivita;

	private Integer idSoggetto;

	private BigDecimal impegno;

	private StatoPratica lavorazioneContabile;

	private BigDecimal mandato;

	private Integer numeroRettifica;

	private Integer periodo;

	private String statoPraticaGestionale;

	private String statoRiepilogativo;

	private String tipologia;

	private String vistoConformita;
	
	private String owner;
	
	private TipoPeriodoDTO tipoPeriodo;
	
	private Date dataAutorizzazioneContabile;
	
	private Date dataAutorizzazioneLegale;
	
	private Date dataUnbundling;
	
	private Date dataFideiussione;
	
	private Date dataErogabilita;
	
	private Boolean erogabile;
	
	private String codicePosizioneFinanziaria;
	
	/**
	 * @return the idPraticaErogazione
	 */
	public BigInteger getId() {
		return idPraticaErogazione;
	}

	/**
	 * @param idPraticaErogazione the idPraticaErogazione to set
	 */
	public void setId(BigInteger id) {
		this.idPraticaErogazione = id;
	}

	/**
	 * @return the anno
	 */
	public Integer getAnno() {
		return anno;
	}

	/**
	 * @param anno the anno to set
	 */
	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	/**
	 * @return the autorizzazioneAutorizzante
	 */
	public String getAutorizzazioneAutorizzante() {
		return autorizzazioneAutorizzante;
	}

	/**
	 * @param autorizzazioneAutorizzante the autorizzazioneAutorizzante to set
	 */
	public void setAutorizzazioneAutorizzante(String autorizzazioneAutorizzante) {
		this.autorizzazioneAutorizzante = autorizzazioneAutorizzante;
	}

	
	/**
	 * @return the bimestre
	 */
	public String getBimestre() {
		return bimestre;
	}

	/**
	 * @param bimestre the bimestre to set
	 */
	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	/**
	 * @return the codicePratica
	 */
	public String getCodicePratica() {
		return codicePratica;
	}

	/**
	 * @param codicePratica the codicePratica to set
	 */
	public void setCodicePratica(String codicePratica) {
		this.codicePratica = codicePratica;
	}

	/**
	 * @return the dataAutorizzazioneComitato
	 */
	public Date getDataAutorizzazioneComitato() {
		return dataAutorizzazioneComitato;
	}

	/**
	 * @param dataAutorizzazioneComitato the dataAutorizzazioneComitato to set
	 */
	public void setDataAutorizzazioneComitato(Date dataAutorizzazioneComitato) {
		this.dataAutorizzazioneComitato = dataAutorizzazioneComitato;
	}

	/**
	 * @return the dataContabilizzazione
	 */
	public Date getDataContabilizzazione() {
		return dataContabilizzazione;
	}

	/**
	 * @param dataContabilizzazione the dataContabilizzazione to set
	 */
	public void setDataContabilizzazione(Date dataContabilizzazione) {
		this.dataContabilizzazione = dataContabilizzazione;
	}

	/**
	 * @return the dataErogazione
	 */
	public Date getDataErogazione() {
		return dataErogazione;
	}

	/**
	 * @param dataErogazione the dataErogazione to set
	 */
	public void setDataErogazione(Date dataErogazione) {
		this.dataErogazione = dataErogazione;
	}

	/**
	 * @return the dataInteressi
	 */
	public Date getDataInteressi() {
		return dataInteressi;
	}

	/**
	 * @param dataInteressi the dataInteressi to set
	 */
	public void setDataInteressi(Date dataInteressi) {
		this.dataInteressi = dataInteressi;
	}

	/**
	 * @return the dataLavorazione
	 */
	public Date getDataLavorazione() {
		return dataLavorazione;
	}

	/**
	 * @param dataLavorazione the dataLavorazione to set
	 */
	public void setDataLavorazione(Date dataLavorazione) {
		this.dataLavorazione = dataLavorazione;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the idArticoloAc
	 */
	public BigInteger getIdArticoloAc() {
		return idArticoloAc;
	}

	/**
	 * @param idArticoloAc the idArticoloAc to set
	 */
	public void setIdArticoloAc(BigInteger idArticoloAc) {
		this.idArticoloAc = idArticoloAc;
	}

	/**
	 * @return the idAutorizzante
	 */
	public String getIdAutorizzante() {
		return idAutorizzante;
	}

	/**
	 * @param idAutorizzante the idAutorizzante to set
	 */
	public void setIdAutorizzante(String idAutorizzante) {
		this.idAutorizzante = idAutorizzante;
	}

	/**
	 * @return the idCapitoloAc
	 */
	public BigInteger getIdCapitoloAc() {
		return idCapitoloAc;
	}

	/**
	 * @param idCapitoloAc the idCapitoloAc to set
	 */
	public void setIdCapitoloAc(BigInteger idCapitoloAc) {
		this.idCapitoloAc = idCapitoloAc;
	}

	/**
	 * @return the idCentroCosto
	 */
	public String getIdCentroCosto() {
		return idCentroCosto;
	}

	/**
	 * @param idCentroCosto the idCentroCosto to set
	 */
	public void setIdCentroCosto(String idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}

	/**
	 * @return the idCentroResponsabilita
	 */
	public String getIdCentroResponsabilita() {
		return idCentroResponsabilita;
	}

	/**
	 * @param idCentroResponsabilita the idCentroResponsabilita to set
	 */
	public void setIdCentroResponsabilita(String idCentroResponsabilita) {
		this.idCentroResponsabilita = idCentroResponsabilita;
	}

	/**
	 * @return the idComponenteTariffariaAc
	 */
	public BigInteger getIdComponenteTariffariaAc() {
		return idComponenteTariffariaAc;
	}

	/**
	 * @param idComponenteTariffariaAc the idComponenteTariffariaAc to set
	 */
	public void setIdComponenteTariffariaAc(BigInteger idComponenteTariffariaAc) {
		this.idComponenteTariffariaAc = idComponenteTariffariaAc;
	}

	/**
	 * @return the idContoCorrenteAc
	 */
	public BigInteger getIdContoCorrenteAc() {
		return idContoCorrenteAc;
	}

	/**
	 * @param idContoCorrenteAc the idContoCorrenteAc to set
	 */
	public void setIdContoCorrenteAc(BigInteger idContoCorrenteAc) {
		this.idContoCorrenteAc = idContoCorrenteAc;
	}

	/**
	 * @return the idContoGestioneAc
	 */
	public BigInteger getIdContoGestioneAc() {
		return idContoGestioneAc;
	}

	/**
	 * @param idContoGestioneAc the idContoGestioneAc to set
	 */
	public void setIdContoGestioneAc(BigInteger idContoGestioneAc) {
		this.idContoGestioneAc = idContoGestioneAc;
	}

	/**
	 * @return the idLavorante
	 */
	public String getIdLavorante() {
		return idLavorante;
	}

	/**
	 * @param idLavorante the idLavorante to set
	 */
	public void setIdLavorante(String idLavorante) {
		this.idLavorante = idLavorante;
	}

	/**
	 * @return the idPosizioneFinanziariaAc
	 */
	public BigInteger getIdPosizioneFinanziariaAc() {
		return idPosizioneFinanziariaAc;
	}

	/**
	 * @param idPosizioneFinanziariaAc the idPosizioneFinanziariaAc to set
	 */
	public void setIdPosizioneFinanziariaAc(BigInteger idPosizioneFinanziariaAc) {
		this.idPosizioneFinanziariaAc = idPosizioneFinanziariaAc;
	}

	/**
	 * @return the idPraticaErogazioneDifferenza
	 */
	public Integer getIdPraticaErogazioneDifferenza() {
		return idPraticaErogazioneDifferenza;
	}

	/**
	 * @param idPraticaErogazioneDifferenza the idPraticaErogazioneDifferenza to set
	 */
	public void setIdPraticaErogazioneDifferenza(
			Integer idPraticaErogazioneDifferenza) {
		this.idPraticaErogazioneDifferenza = idPraticaErogazioneDifferenza;
	}

	/**
	 * @return the idPraticaErogazioneOriginale
	 */
	public Integer getIdPraticaErogazioneOriginale() {
		return idPraticaErogazioneOriginale;
	}

	/**
	 * @param idPraticaErogazioneOriginale the idPraticaErogazioneOriginale to set
	 */
	public void setIdPraticaErogazioneOriginale(Integer idPraticaErogazioneOriginale) {
		this.idPraticaErogazioneOriginale = idPraticaErogazioneOriginale;
	}

	/**
	 * @return the idPraticaErogazioneRettifica
	 */
	public Integer getIdPraticaErogazioneRettifica() {
		return idPraticaErogazioneRettifica;
	}

	/**
	 * @param idPraticaErogazioneRettifica the idPraticaErogazioneRettifica to set
	 */
	public void setIdPraticaErogazioneRettifica(Integer idPraticaErogazioneRettifica) {
		this.idPraticaErogazioneRettifica = idPraticaErogazioneRettifica;
	}

	/**
	 * @return the idProponente
	 */
	public String getIdProponente() {
		return idProponente;
	}

	/**
	 * @param idProponente the idProponente to set
	 */
	public void setIdProponente(String idProponente) {
		this.idProponente = idProponente;
	}

	/**
	 * @return the idSettoreAttivita
	 */
	public Integer getIdSettoreAttivita() {
		return idSettoreAttivita;
	}

	/**
	 * @param idSettoreAttivita the idSettoreAttivita to set
	 */
	public void setIdSettoreAttivita(Integer idSettoreAttivita) {
		this.idSettoreAttivita = idSettoreAttivita;
	}

	/**
	 * @return the idSoggetto
	 */
	public Integer getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * @param idSoggetto the idSoggetto to set
	 */
	public void setIdSoggetto(Integer idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	/**
	 * @return the impegno
	 */
	public BigDecimal getImpegno() {
		return impegno;
	}

	/**
	 * @param impegno the impegno to set
	 */
	public void setImpegno(BigDecimal impegno) {
		this.impegno = impegno;
	}

	/**
	 * @return the lavorazioneContabile
	 */
	public StatoPratica getLavorazioneContabile() {
		return lavorazioneContabile;
	}

	/**
	 * @param lavorazioneContabile the lavorazioneContabile to set
	 */
	public void setLavorazioneContabile(StatoPratica lavorazioneContabile) {
		this.lavorazioneContabile = lavorazioneContabile;
	}

	/**
	 * @return the mandato
	 */
	public BigDecimal getMandato() {
		return mandato;
	}

	/**
	 * @param mandato the mandato to set
	 */
	public void setMandato(BigDecimal mandato) {
		this.mandato = mandato;
	}

	/**
	 * @return the numeroRettifica
	 */
	public Integer getNumeroRettifica() {
		return numeroRettifica;
	}

	/**
	 * @param numeroRettifica the numeroRettifica to set
	 */
	public void setNumeroRettifica(Integer numeroRettifica) {
		this.numeroRettifica = numeroRettifica;
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
	 * @return the statoPraticaGestionale
	 */
	public String getStatoPraticaGestionale() {
		return statoPraticaGestionale;
	}

	/**
	 * @param statoPraticaGestionale the statoPraticaGestionale to set
	 */
	public void setStatoPraticaGestionale(String statoPraticaGestionale) {
		this.statoPraticaGestionale = statoPraticaGestionale;
	}

	/**
	 * @return the statoRiepilogativo
	 */
	public String getStatoRiepilogativo() {
		return statoRiepilogativo;
	}

	/**
	 * @param statoRiepilogativo the statoRiepilogativo to set
	 */
	public void setStatoRiepilogativo(String statoRiepilogativo) {
		this.statoRiepilogativo = statoRiepilogativo;
	}

	/**
	 * @return the tipologia
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * @param tipologia the tipologia to set
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * @return the vistoConformita
	 */
	public String getVistoConformita() {
		return vistoConformita;
	}

	/**
	 * @param vistoConformita the vistoConformita to set
	 */
	public void setVistoConformita(String vistoConformita) {
		this.vistoConformita = vistoConformita;
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
	 * @return the autorizzazioneLegale
	 */
	public AutorizzazioneLegale getAutorizzazioneLegale() {
		return autorizzazioneLegale;
	}

	/**
	 * @param autorizzazioneLegale the autorizzazioneLegale to set
	 */
	public void setAutorizzazioneLegale(AutorizzazioneLegale autorizzazioneLegale) {
		this.autorizzazioneLegale = autorizzazioneLegale;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public TipoPeriodoDTO getTipoPeriodo() {
		return tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodoDTO tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public Date getDataAutorizzazioneContabile() {
		return dataAutorizzazioneContabile;
	}

	public void setDataAutorizzazioneContabile(Date dataAutorizzazioneContabile) {
		this.dataAutorizzazioneContabile = dataAutorizzazioneContabile;
	}

	public Date getDataAutorizzazioneLegale() {
		return dataAutorizzazioneLegale;
	}

	public void setDataAutorizzazioneLegale(Date dataAutorizzazioneLegale) {
		this.dataAutorizzazioneLegale = dataAutorizzazioneLegale;
	}

	public Date getDataFideiussione() {
		return dataFideiussione;
	}

	public void setDataFideiussione(Date dataFideiussione) {
		this.dataFideiussione = dataFideiussione;
	}

	public Boolean getErogabile() {
		return erogabile;
	}

	public void setErogabile(Boolean erogabile) {
		this.erogabile = erogabile;
	}

	public Date getDataUnbundling() {
		return dataUnbundling;
	}

	public void setDataUnbundling(Date dataUnbundling) {
		this.dataUnbundling = dataUnbundling;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Date getDataCompetenzaEconomica() {
		return dataCompetenzaEconomica;
	}

	public void setDataCompetenzaEconomica(Date dataCompetenzaEconomica) {
		this.dataCompetenzaEconomica = dataCompetenzaEconomica;
	}

	public Date getDataErogabilita() {
		return dataErogabilita;
	}

	public void setDataErogabilita(Date dataErogabilita) {
		this.dataErogabilita = dataErogabilita;
	}

	public String getCodicePosizioneFinanziaria() {
		return codicePosizioneFinanziaria;
	}

	public void setCodicePosizioneFinanziaria(String codicePosizioneFinanziaria) {
		this.codicePosizioneFinanziaria = codicePosizioneFinanziaria;
	}

	/**
	 * @return the bloccoComitato
	 */
	public Boolean getBloccoComitato() {
		return bloccoComitato;
	}

	/**
	 * @param bloccoComitato the bloccoComitato to set
	 */
	public void setBloccoComitato(Boolean bloccoComitato) {
		this.bloccoComitato = bloccoComitato;
	}

	/**
	 * @return the bloccoContabile
	 */
	public Boolean getBloccoContabile() {
		return bloccoContabile;
	}

	/**
	 * @param bloccoContabile the bloccoContabile to set
	 */
	public void setBloccoContabile(Boolean bloccoContabile) {
		this.bloccoContabile = bloccoContabile;
	}

	/**
	 * @return the bloccoLegale
	 */
	public Boolean getBloccoLegale() {
		return bloccoLegale;
	}

	/**
	 * @param bloccoLegale the bloccoLegale to set
	 */
	public void setBloccoLegale(Boolean bloccoLegale) {
		this.bloccoLegale = bloccoLegale;
	}

	/**
	 * @return the bloccoFideiussione
	 */
	public Boolean getBloccoFideiussione() {
		return bloccoFideiussione;
	}

	/**
	 * @param bloccoFideiussione the bloccoFideiussione to set
	 */
	public void setBloccoFideiussione(Boolean bloccoFideiussione) {
		this.bloccoFideiussione = bloccoFideiussione;
	}

	/**
	 * @return the bloccoUnbundling
	 */
	public Boolean getBloccoUnbundling() {
		return bloccoUnbundling;
	}

	/**
	 * @param bloccoUnbundling the bloccoUnbundling to set
	 */
	public void setBloccoUnbundling(Boolean bloccoUnbundling) {
		this.bloccoUnbundling = bloccoUnbundling;
	}

	
}
