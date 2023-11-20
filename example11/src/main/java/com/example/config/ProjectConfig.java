package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.beans.Vehicle;

@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {

    @Bean
    public Vehicle vehicle1() {
        var vehicle1 = new Vehicle();
        vehicle1.setName("Porsche");
        return vehicle1;
    }

    // 2번 프로세스 - 매개변수와 이름이 동일한 bean이 없다면 Primary bean을 주입
    // @Primary
    @Bean
    public Vehicle vehicle2() {
        var vehicle2 = new Vehicle();
        vehicle2.setName("Hyundai");
        return vehicle2;
    }

    @Bean
    public Vehicle vehicle3() {
        var vehicle3 = new Vehicle();
        vehicle3.setName("Bugati");
        return vehicle3;
    }
}