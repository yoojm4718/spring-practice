package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;

public class Example11 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var vehicle1 = context.getBean("vehicle1", Vehicle.class);
        var vehicle2 = context.getBean("vehicle2", Vehicle.class);
        var vehicle3 = context.getBean("vehicle3", Vehicle.class);
        var person = context.getBean(Person.class);

        System.out.println(vehicle1.getName()); // Porsche
        System.out.println(vehicle2.getName()); // Hyundai
        System.out.println(vehicle3.getName()); // Bugati
        System.out.println(person.getName()); // Jungmin
        System.out.println(person.getVehicle().getName()); // Porsche

        context.close();

    }
}
