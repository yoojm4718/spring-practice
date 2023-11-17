package com.example2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example2.beans.Vehicle;

@Configuration
public class ProjectConfig {

    // 동일한 리턴 타입을 가진 3개의 메소드에 Bean 등록

    @Bean 
    Vehicle vehicle1() {
        var veh = new Vehicle();

        veh.setName("Audi 8");

        return veh;
    }
    
    @Bean 
    Vehicle vehicle2() {
        var veh = new Vehicle();

        veh.setName("Ionic 6");

        return veh;
    }

    @Bean 
    Vehicle vehicle3() {
        var veh = new Vehicle();

        veh.setName("Torres");

        return veh;
    }

    // Bean 이름 지정
    // : name 매개변수로 Bean 이름 지정 가능
    @Bean(name = "sonataVehicle")
    Vehicle vehicle4() {
        var veh = new Vehicle();
        
        veh.setName("Sonata");
        
        return veh;
    }
    
    // : value 매개변수로도 Bean 이름 지정 가능
    @Bean(value = "tucsonVehicle")
    Vehicle vehicle5() {
        var veh = new Vehicle();
        
        veh.setName("Tucson");
        
        return veh;
    }
    
    // : 기본 매개변수로도 이름 지정 가능
    @Bean("palisadeVehicle")
    Vehicle vehicle6() {
        var veh = new Vehicle();

        veh.setName("Palisade");

        return veh;
    }
}