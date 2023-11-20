package com.example.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Vehicle {
    private String name;

    public Vehicle() {
        System.out.println("Vehicle instantiated");
    }

    @PostConstruct
    public void initialize() {
        this.name = "Porsche";
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }
}
