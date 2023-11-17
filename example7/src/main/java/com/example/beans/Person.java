package com.example.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    // POJO 클래스 내부에 다른 클래스 자료형의 멤버 변수를 선언하더라도, Spring이 모든 클래스를 스캔할 수 없기 때문에 
    // 따로 Wiring 작업이 필요한 것.
    private Vehicle vehicle;

    public Person() {
        System.out.println("Person instantiated");
    }
}
