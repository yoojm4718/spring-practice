package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Getter
@Component
public class Person {
    private String name;

    private Vehicle vehicle;
    
    public Person() {
        System.out.println("Person instantiated");
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Wiring Option 4. @Autowired on setter method
    // : setter method에 @Autowired 설정, 방식만 다를 뿐 Option 3이랑 크게 다르지 않음
    // : final로 선언할 수 없기 때문에, 그리고 readonly 친화적이지 않기 때문에 권장되지 않음.
    // : 추가로, stereotype 뿐만이 아닌 @Bean으로 등록된 bean도 이 방법으로 주입 가능
    @Autowired
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Jungmin";
    }
}
