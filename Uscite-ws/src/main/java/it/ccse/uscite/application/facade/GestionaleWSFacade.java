/**
 * 
 */
package it.ccse.uscite.application.facade;

import javax.jws.WebService;

import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetStatiLegali_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetTipiPeriodo_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AutorizzaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.DissociaPraticheDaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RifiutaAutorizzazioneComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;

/**
 * @author vcompagnone
 *
 */
@WebService(targetNamespace="it.ccse.uscite")
public interface GestionaleWSFacade {
		
	/**
	 * @param comitato_InDTO
	 * @return
	 */
	public AggiungiComitato_OutDTO aggiungiComitato(AggiungiComitato_InDTO comitato_InDTO);
	
	/**
	 * @param updateComitato_InDTO
	 * @return
	 */
	public AggiornaComitato_OutDTO aggiornaComitato(AggiornaComitato_InDTO updateComitato_InDTO);
	
	/**
	 * @param apriComitato_InDTO
	 * @return
	 */
	public ApriComitato_OutDTO apriComitato(ApriComitato_InDTO apriComitato_InDTO);
	
	/**
	 * @param chiudiComitato_InDTO
	 * @return
	 */
	public ChiudiComitato_OutDTO chiudiComitato(ChiudiComitato_InDTO chiudiComitato_InDTO);
	
	/**
	 * @param deleteComitato_InDTO
	 * @return
	 */
	public EliminaComitato_OutDTO deleteComitato(EliminaComitato_InDTO deleteComitato_InDTO);
	
	/**
	 * @param aggiungiNotaDTO_InDTO
	 * @return
	 */
	public AggiungiNota_OutDTO aggiungiNota(AggiungiNota_InDTO aggiungiNotaDTO_InDTO);
	
	/**
	 * @param eliminaNota_InDTO
	 * @return
	 */
	public EliminaNota_OutDTO eliminaNota(EliminaNota_InDTO eliminaNota_InDTO);
	
	/**
	 * @param aggiornaNota_InDTO
	 * @return
	 */
	public AggiornaNota_OutDTO aggiornaNota(AggiornaNota_InDTO aggiornaNota_InDTO);
	
	/**
	 * @param apriNotaInDTO
	 * @return
	 */
	public ApriNota_OutDTO apriNota(ApriNota_InDTO apriNotaInDTO);
	
	/**
	 * @param chiudiNotaInDTO
	 * @return
	 */
	public ChiudiNota_OutDTO chiudiNota(ChiudiNota_InDTO chiudiNotaInDTO);
	
	/**
	 * @param rinviaNota_InDTO
	 * @return
	 */
	public RinviaNota_OutDTO rinviaNota(RinviaNota_InDTO rinviaNota_InDTO);
							
	/**
	 * @param autorizzaComitatoIn_DTO
	 * @return
	 */
	public AutorizzaComitato_OutDTO autorizzaComitato(AutorizzaComitato_InDTO autorizzaComitatoIn_DTO);
	
	/**
	 * @param rifiutaAutorizzazioneComitatoIn_DTO
	 * @return
	 */
	public RifiutaAutorizzazioneComitato_OutDTO rifiutaAutorizzazioneComitato(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitatoIn_DTO);

	/**
	 * @param lavorazioneContabileNota_InDTO
	 * @return
	 */
	public LavorazioneContabile_OutDTO lavorazioneContabileNota(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO);

	/**
	 * @param lavorazioneContabilePratica_InDTO
	 * @return
	 */
	public LavorazioneContabile_OutDTO lavorazioneContabilePratiche(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO);
	
	/**
	 * @param searchNote_InDTO
	 * @return
	 */
	public SearchNote_OutDTO searchNote(SearchNote_InDTO searchNote_InDTO);
	
	/**
	 * @param searchComitati_InDTO
	 * @return
	 */
	public SearchComitati_OutDTO searchComitati(SearchComitati_InDTO searchComitati_InDTO);

	/**
	 * @param getTipiPeriodo_InDTO
	 * @return
	 */
	public GetTipiPeriodo_OutDTO getTipiPeriodo(GetTipiPeriodo_InDTO getTipiPeriodo_InDTO);
	
	/**
	 * @param associaPraticheANota_InDTO
	 * @return
	 */
	public AssociaPraticheANota_OutDTO associaPraticheANota(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);
	
	/**
	 * @param dissociaPraticheDaNota_InDTO
	 * @return
	 */
	public DissociaPraticheDaNota_OutDTO dissociaPraticheDaNota(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);

	/**
	 * @param getStatiLegali_InDTO
	 * @return
	 */
	public GetStatiLegali_OutDTO getStatiLegali(GetStatiLegali_InDTO getStatiLegali_InDTO);

}
