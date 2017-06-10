/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * @author Valerio
 *
 */
@Configuration
public class MapperConfig {

	
	@Bean
	public MapperFacade getMapperFacade(){
		MapperFactory mapperFactory =  new DefaultMapperFactory.Builder().build();
		return mapperFactory.getMapperFacade();
	}
	
}
