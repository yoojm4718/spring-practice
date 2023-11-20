package com.example.implementations;

import org.springframework.stereotype.Component;

import com.example.interfaces.Tyres;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class BridgeStoneTyres implements Tyres {
    private String name;

    public BridgeStoneTyres() {
        System.out.println("BridgeStoneTyres instantiated");
    }

    @Override
    public void rotate() {
        System.out.println("BridgeStone tyre rolls...");
    }

    @PostConstruct
    public void initialize() {
        this.name = "BridgeStone Tyres";
    }
}
