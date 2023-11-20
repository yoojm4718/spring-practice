package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.config.ProjectConfig;

public class Example12 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var person1 = context.getBean(Person.class);
        var person2 = context.getBean(Person.class);
        // Singleton Bean Scope에서는 하나의 bean에 하나의 instance만 생성
        System.out.println(person1 == person2); // true

        context.close();

    }
}
