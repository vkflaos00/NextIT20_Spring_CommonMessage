package kr.or.nextit.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlAspect {

	private final Logger logger
		= LoggerFactory.getLogger(this.getClass());
	
	public void beforeLog(JoinPoint joinPoint) {
		String targetClass  = joinPoint.getTarget().getClass().getSimpleName();
		String targetMethod = joinPoint.getSignature().getName();
		
		logger.info( "["+targetClass+"_"+targetMethod+ "] 호출 되었습니다." );
	}
	
	public void afterLog(JoinPoint joinPoint) {
		String targetClass  = joinPoint.getTarget().getClass().getSimpleName();
		String targetMethod = joinPoint.getSignature().getName();
		
		logger.info( "["+targetClass+"_"+targetMethod+ "] 종료 되었습니다." );
	}
	
	
	public Object aroundLog(ProceedingJoinPoint joinPoint)  {
		
		String targetClass  = joinPoint.getTarget().getClass().getSimpleName();
		String targetMethod = joinPoint.getSignature().getName();
		
		logger.info( "["+targetClass+"_"+targetMethod+ "] 호출 되었습니다." );
		logger.info(targetClass+"_"+targetMethod + "_parameter: " 
				+ Arrays.toString(joinPoint.getArgs()));
		
		//시간 확인
		long startTime = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			long finishTime = System.currentTimeMillis();
			
			logger.info( "["+targetClass+"_"+targetMethod+ "] 종료 되었습니다." );
			logger.info(targetClass+"_"+targetMethod + "실행시간 :"
					+ (finishTime-startTime)+" ms" );
		}
		return result;
	}
	
	
	
}
