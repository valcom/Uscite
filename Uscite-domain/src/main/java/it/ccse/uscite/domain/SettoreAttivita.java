/**
 * 
 */
package it.ccse.uscite.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;

/**
 * @author vcompagnone
 *
 */
@Embeddable
public class SettoreAttivita extends ValueObject {
	public static final List<Integer> LISTA_COMPONENTI_TARIFFARIE_SOGGETTE_BLOCCO_UNBUNDLING = Arrays.asList(1, 6, 8, 9, 12, 13, 15, 19, 24, 26, 27, 28, 29, 31, 35, 36, 37, 39, 40, 45, 49, 58, 59, 60, 61, 62, 63, 64, 65);
	private BigInteger id;
	@Transient
	private String ragioneSociale;
	@Transient
	private StatoAntimafia statoAntimafia;
	@Transient
	private Unbundling unbundling;
	@Transient
	private String username;

	public static enum StatoAntimafia {
		ATTESA_DOCUMENTAZIONE, ATTESA_45_GIORNI, CERTIFICATO_NON_VALIDO, ATTESA_CERTIFICATO, CERTIFICATO_VALIDO, MUNICIPALIZZATA, PAGAMENTO_SOTTO_CONDIZIONE, SOTTOSOGLIA, ISTRUTTORIA_COMPLESSA, CESSATA_ATTIVITA;
		private Date dataRichiestaCAM;
		private Date dataRicezioneCAM;
		private Date dataScadenzaCAM;

		/**
		 * @return the dataRichiestaCAM
		 */
		public Date getDataRichiestaCAM() {
			return dataRichiestaCAM;
		}

		/**
		 * @param dataRichiestaCAM
		 *            the dataRichiestaCAM to set
		 */
		public void setDataRichiestaCAM(Date dataRichiestaCAM) {
			this.dataRichiestaCAM = dataRichiestaCAM;
		}

		/**
		 * @return the dataRicezioneCAM
		 */
		public Date getDataRicezioneCAM() {
			return dataRicezioneCAM;
		}

		/**
		 * @param dataRicezioneCAM
		 *            the dataRicezioneCAM to set
		 */
		public void setDataRicezioneCAM(Date dataRicezioneCAM) {
			this.dataRicezioneCAM = dataRicezioneCAM;
		}

		/**
		 * @return the dataScadenzaCAM
		 */
		public Date getDataScadenzaCAM() {
			return dataScadenzaCAM;
		}

		/**
		 * @param dataScadenzaCAM
		 *            the dataScadenzaCAM to set
		 */
		public void setDataScadenzaCAM(Date dataScadenzaCAM) {
			this.dataScadenzaCAM = dataScadenzaCAM;
		}

		public AutorizzazioneLegale getAutorizzazioneLegale() {
			AutorizzazioneLegale autorizzazioneLegale = null;
			switch (this) {
				case ATTESA_45_GIORNI:
				case ATTESA_CERTIFICATO:
				case ATTESA_DOCUMENTAZIONE:
					autorizzazioneLegale = AutorizzazioneLegale.NON_AUTORIZZATO;
					break;
				case CERTIFICATO_NON_VALIDO:
					autorizzazioneLegale = AutorizzazioneLegale.DI_UFFICIO;
					break;
				case CERTIFICATO_VALIDO:
					autorizzazioneLegale = AutorizzazioneLegale.AUTORIZZATO;
					break;
				case MUNICIPALIZZATA:
					autorizzazioneLegale = AutorizzazioneLegale.DEROGA_CAM;
					break;
				case PAGAMENTO_SOTTO_CONDIZIONE:
					autorizzazioneLegale = AutorizzazioneLegale.DEROGA_123;
					break;
				case SOTTOSOGLIA:
					autorizzazioneLegale = AutorizzazioneLegale.DEROGA_SOGLIA;
					break;
				case CESSATA_ATTIVITA:
					autorizzazioneLegale = AutorizzazioneLegale.CESSATA_ATTIVITA;
					break;
				case ISTRUTTORIA_COMPLESSA:
					autorizzazioneLegale = AutorizzazioneLegale.ISTRUTTORIA_COMPLESSA;
					break;
			}
			return autorizzazioneLegale;
		}
	}

	public static enum Unbundling {
		BLOCCATA, SBLOCCATA;
		public UnbundlingPratica getUnbundlingPratica(BigInteger idComponenteTariffaria) {
			UnbundlingPratica unbundlingPratica = null;
			if (LISTA_COMPONENTI_TARIFFARIE_SOGGETTE_BLOCCO_UNBUNDLING.contains(idComponenteTariffaria.intValue())) {
				switch (this) {
					case BLOCCATA:
						unbundlingPratica = UnbundlingPratica.NON_AUTORIZZATO;
						break;
					case SBLOCCATA:
						unbundlingPratica = UnbundlingPratica.AUTORIZZATO;
						break;
					default:
						break;
				}
			} else {
				unbundlingPratica = UnbundlingPratica.DONT_CARE;
			}
			return unbundlingPratica;
		}
	}

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the statoAntimafia
	 */
	public StatoAntimafia getStatoAntimafia() {
		return statoAntimafia;
	}

	/**
	 * @param statoAntimafia
	 *            the statoAntimafia to set
	 */
	public void setStatoAntimafia(StatoAntimafia statoAntimafia) {
		this.statoAntimafia = statoAntimafia;
	}

	/**
	 * @return the unbundling
	 */
	public Unbundling getUnbundling() {
		return unbundling;
	}

	/**
	 * @param unbundling
	 *            the unbundling to set
	 */
	public void setUnbundling(Unbundling unbundling) {
		this.unbundling = unbundling;
	}

	/**
	 * @return the ragioneSociale
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * @param ragioneSociale
	 *            the ragioneSociale to set
	 */
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean aggiornaSemaforiAnagrafe(PraticaErogazione pratica, Collection<StatoLegale> statiLegale, Collection<StatoUnbundling> statiUnbundling) {
		AutorizzazioneLegale autorizzazioneLegaleAttuale = pratica.getAutorizzazioneLegale();
		UnbundlingPratica unbundlingPraticaAttuale = pratica.getUnbundling();
		StatoLegale nuovoStatoLegale = statiLegale.stream().filter(sl -> sl.getAutorizzazioneLegale().equals(getStatoAntimafia().getAutorizzazioneLegale())).findFirst().get();
		StatoUnbundling nuovoStatoUnbundling = statiUnbundling.stream().filter(sb -> sb.getUnbundling().equals(getUnbundling().getUnbundlingPratica(pratica.getIdComponenteTariffariaAc()))).findFirst().get();
		AutorizzazioneLegale nuovaAntimafia = nuovoStatoLegale.getAutorizzazioneLegale();
		UnbundlingPratica nuovoUnbundling = nuovoStatoUnbundling.getUnbundling();
		pratica.setStatoLegale(nuovoStatoLegale);
		pratica.setStatoUnbundling(nuovoStatoUnbundling);
		return (autorizzazioneLegaleAttuale != nuovaAntimafia || unbundlingPraticaAttuale != nuovoUnbundling);
	}
}
