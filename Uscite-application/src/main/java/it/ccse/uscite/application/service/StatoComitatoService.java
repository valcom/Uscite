/**
 * 
 */
package it.ccse.uscite.application.service;

import it.ccse.uscite.domain.StatoComitato;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;

/**
 * @author vcompagnone
 *
 */
public interface StatoComitatoService {
	public StatoComitato getStatoComitatoIniziale();
	
	public StatoComitato findByAutorizzazioneComitato(AutorizzazioneComitato aut);
	
	public StatoComitato getStatoAutorizzazioneComitato();
	
	public StatoComitato getStatoRinvioComitato();
	
	public StatoComitato getStatoRifiutoComitato();

}
