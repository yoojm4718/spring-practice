package com.example1.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example1.beans.Vehicle;
import com.example1.config.ProjectConfig;

public class Example1 {
    public static void main(String[] args) {
        // Bean을 사용하지 않는 경우
        var vehicle1 = new Vehicle();
        vehicle1.setName("Porsche");
        System.out.println(vehicle1.getName());
        
        
        // Bean을 사용하는 경우

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 리턴 타입을 기반으로 등록된 Bean을 get
        var vehicle2 = context.getBean(Vehicle.class);
        System.out.println(vehicle2.getName());

        var hello = context.getBean(String.class);
        System.out.println(hello);
        var num = context.getBean(int.class);
        System.out.println(num);

        context.close();

    }
}
