package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan
// : @ComponentScan 어노테이션을 configuration 클래스에 적용하면, Bean 등록을 위해 어떤 패키지를 스캔해야 하는지 알려줄 수 있음
// : Bean 등록을 위해 모든 패키지를 다 스캔할 수 없으므로, 어떤 패키지를 스캔할지에 대한 책임을 개발자에게 부여
@ComponentScan(basePackages = "com.example4.beans")
public class ProjectConfig {
}