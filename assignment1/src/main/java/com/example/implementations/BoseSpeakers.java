package com.example.implementations;

import org.springframework.stereotype.Component;

import com.example.interfaces.Speakers;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class BoseSpeakers implements Speakers {
    private String name;

    public BoseSpeakers() {
        System.out.println("BoseSpeakers instantiated");
    }

    @Override
    public void makeSound() {
        System.out.println("Bose Speakers: Boom Boom");
    }

    @PostConstruct
    public void initialize() {
        this.name = "Bose Speakers";
    }
}
