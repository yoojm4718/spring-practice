package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
// @Scope
// : @Scope 어노테이션을 통해 해당 bean의 scope를 설정할 수 있음.

// Singleton Bean Scope
// : Scope를 BeanDefinition.SCOPE_SINGLETON으로 설정하면 or 그냥 없이 두면, 해당 bean은 Singleton Bean Scope를 가짐
// : 이는 Singleton 디자인 패턴이랑 매우 유사하게, bean에 대해 하나의 인스턴스만 생성됨.
// : 다만 차이점은, "각 bean에 대해서" 하나의 인스턴스가 생성됨. 즉, bean이 여러 개라면 인스턴스 자체는 여러 개가 될 수 있음. 1 bean = 1 instance

// Singleton Bean Scope의 use cases
// : 멀티 스레드 환경에서, Singleton scope는 race condition이라는 문제를 발생시킬 수 있음.
// : (synchronization으로 해결할 수는 있지만 권장되지 않음. - 애플리케이션의 복잡성과 성능 저하)
// : 따라서, 아래의 조건을 따르는 상황에 대해서만 Singleton scope를 사용하는 것이 좋음
//      1. 클래스에 비즈니스 로직만을 포함하는 경우 = 필드 없이 메소드만 있는 경우
//      2. 필드가 있다면, immutable 해야 함. (필드가 업데이트 되는 로직이 있으면 안됨.)
//          -> 2번의 경우 때문에, 생성자 기반의 Wiring이 권장되는 것!! (final로 필드 선언 가능)
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Person {
    private String name;

    private final Vehicle vehicle;
    
    @Autowired
    public Person(Vehicle vehicle) {
        System.out.println("Person instantiated");
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Jungmin";
    }
}
