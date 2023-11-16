package com.example1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example1.beans.Vehicle;

// @Configuration
// : IoC Container가 해당 클래스의 내용을 확인하도록 설정
// : "이 클래스가 Bean 메소드를 가지고 있다"
@Configuration
public class ProjectConfig {

    // @Bean
    // : 메소드에 Bean 등록을 통해 IoC Container에 해당 메소드의 리턴값을 등록
    // : 다른 메소드와 달리 명사 위주의 네이밍 컨벤션으로 메소드 선언
    @Bean 
    Vehicle vehicle() {
        var veh = new Vehicle();

        veh.setName("Audi 8");

        return veh;
    }

    @Bean
    String hello() {
        return "Hello World";
    }

    @Bean
    Integer number() {
        return 20;
    }
}