package com.example.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String name;

    public Vehicle() {
        System.out.println("Vehicle instantiated");
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }
}
