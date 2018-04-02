/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author valer
 *
 */
@Component
public abstract class Assembler {
	@Autowired
	private ModelMapper mapper;

	public ModelMapper getMapper() {
		return mapper;
	}

	public static class ContainerPratiche extends Container<Collection<PraticaErogazione>> {
		public ContainerPratiche(Collection<PraticaErogazione> pratiche) {
			super(pratiche);
		}
	}
	// public final static Type listTypeDettaglioPraticaErogazioneDTO = new
	// TypeToken<Collection<DettaglioPraticaErogazioneDTO>>() {
	// }.getType();
	// public final static Type listTypePraticaErogazione = new
	// TypeToken<Collection<PraticaErogazione>>() {
	// }.getType();
}
