package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class VehicleService {
    private Speakers speakers;
    private Tyres tyres;

    @Autowired
    public VehicleService(@Qualifier("sonySpeakers") Speakers speakers, Tyres tyres) {
        System.out.println("VehicleService instantiated");
        this.speakers = speakers;
        this.tyres = tyres;
    }
}
