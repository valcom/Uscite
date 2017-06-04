/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Valerio
 *
 */
@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper getMapper(){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}
	
}
