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

    // @Around("execution(* com.example.services.*.*(..))")
    // public void log(ProceedingJoinPoint joinPoint) throws Throwable {
    //     logger.info(joinPoint.getSignature().toString() + " method execution start");
    //     Instant start = Instant.now();
    //     // : joinPoint.proceed()를 통해 Pointcut 메소드 실행
    //     joinPoint.proceed();
    //     Instant finish = Instant.now();
    //     long timeElapsed = Duration.between(start, finish).toMillis();
    //     logger.info("Time took to execute the method : " + timeElapsed);
    //     logger.info(joinPoint.getSignature().toString() + " method execution end");
    // }

    // 어노테이션 기반일 때에는 메소드 내용을 동일하고, expression을 @annotation으로, 그 안에는 커스텀 어노테이션을 아래와 같이 작성
    @Around("@annotation(com.example.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        // : joinPoint.proceed()를 통해 Pointcut 메소드 실행
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : " + timeElapsed);
        logger.info(joinPoint.getSignature().toString() + " method execution end");
    }

    @AfterThrowing(value = "execution(* com.example.services.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.SEVERE, joinPoint.getSignature() + " An exception thrown with the help of" +
                " @AfterThrowing which happened due to : "+ex.getMessage());
    }

    @AfterReturning(value = "execution(* com.example.services.*.*(..))", returning = "retVal")
    public void logStatus(JoinPoint joinPoint, Object retVal) {
        logger.log(Level.INFO, joinPoint.getSignature() + " Method successfully processed with the status " +
                retVal.toString());
    }

}
