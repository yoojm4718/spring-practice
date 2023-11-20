package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    // Wiring Option 5. @Autowired on constructor
    // : 생성자에 @Autowired 설정
    // : 가장 권장되는 방법
    // : 멤버 변수를 final로 설정할 수 있음. 따라서 보안에서의 장점이 있음
    // : 만약 생성자가 하나라면, @Autowired 어노테이션을 적지 않아도 IoC container에서 알아서 주입해 줌 (생성자 여러 개라면 필요)
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
