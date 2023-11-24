package com.example.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.interfaces.LogAspect;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.model.Song;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class VehicleService {
    private Speakers speakers;
    private Tyres tyres;

    private Logger logger = Logger.getLogger(VehicleService.class.getName());

    @Autowired
    public VehicleService(@Qualifier("sonySpeakers") Speakers speakers, Tyres tyres) {
        System.out.println("VehicleService instantiated");
        this.speakers = speakers;
        this.tyres = tyres;
    }

    // 아래와 같이 AOP 적용할 메소드에 어노테이션 지정
    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song) {
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted) {
        return tyres.rotate();
    }
}
