/**
 * 
 */
package it.ccse.uscite.infrastructure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author vcompagnone
 *
 */
@Component
@Aspect
@Order(2)
public class LoggingAspect {
	
	@Around(value="execution(public * it.ccse.uscite..*.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp)throws Throwable{
		final Logger logger = LoggerFactory.getLogger(jp.getTarget().getClass().getName());
		if(logger.isDebugEnabled()){
			logger.debug("Inizio metodo {}",jp.getSignature());
			if(logger.isTraceEnabled()){
				StringBuilder input = buildInput(jp.getArgs());
				if(input != null){
					logger.trace("input = {}",input);
				}
			}
		}
		
		Object result = null;
		try{
			result  = jp.proceed();
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			StringBuilder input = buildInput(jp.getArgs());
			if(input != null){
				logger.error("input = {}",input);
			}
			throw e;
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("Fine Metodo {}",jp.getSignature());
			if(logger.isTraceEnabled()&&result!=null){
				logger.trace("output = {}",result.toString());
			}
		}
		return result;
	}

	private static StringBuilder buildInput(Object[] args) {
		StringBuilder sb = null;
		if(args != null && args.length>0){
			sb = new StringBuilder();
			for(Object arg :args){
				sb.append(arg!=null?arg.toString():null);
				sb.append("\n");
			}
		}
		return sb;
	}
}
