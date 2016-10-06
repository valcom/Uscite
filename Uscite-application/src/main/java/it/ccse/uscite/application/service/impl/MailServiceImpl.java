/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.ccse.uscite.application.service.MailService;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author vcompagnone
 *
 */
@Service
@Transactional(propagation=Propagation.NOT_SUPPORTED)
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage msgAutorizzazioneComitato;
	
	@Autowired
	private SimpleMailMessage msgSbloccoPratiche;

	


	@Override
	public void sendMailAutorizzazioneComitato(List<PraticaErogazione> pratiche) {
		SimpleMailMessage newMailMessage = creaMail(pratiche,msgAutorizzazioneComitato);
		mailSender.send(newMailMessage);
	}

	@Override
	public void sendMailSbloccoAnagraficaPratiche(List<PraticaErogazione> pratiche) {
		SimpleMailMessage newMailMessage = creaMail(pratiche,msgSbloccoPratiche);		
		mailSender.send(newMailMessage);
	}


	
	private static SimpleMailMessage creaMail(List<PraticaErogazione> pratiche,SimpleMailMessage template) {
		SimpleMailMessage newMailMessage = new SimpleMailMessage(template);
		String testoMail = "";
		
		for(PraticaErogazione pratica:pratiche){
			testoMail += getTestoMail(template.getText(),pratica);	
		}		
		
		newMailMessage.setText(testoMail);
		return newMailMessage;
	}

	private static String getTestoMail(String template , PraticaErogazione pratica){
		
		return String.format(template, pratica.getCodicePratica(),
				pratica.getSettoreAttivita().getRagioneSociale() != null ? pratica.getSettoreAttivita().getRagioneSociale():"",
				pratica.getImpegno(),
				pratica.getNota().getNumeroNota(),
				DateFormat.getDateInstance(DateFormat.SHORT).format(pratica.getNota().getOrdineDelGiorno().getDataComitato()));
		
	}
	
}
