package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.BeanDefinition;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
// Prototype Bean Scope
// : Scope를 BeanDefinition.SCOPE_PROTOTYPE으로 설정하면, 해당 bean은 Prototype Bean Scope를 가짐
// : 이렇게 되면 bean을 참조할 때마다 새로운 인스턴스가 생성됨. -> race condition이 발생할 일이 없음
// : 드물게 사용되고, bean의 state가 자주 바뀌는 경우에만 사용.
// : 또한 이 경우, 처음에 인스턴스화 되는게 아니라 참조할 때 인스턴스화가 됨. 그래서 eager/lazy instantiation 개념이 애초에 없음!
// : 만약 Singleton bean에 Prototype bean이 의존성 주입된다면, 그 주입된 인스턴스는 Singleton이 됨 -> 주의!!
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Person {
    private String name;

    private final Vehicle vehicle;
    
    @Autowired
    public Person(Vehicle vehicle) {
        System.out.println("Person instantiated");
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Jungmin";
    }
}
