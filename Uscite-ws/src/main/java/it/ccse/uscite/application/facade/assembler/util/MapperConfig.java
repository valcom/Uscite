/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * @author Valerio
 *
 */
@Configuration
public class MapperConfig {

	
	@Bean
	public MapperFacade getMapperFacade(){
		return new ConfigurableMapper(){
			@Override
			protected void configure(MapperFactory factory) {
				super.configure(factory);
			}};
	}
	
}
