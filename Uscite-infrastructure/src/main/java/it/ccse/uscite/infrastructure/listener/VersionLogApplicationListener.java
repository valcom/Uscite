package it.ccse.uscite.infrastructure.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class VersionLogApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(VersionLogApplicationListener.class);

	@Value("${app.name}")
	private String appName;

	@Value("${app.version}")
	private String appVersion;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("***************************************");
		log.info("INIZIALIZZAZIONE APPLICAZIONE " + appName + " COMPLETATA");
		log.info("VERSIONE " + appVersion);
		log.info("***************************************");

	}

}
