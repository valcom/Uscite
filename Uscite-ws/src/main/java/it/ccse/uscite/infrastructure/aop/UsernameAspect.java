/**
 * 
 */
package it.ccse.uscite.infrastructure.aop;

import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;
import it.ccse.uscite.domain.DomainEntity;

/**
 * @author valer
 *
 */
@Aspect
@Order(1)
public class UsernameAspect {
	
	@AfterReturning(pointcut="execution(public java.util.Collection+ it.ccse.uscite.application.facade.assembler..*.*(it.ccse.uscite.application.facade.dto.input.Base_InDTO+))",returning="output")
	public void setUsername(JoinPoint invocation,Collection<?> output) throws Throwable{
		Base_InDTO input = (Base_InDTO) invocation.getArgs()[0];
		String username = input.getUsername();
		output.stream().forEach(e->((DomainEntity<?>)e).setUsername(username));
		
	}
	

}
