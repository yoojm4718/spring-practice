package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.time.Instant;
import java.time.Duration;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
    
    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    // AspectJ Pointcut Expression
    // : https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html#aop-pointcuts-examples
    // : execution(modifiers-pattern?
    //              ret-type-pattern
    //              declaring-type-pattern?name-pattern(param-pattern)
    //              throws-pattern?)
    @Around("execution(* com.example.services.*.*(..))")
    // : ProceedingJoinPoint joinPoint -> Pointcut 메소드와 관련된 정보를 담는 객체 - 매개변수로 전달받음
    // : 이때, Around는 중간에 메소드 실행 시점을 넣어주어야 하므로, ProceedingJoinPoint를 사용해야 함. (다른 Advice에서는 JoinPoint 사용)
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        // : joinPoint.proceed()를 통해 Pointcut 메소드 실행
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : " + timeElapsed);
        logger.info(joinPoint.getSignature().toString() + " method execution end");
    }

    // @AfterThrowing
    // : throwing 파라미터를 지정해주면, 그 값이랑 동일한 이름의 매개변수에 Exception 객체를 넣어줌
    // : 그 외에도 advice 어노테이션 들은 여러 파라미터를 지원
    @AfterThrowing(value = "execution(* com.example.services.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.SEVERE, joinPoint.getSignature() + " An exception thrown with the help of" +
                " @AfterThrowing which happened due to : "+ex.getMessage());
    }

    // @AfterReturning
    // : returning 파라미터를 지정해주면, 그 값이랑 동일한 이름의 매개변수에 리턴값을 넣어줌
    @AfterReturning(value = "execution(* com.example.services.*.*(..))", returning = "retVal")
    public void logStatus(JoinPoint joinPoint, Object retVal) {
        logger.log(Level.INFO, joinPoint.getSignature() + " Method successfully processed with the status " +
                retVal.toString());
    }

}
