package kr.or.nextit.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAspect {
	
	private final Logger logger
		= LoggerFactory.getLogger(this.getClass());
	
	/*@Before("execution(public * kr.or.nextit.*.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		String targetClass  = joinPoint.getTarget().getClass().getSimpleName();
		String targetMethod = joinPoint.getSignature().getName();
		
		logger.info( "["+targetClass+"_"+targetMethod+ "] 호출 되었습니다." );
		logger.info(targetClass+"_"+targetMethod + "_parameter: " 
				+ Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("execution(public * kr.or.nextit.*.service.*.*(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String targetClass  = joinPoint.getTarget().getClass().getSimpleName();
		String targetMethod = joinPoint.getSignature().getName();
		
		logger.info( "["+targetClass+"_"+targetMethod+ "] 종료 되었습니다." );
	}*/
	
	
	
	@Around("execution(public * kr.or.nextit.login.*.*(..)) || execution(public * kr.or.nextit.member.*.*(..)) || execution(public * kr.or.nextit.free.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint)  {
		
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
