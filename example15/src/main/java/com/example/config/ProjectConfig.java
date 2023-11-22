package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.example.implementations", "com.example.services", "com.example.aspects"})
@ComponentScan(basePackageClasses = {com.example.beans.Person.class, com.example.beans.Vehicle.class})
// Config 클래스에 아래 어노테이션을 추가해야 AOP 사용 가능
@EnableAspectJAutoProxy
public class ProjectConfig {
}