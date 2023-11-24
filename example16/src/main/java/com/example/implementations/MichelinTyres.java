package com.example.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.interfaces.Tyres;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Primary
public class MichelinTyres implements Tyres {
    private String name;

    public MichelinTyres() {
        System.out.println("MichelinTyres instantiated");
    }
    
    @Override
    public String rotate() {
        return "Michelin tyre rolls...";
    }

    @Override
    public String stop() {
        return "Michelin tyre stopped";
    }

    @PostConstruct
    public void initialize() {
        this.name = "Michelin Tyres";
    }
}
