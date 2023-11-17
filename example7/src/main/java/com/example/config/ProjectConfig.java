package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.beans.Person;
import com.example.beans.Vehicle;

@Configuration
public class ProjectConfig {

    @Bean
    public Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Porsche");
        return veh;
    }

    // Wiring의 기본은 해당 bean이 특정 bean을 의존한다는 것을 "Spring이 알 수 있도록 명시하는 것!"

    // Wiring Option 1. Bean Method를 직접 호출
    // : 절대 권장되지 않음, DI가 전혀 불가능한 형태인 듯
    // : vehicle bean이 두 번 등록된다고 생각할 수 있지만, 이건 Spring이 알아서 한 번만 등록함 (Spring은 기본적으로 하나의 bean만 생성, 여러 bean을 생성하려면 다른 방법 사용)
    // : person bean이 vehicle에 디펜던시를 가지므로, vehicle이 먼저 bean으로 등록됨. (순서 보장)
    @Bean("PersonWiredByBeanMethod")
    public Person personWiredByBeanMethod() {
        var per = new Person();
        per.setName("Jungmin");
        // vehicle() bean method를 직접 호출
        per.setVehicle(vehicle());
        return per;
    }

    // Wiring Option 2. Parameter
    // : 매개변수로 의존성을 명시하는 방법.
    // : Spring은 이렇게 매개변수가 명시된 것만으로도 의존성을 유추할 수 있음, application context가 직접 의존성 주입
    @Bean("PersonWiredByParameter")
    public Person personWiredByParameter(Vehicle vehicle) {
        var per = new Person();
        per.setName("Hellobit");
        per.setVehicle(vehicle);
        return per;
    }
}