package com.example2.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example2.beans.Vehicle;
import com.example2.config.ProjectConfig;

public class Example2 {
    public static void main(String[] args) {

        // Application Context 초기화
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // NoUniqueBeanDefinitionException
        // : 아래와 같이 코드를 작성하면 Vehicle 타입으로 등록된 Bean이 6개이므로, 가져올 Bean을 특정할 수 없음
        // var vehicle = context.getBean(Vehicle.class);

        // 따라서 메소드명을 매개변수로 넘겨서 식별
        var vehicle1 = context.getBean("vehicle1", Vehicle.class);
        System.out.println(vehicle1.getName());
        var vehicle2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println(vehicle2.getName());
        var vehicle3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println(vehicle3.getName());
        
        // Custom Bean 이름
        var vehicle4 = context.getBean("sonataVehicle", Vehicle.class);
        System.out.println(vehicle4.getName());
        var vehicle5 = context.getBean("tucsonVehicle", Vehicle.class);
        System.out.println(vehicle5.getName());
        var vehicle6 = context.getBean("palisadeVehicle", Vehicle.class);
        System.out.println(vehicle6.getName());

        context.close();

    }
}
