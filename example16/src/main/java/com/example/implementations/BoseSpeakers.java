package com.example.implementations;

import org.springframework.stereotype.Component;

import com.example.interfaces.Speakers;
import com.example.model.Song;

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
    public String makeSound(Song song) {
        return "Bose Speakers Playing : " + song.getTitle() + " by " + song.getSingerName();
    }

    @PostConstruct
    public void initialize() {
        this.name = "Bose Speakers";
    }
}
