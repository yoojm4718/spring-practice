package com.example.beans;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @Component
// : @Component 어노테이션을 지정한 POJO 클래스는 Bean 스캔의 대상이 됨
// : 이러한 @Component와 같은 어노테이션을 "stereotype" 어노테이션이라고 하며, 그 종류에는 @Service, @Repository, @Controller 등이 있음
// : @Component가 다른 stereotype 어노테이션의 상위 어노테이션
// 
// 특징
// 1. 클래스에 @Component를 지정하기 때문에, 이 방식은 오로지 하나의 인스턴스만을 Bean에 등록할 때 사용
// 2. @Bean 방식과 달리 "내가 선언한" 클래스 타입으로만 Bean 등록 가능
// 3. 코드 작성 매우 간편
// 4. 인스턴스 생성 과정에서 개발자는 아무런 제어 권한이 없음
@Component
public class Vehicle {
    private String name;

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }
}
