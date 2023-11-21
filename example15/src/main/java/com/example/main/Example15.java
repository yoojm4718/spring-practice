package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;
import com.example.model.Song;
import com.example.services.VehicleService;

public class Example15 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        VehicleService vehicleService = context.getBean(VehicleService.class);
        
        // AOP를 사용하지 않는 예시 : playSong
        Song song = new Song("Bohemian Rhapsody", "Queen");
        System.out.println(vehicleService.playMusic(true, song));

        context.close();

    }
}
