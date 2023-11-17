package com.example.main;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;

public class Example6 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 10까지의 랜덤 정수 저장
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("Random Number: " + randomNumber);

        // Lambda를 이용한 Supplier
        Supplier<Vehicle> porscheSupplier = () -> {
            var porscheVehicle = new Vehicle();
            porscheVehicle.setName("Porsche");

            return porscheVehicle;
        };
        
        // context.registerBean()
        // : application context에 직접 bean을 등록하는 방법
        // : beanName, beanClass를 지정하고, bean 생성시 실행될 로직이 포함된 supplier를 전달 (lambda)
        // : 아래 경우와 같이 런타임에 조건부로 bean 등록을 해야할 때 주로 사용
        // : Spring 5 이후부터 지원
        if(randomNumber % 2 == 0) context.registerBean("porscheVehicle", Vehicle.class, porscheSupplier);
        else context.registerBean("hyundaiVehicle", Vehicle.class, () -> {
            var hyundaiVehicle = new Vehicle();
            hyundaiVehicle.setName("Hyundai");
    
            return hyundaiVehicle;
        });

        Vehicle porscheVehicle = null;
        Vehicle hyundaiVehicle = null;

        // NoSuchBeanDefinitionException을 처리해주어야 함
        try {
            porscheVehicle = context.getBean("porscheVehicle", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Porsche Vehicle is not registered");
        }

        try {
            hyundaiVehicle = context.getBean("hyundaiVehicle", Vehicle.class);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Hyundai Vehicle is not registered");
        }

        if(porscheVehicle != null) System.out.println(porscheVehicle.getName());
        else System.out.println(hyundaiVehicle.getName());

        context.close();

    }
}
