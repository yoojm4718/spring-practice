package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;

public class Example5 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        var vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle.getName()); // Hyundai
        vehicle.printHello();

        context.close();

    }
}
