/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;
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
	public ModelMapper getMapper(){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
	}
	
	@Bean
	public MapperFacade getMapperFacade(){
		MapperFactory mapperFactory =  new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(PraticaErogazione.class,SearchPratiche_OutDTO.class).byDefault().register();
		mapperFactory.classMap(SearchPratiche_InDTO.class, PraticaFilter.class).byDefault().register();

			
		return mapperFactory.getMapperFacade();
	}
	
}
