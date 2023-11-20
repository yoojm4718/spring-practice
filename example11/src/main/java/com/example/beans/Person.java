package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Person {
    private String name;

    private final Vehicle vehicle;
    
    // 같은 타입의 여러 bean이 존재할 떄, 어떤 bean을 주입할까?
    // : 한 context 내에서 같은 타입의 여러 개의 bean이 존재하면, 어떤 것을 DI해야 하는지 모호해진다. 따라서 아래의 프로세스로 주입할 bean을 결정한다.
    // : 1. 매개변수의 이름과 동일한 이름의 bean을 찾는다.
    // @Autowired
    // public Person(Vehicle vehicle2) {
    //     System.out.println("Person instantiated");
    //     this.vehicle = vehicle2;
    // }
    // : 2. 1번에서 못 찾았다면, @Primary bean을 찾는다.
    // @Autowired
    // public Person(Vehicle vehicle) {
    //     System.out.println("Person instantiated");
    //     this.vehicle = vehicle;
    // }
    // : 3. @Qualifier 어노테이션을 사용한다. -> Autowire시에 어떤 이름의 bean을 사용할 것인지 직접 명시할 수 있음
    @Autowired
    public Person(@Qualifier("vehicle3") Vehicle vehicle) {
        System.out.println("Person instantiated");
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Jungmin";
    }
}
