package com.example.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation based AOP
// : 커스텀 어노테이션으로 AOP를 구현할 수 있음.
// : 이때는 특정한 메소드에 AOP를 적용할 때 좋은 방법!!
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAspect {
}
