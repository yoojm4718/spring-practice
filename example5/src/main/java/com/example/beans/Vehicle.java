package com.example.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Vehicle {
    private String name;

    // @PostConstruct
    // : 해당 어노테이션을 통해 application context가 인스턴스를 생성 후 Bean으로 등록한 직후의 동작을 정의할 수 있음
    @PostConstruct
    public void initialize() {
        System.out.println("===== PostConstruct =====");
        this.name = "Hyundai";
    }
    
    // @PreDestroy
    // : 해당 어노테이션을 통해 application context가 닫힐 때(context.close()) 해당 Bean의 동작을 정의할 수 있음
    // : DB Connection 해제 등의 작업을 하면 좋음
    @PreDestroy
    public void destroy() {
        System.out.println("===== PreDestroy =====");
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }
}
