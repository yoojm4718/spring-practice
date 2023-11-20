package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.config.ProjectConfig;

public class Example14 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("Hello");
        var person1 = context.getBean(Person.class);
        var person2 = context.getBean(Person.class);
        // Prototype Bean Scope에서는 참조할 떄마다 새로 인스턴스화 됨
        System.out.println(person1 == person2); // false

        context.close();

    }
}
