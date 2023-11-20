package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 아래 두 가지 방식으로도 Scan 할 패키지/클래스 선정 가능
@ComponentScan(basePackages = {"com.example.implementations", "com.example.services"})
@ComponentScan(basePackageClasses = {com.example.beans.Person.class, com.example.beans.Vehicle.class})
public class ProjectConfig {
}