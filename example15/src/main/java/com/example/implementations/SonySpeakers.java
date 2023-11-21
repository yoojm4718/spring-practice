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
public class SonySpeakers implements Speakers {
    private String name;

    public SonySpeakers() {
        System.out.println("SonySpeakers instantiated");
    }

    @Override
    public String makeSound(Song song) {
        return "Sony Speakers Playing : " + song.getTitle() + " by " + song.getSingerName();
    }

    @PostConstruct
    public void initialize() {
        this.name = "Sony Speakers";
    }
}
