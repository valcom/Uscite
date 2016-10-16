/**
 * 
 */
package it.ccse.uscite.infrastructure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO.Esito;
import it.ccse.uscite.exception.ApplicationException;

/**
 * @author vcompagnone
 *
 */
@Aspect
@Order(1)
public class FacadeAspect {

	@Around("execution(public it.ccse.uscite.application.facade.dto.output.Base_OutDTO+ it.ccse.uscite.application.facade.*.*(it.ccse.uscite.application.facade.dto.input.Base_InDTO+)) && args(input)")
	public Object makeOutput(ProceedingJoinPoint invocation,Base_InDTO input) throws Throwable{
	
		Base_OutDTO output = null;
		try {  
			output = (Base_OutDTO) invocation.proceed();
			output.setEsito(Esito.SUCCESS);
		}catch(ApplicationException ae ){
			output = makeOutput(invocation,Esito.APPLICATION_ERROR,ae.getMessage(),ae.getMessageCode());
		}catch (Exception e) {
			output = makeOutput(invocation,Esito.GENERIC_EXCEPTION,e.getMessage(),"error.generic");
		}
		return output;

	}

	private Base_OutDTO makeOutput(ProceedingJoinPoint pj,Esito esito,String message,String errorCode) throws InstantiationException, IllegalAccessException {
		Base_OutDTO output = null; 
		MethodSignature signature = (MethodSignature) pj.getSignature();
		output = (Base_OutDTO) signature.getReturnType().newInstance();
		output.setEsito(esito);
		output.setMessage(message);
		output.setErrorCode(errorCode);
		return output;
	}
}
