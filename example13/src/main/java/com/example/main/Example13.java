package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Person;
import com.example.config.ProjectConfig;

public class Example13 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 이 시점에는 아직 Person bean을 사용하기 전이므로 인스턴스화 되지 않음
        System.out.println("Person bean not instantiated yet");
        
        var person = context.getBean(Person.class);
        System.out.println("Person bean instantiated");

        context.close();

    }
}
