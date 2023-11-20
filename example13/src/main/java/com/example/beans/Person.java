package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
// Eager Instantiation vs Lazy Instantiation
// : default는 Eager Instantiation으로, context가 생성되면서 모든 bean이 인스턴스화 됨.
// : @Lazy 어노테이션을 사용하면, Lazy Instantiation이 적용되어 해당하는 bean을 사용하는 시점에 인스턴스화 됨.
// :    -> 특정 bean이 무조건 필요하지 않을 수 있기 때문에(드물게 사용되는 로직이 있을 수도), 사용할 때에만 생성된다면 성능상 이점
// : 웬만한 상황에서는 Eager을 사용해야 함, 그 이유는
// :    - Lazy의 경우 성능 최적화가 될 수는 있지만, 인스턴스화 과정에서 오류가 발생한다면 실행되고 있는 애플리케이션 전체가 중단 되어버림
// :    - Eager의 경우 인스턴스화 과정에서 오류가 발생해도, 애플리케이션을 실행하는 순간에 오류가 발생하기 때문에 중간에 멈추는 일은 없음
@Lazy
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
