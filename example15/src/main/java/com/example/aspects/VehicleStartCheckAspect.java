package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
// @Order 어노테이션으로 Aspect 간의 순서를 지정할 수 있음
@Order(1)
public class VehicleStartCheckAspect {

    // Before advice
    // : args(vehicleStarted, ..) -> 이 expression으로 Pointcut의 매개변수 또한 인터셉트 할 수 있음
    @Before("execution(* com.example.services.*.*(..)) && args(vehicleStarted, ..))")
    public void checkVehicleStarted(JoinPoint joinPoint, boolean vehicleStarted) throws Throwable {
        if(!vehicleStarted) throw new RuntimeException("Vehicle not started");
    }
}
