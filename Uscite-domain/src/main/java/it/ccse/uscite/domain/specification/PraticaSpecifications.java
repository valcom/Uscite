/**
 * 
 */
package it.ccse.uscite.domain.specification;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
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
 * @author valer
 *
 */
public class PraticaSpecifications {
	
	/**
	 * 
	 * @param listaIdSettoriAttivita
	 * @return
	 */
	public static Specification<PraticaErogazione> hasSettoreAttivita(List<BigInteger> listaIdSettoriAttivita) {
	    return  (root,cq,cb)->!CollectionUtils.isEmpty(listaIdSettoriAttivita) ? root.get(PraticaErogazione_.settoreAttivita).get(SettoreAttivita_.id).in(listaIdSettoriAttivita):null;
	  }
	
	/**
	 * 
	 * @param dataComitatoDa
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataComitatoDa(Date dataComitatoDa) {
	   return  (root,cq,cb)-> dataComitatoDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.ordineDelGiorno).get(OrdineDelGiorno_.dataComitato),dataComitatoDa):null;	
	 }
		
	/**
	 * 
	 * @param dataComitatoA
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataComitatoA(Date dataComitatoA) {
	   return  (root,cq,cb)-> dataComitatoA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.ordineDelGiorno).get(OrdineDelGiorno_.dataComitato),dataComitatoA):null;
	 }
	
	/**
	 * 
	 * @param numeroNota
	 * @return
	 */
	public static Specification<PraticaErogazione> hasNumeroNota(Integer numeroNota) {
		return  (root,cq,cb)-> numeroNota !=null ? cb.equal(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.numeroNota),numeroNota):null;
	}
	
	/**
	 * 
	 * @param dataComitatoDa
	 * @return
	 */
	public static Specification<PraticaErogazione> hasImportoDa(BigDecimal importoDa) {
	     return  (root,cq,cb)-> importoDa!=null ? cb.ge(root.get(PraticaErogazione_.impegno),importoDa):null;
	}
		
	/**
	 * 
	 * @param dataComitatoA
	 * @return
	 */
	public static Specification<PraticaErogazione> hasImportoA(BigDecimal importoA) {
	    return  (root,cq,cb)-> importoA !=null ? cb.le(root.get(PraticaErogazione_.impegno),importoA):null;
	  }
	
	/**
	 * @param idComponenteTariffaria
	 * @return
	 */
	public static Specification<PraticaErogazione> hasComponenteTariffaria(BigInteger idComponenteTariffaria) {
	     return  (root,cq,cb)-> idComponenteTariffaria !=null ? cb.equal(root.get(PraticaErogazione_.idComponenteTariffariaAc),idComponenteTariffaria):null;
	  }
	
	/**
	 * @param idPosizioneFinanziaria
	 * @return
	 */
	public static Specification<PraticaErogazione> hasPosizioneFinanziaria(BigInteger idPosizioneFinanziaria) {
	   return  (root,cq,cb)-> idPosizioneFinanziaria !=null ? cb.equal(root.get(PraticaErogazione_.idPosizioneFinanziariaAc),idPosizioneFinanziaria):null;
	  }
	
	/**
	 * @param listaValoriAutorizzazioneLegale
	 * @return
	 */
	public static Specification<PraticaErogazione> hasAutorizzazioneLegale(List<AutorizzazioneLegale> listaValoriAutorizzazioneLegale) {
	   return  (root,cq,cb)-> !CollectionUtils.isEmpty(listaValoriAutorizzazioneLegale) ? root.get(PraticaErogazione_.statoLegale).get(StatoLegale_.valore).in(listaValoriAutorizzazioneLegale):null;
	  }
	
	/**
	 * @param autorizzazioneComitato
	 * @return
	 */
	public static Specification<PraticaErogazione> hasAutorizzazioneComitato(AutorizzazioneComitato autorizzazioneComitato) {
	  return  (root,cq,cb)-> autorizzazioneComitato !=null ? cb.equal(root.get(PraticaErogazione_.statoComitato).get(StatoComitato_.valore),autorizzazioneComitato):null;
	}
	
	/**
	 * @param autorizzazioneContabile
	 * @return
	 */
	public static Specification<PraticaErogazione> hasAutorizzazioneContabile(AutorizzazioneContabile autorizzazioneContabile) {
	    return  (root,cq,cb)-> autorizzazioneContabile !=null ? cb.equal(root.get(PraticaErogazione_.statoContabile).get(StatoContabile_.valore),autorizzazioneContabile):null;
	  }
	
	/**
	 * @param dataScadenzaDa
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataScadenzaDa(Date dataScadenzaDa) {
	   return  (root,cq,cb)-> dataScadenzaDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataScadenza),dataScadenzaDa):null;
	  }
		

	/**
	 * @param dataScadenzaA
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataScadenzaA(Date dataScadenzaA) {
	  return  (root,cq,cb)-> dataScadenzaA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataScadenza),dataScadenzaA):null;
	}
	
	
	
	/**
	 * @param dataInteressiDa
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataInteressiDa(Date dataInteressiDa) {
	    return  (root,cq,cb)->  dataInteressiDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi),dataInteressiDa):null;
	  }
		
	
	/**
	 * @param dataInteressiA
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataInteressiA(Date dataInteressiA) {
	     return (root,cq,cb)->  dataInteressiA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi),dataInteressiA):null;
	  }
	
	/**
	 * @param statiPratica
	 * @return
	 */
	public static Specification<PraticaErogazione> hasStatoPratica(List<StatoPratica> statiPratica) {
	     return (root,cq,cb)->  !CollectionUtils.isEmpty(statiPratica) ? root.get(PraticaErogazione_.lavorazioneContabile).in(statiPratica):null;
	  }
	
	/**
	 * @param annoDa
	 * @return
	 */
	public static Specification<PraticaErogazione> hasAnnoDa(Integer annoDa) {
	    return (root,cq,cb) ->  annoDa!=null ? cb.ge(root.get(PraticaErogazione_.anno),annoDa):null;
		
	  }
		
	
	/**
	 * @param annoA
	 * @return
	 */
	public static Specification<PraticaErogazione> hasAnnoA(Integer annoA) {
	    return  (root,cq,cb)->  annoA !=null ? cb.le(root.get(PraticaErogazione_.anno),annoA):null;
	  }

	/**
	 * @param tipoPeriodo
	 * @return
	 */
	public static Specification<PraticaErogazione> hasTipoPeriodo(TipoPeriodo tipoPeriodo) {
	    return  (root,cq,cb)->  tipoPeriodo !=null ? cb.equal(root.get(PraticaErogazione_.tipoPeriodo),tipoPeriodo):null;
	  }
	
	/**
	 * @param periodo
	 * @return
	 */
	public static Specification<PraticaErogazione> hasPeriodo(Integer periodo) {
	    return  (root,cq,cb)->  periodo !=null ? cb.equal(root.get(PraticaErogazione_.periodo),periodo):null;
	  }
	
	
	/**
	 * @param fideiussione
	 * @return
	 */
	public static Specification<PraticaErogazione> hasFideiussione(FideiussionePratica fideiussione) {
	    return (root,cq,cb)-> fideiussione !=null ? cb.equal(root.get(PraticaErogazione_.statoFideiussione).get(StatoFideiussione_.valore),fideiussione):null;
	  }
	
	/**
	 * @param unbundling
	 * @return
	 */
	public static Specification<PraticaErogazione> hasUnbundling(UnbundlingPratica unbundling) {
	    return (root,cq,cb)->  unbundling !=null ? cb.equal(root.get(PraticaErogazione_.statoUnbundling).get(StatoUnbundling_.valore),unbundling):null;
	  }
 
	/**
	 * @param idProcessoErogazione
	 * @return
	 */
	public static Specification<PraticaErogazione> hasProcessoErogazione(BigInteger idProcessoErogazione) {
	    return (root,cq,cb)->  idProcessoErogazione !=null ? cb.equal(root.get(PraticaErogazione_.processoErogazione).get(ProcessoErogazione_.id),idProcessoErogazione):null;
	  }
	
	/**
	 * @param codiciPratica
	 * @return
	 */
	public static Specification<PraticaErogazione> hasCodicePratica(List<String> codiciPratica) {
	   return (root,cq,cb)->  !CollectionUtils.isEmpty(codiciPratica) ? root.get(PraticaErogazione_.codicePratica).in(codiciPratica):null;
	  }
	
	/**
	 * @param dataFideiussioneDa
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataFideiussioneDa(Date dataFideiussioneDa) {
	    return (root,cq,cb)->  dataFideiussioneDa!=null ? cb.greaterThanOrEqualTo(root.get(PraticaErogazione_.dataFideiussione),dataFideiussioneDa):null;
	  }
		

	/**
	 * @param dataFideiussioneA
	 * @return
	 */
	public static Specification<PraticaErogazione> hasDataFideiussioneA(Date dataFideiussioneA) {
	   return (root,cq,cb)->  dataFideiussioneA!=null ? cb.lessThanOrEqualTo(root.get(PraticaErogazione_.dataInteressi),dataFideiussioneA):null;
	  }
	
}
