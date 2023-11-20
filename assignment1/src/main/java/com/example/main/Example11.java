package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.config.ProjectConfig;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;

public class Example11 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var person = context.getBean(Person.class);

        System.out.println("=== Registered Speakers Beans ===");
        for (String s: context.getBeanNamesForType(Speakers.class)) System.out.println(s);
        System.out.println("=== Registered Tyres Beans ===");
        for (String s: context.getBeanNamesForType(Tyres.class)) System.out.println(s);

        System.out.println(person.getName() + " has " + person.getVehicle().getName()
                            + " which has " + person.getVehicle().getVehicleService().getSpeakers()
                            + " and " + person.getVehicle().getVehicleService().getTyres());

        person.getVehicle().getVehicleService().getSpeakers().makeSound();
        person.getVehicle().getVehicleService().getTyres().rotate();

        context.close();

    }
}
