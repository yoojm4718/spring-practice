package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;

public class Example7 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var vehicle = context.getBean(Vehicle.class);
        System.out.println(vehicle.getName()); // Porsche

        // Wiring Option 1. Bean Method를 직접 호출
        var personWiredByBeanMethod = context.getBean("PersonWiredByBeanMethod", Person.class);
        System.out.println(personWiredByBeanMethod.getName()); // Jungmin
        System.out.println(personWiredByBeanMethod.getVehicle().getName()); // Porsche
        
        // Wiring Option 2. Parameter
        var personWiredByParameter = context.getBean("PersonWiredByParameter", Person.class);
        System.out.println(personWiredByParameter.getName()); // Hellobit
        System.out.println(personWiredByParameter.getVehicle().getName()); // Porsche

        context.close();

    }
}
