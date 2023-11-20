package com.example.implementations;

import org.springframework.stereotype.Component;

import com.example.interfaces.Speakers;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class SonySpeakers implements Speakers {
    private String name;

    public SonySpeakers() {
        System.out.println("SonySpeakers instantiated");
    }

    @Override
    public void makeSound() {
        System.out.println("Sony Speakers: Boom Boom");
    }

    @PostConstruct
    public void initialize() {
        this.name = "Sony Speakers";
    }
}
