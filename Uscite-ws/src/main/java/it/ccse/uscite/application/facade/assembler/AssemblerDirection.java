/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Sort.Direction;

/**
 * @author Valerio
 *
 */
@Mapper
public interface AssemblerDirection {
	public Direction map(it.ccse.uscite.application.facade.dto.input.PageableDTO.Direction direction);
}
