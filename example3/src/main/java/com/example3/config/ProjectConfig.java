package com.example3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example3.beans.Vehicle;

@Configuration
public class ProjectConfig {

    @Bean(name = "sonataVehicle")
    Vehicle vehicle4() {
        var veh = new Vehicle();
        
        veh.setName("Sonata");
        
        return veh;
    }
    

    // @Primary
    // : 같은 타입의 여러 Bean이 등록될 때, 기본 Bean을 설정하는 어노테이션
    @Primary
    @Bean(value = "tucsonVehicle")
    Vehicle vehicle5() {
        var veh = new Vehicle();
        
        veh.setName("Tucson");
        
        return veh;
    }
    
    @Bean("palisadeVehicle")
    Vehicle vehicle6() {
        var veh = new Vehicle();

        veh.setName("Palisade");

        return veh;
    }
}