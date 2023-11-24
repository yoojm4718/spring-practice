package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;
import com.example.model.Song;
import com.example.services.VehicleService;

public class Example15 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // AOP를 적용하면 해당 bean을 참조할 때 프록시 객체가 참조됨
        VehicleService vehicleService = context.getBean(VehicleService.class); // class com.example.services.VehicleService$$SpringCGLIB$$0

        System.out.println(vehicleService.getClass());

        Song song = new Song("Bohemian Rhapsody", "Queen");
        // Around 테스트
        System.out.println(vehicleService.playMusic(true, song));
        System.out.println(vehicleService.moveVehicle(true));

        // Before 테스트
        System.out.println(vehicleService.playMusic(false, song)); // ... java.lang.RuntimeException: Vehicle not started

        context.close();

    }
}
