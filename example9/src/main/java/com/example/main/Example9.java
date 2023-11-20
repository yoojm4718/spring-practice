package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;

public class Example9 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var vehicle = context.getBean(Vehicle.class);
        var person = context.getBean(Person.class);
        System.out.println(vehicle.getName()); // Porsche
        System.out.println(person.getName()); // Jungmin
        System.out.println(person.getVehicle().getName()); // Porsche

        context.close();

    }
}
