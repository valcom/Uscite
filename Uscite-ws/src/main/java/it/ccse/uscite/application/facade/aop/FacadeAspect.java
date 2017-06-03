/**
 * 
 */
package it.ccse.uscite.application.facade.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO.Esito;
import it.ccse.uscite.domain.exception.ApplicationException;

/**
 * @author vcompagnone
 *
 */
@Component
@Aspect
@Order(1)
public class FacadeAspect {

	@Around("execution(public it.ccse.uscite.application.facade.dto.output.Base_OutDTO+ it.ccse.uscite.application.facade.*..*(it.ccse.uscite.application.facade.dto.input.Base_InDTO+)) && args(input)")
	public Object makeOutput(ProceedingJoinPoint invocation,Base_InDTO input) throws Throwable{
		RequestContextHolder.currentRequestAttributes().setAttribute("username",input.getUsername(),RequestAttributes.SCOPE_REQUEST);
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
