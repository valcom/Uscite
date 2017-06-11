/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFacade;

/**
 * @author valer
 *
 */
@Component
public abstract class Assembler {
	@Autowired
	private MapperFacade mapper;

	public MapperFacade getMapper() {
		return mapper;
	}
	
	
	
	
}
