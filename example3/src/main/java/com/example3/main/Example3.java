package com.example3.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example3.beans.Vehicle;
import com.example3.config.ProjectConfig;

public class Example3 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        // Primary Bean 출력
        // 만약 @Primary 설정된 Bean이 여러 개라면, 똑같이 NoUniqueBeanDefinitionException 발생
        var primaryVehicle = context.getBean(Vehicle.class);
        System.out.println(primaryVehicle.getName());

        context.close();

    }
}
