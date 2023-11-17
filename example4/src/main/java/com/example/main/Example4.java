package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;

public class Example4 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        // @Component가 적용된 Vehicle 클래스가 인스턴스화 되어 Bean으로 등록
        var vehicle = context.getBean(Vehicle.class);
        // 아래는 null이 출력됨. 그 이유는 메서드 기반 Bean 등록이 아니기 때문에, 등록되는 인스턴스를 개발자가 제어하는 것이 아닌 application context가 제어하기 때문
        System.out.println(vehicle.getName()); // null
        vehicle.printHello();

        context.close();

    }
}
