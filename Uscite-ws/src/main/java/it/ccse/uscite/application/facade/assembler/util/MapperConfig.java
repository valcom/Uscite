/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.NotaPagamentoDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.application.facade.dto.input.PageableDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.PageDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
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
		mapperFactory.classMap(Container.class,ContainerDTO.class).byDefault().register();
		mapperFactory.classMap(PageableDTO.class,Pageable.class).byDefault().register();
		mapperFactory.classMap(Page.class,PageDTO.class).byDefault().register();
		mapperFactory.classMap(PraticaErogazione.class,PraticaErogazioneDTO.class).byDefault().register();
		mapperFactory.classMap(ProcessoErogazione.class,NotaPagamentoDTO.class).byDefault().register();
		mapperFactory.classMap(OrdineDelGiorno.class,ComitatoDTO.class).byDefault().register();
		mapperFactory.classMap(SearchPratiche_InDTO.class, PraticaFilter.class).byDefault().register();
		mapperFactory.classMap(SettoreAttivitaDTO.class, SettoreAttivita.class).byDefault().register();

			
		return mapperFactory.getMapperFacade();
	}
	
}
